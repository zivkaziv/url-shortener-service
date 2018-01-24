package com.shortenerservice.controllers;

import com.google.gson.Gson;
import com.shortenercommon.models.ShortenUrl;
import com.shortenercommon.services.ShortenUrlService;
import com.shortenerservice.services.UrlHashService;
import com.shortenerservice.services.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ShortenerController {
    public static final int NUMBER_OF_RETRIES_TO_SAVE_URL = 50;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShortenUrlService shortenUrlService;

    @Autowired
    private UrlValidator urlValidator;

    @Autowired
    private UrlHashService urlHashService;

    //This api
    //Check if the URL is valid - if not - return 400
    //Try to find unique id - if not - return 500
    //If found, save it and return the short url
    @RequestMapping(value="/url",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    public void shortenUrl( HttpServletRequest request,
                            @RequestBody ShortenUrl urlData,
                           HttpServletResponse response) throws IOException {
        try {
            //Validate
            if (!urlValidator.isUrlValid(urlData.getUrl())) {
                //TODO add metric how many invalid urls have
                log.debug("Url " + urlData.getUrl() + " is not valid - won't handle the request");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "URL is not valid");
            } else {
                //Hashing and save the data
                //In order to handle hash collision we are going to try X times of retries to
                //generate unique ID in case two different URLs create the same id
                Boolean isFoundUniqueId = false;
                String id = urlHashService.hash(urlData.getUrl());
                for (int tries = 0; tries < NUMBER_OF_RETRIES_TO_SAVE_URL; tries++) {
                    String url = shortenUrlService.findUrlAndStoreEmptyValueInCaseItsEmpty(id);
                    if (url != null && !url.equals(urlData.getUrl())) {
                        //TODO add metric how many failures we have
                        id = urlHashService.hashOnUrlWithFirstChar(urlData.getUrl(), tries);
                    } else {
                        isFoundUniqueId = true;
                        break;
                    }
                }

                //We've found unique id - save it and response
                if (isFoundUniqueId) {
                    urlData.fillId(id);
                    urlData.setReturnedUrl(request.getRequestURL().toString(), request.getRequestURI());
                    shortenUrlService.storeUrl(urlData);
                    log.debug("The url " + urlData.getUrl() + " has been saved with id " + urlData.getId());

                    //Return the object
                    String json = new Gson().toJson(urlData);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                } else {//We didn't find unique id - send internal server error
                    //TODO add metric how many total times we were unable to find id
                    log.error("The url " + urlData.getUrl() + " has not saved because we failed to find unique id");
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to find unique id");
                }
            }
        }catch (Exception e){
            log.error(e.toString(),e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Failed to create URL");
        }
    }
}
