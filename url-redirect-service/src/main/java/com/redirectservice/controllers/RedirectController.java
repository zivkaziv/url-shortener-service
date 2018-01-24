package com.redirectservice.controllers;

import com.shortenercommon.services.ShortenUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RedirectController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShortenUrlService shortenUrlService;

    //This api gets the unique id, search it over the DB.
    //Found - return redirect to eh full URL
    //Didn't find - return 404
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void redirectToUrl(@PathVariable String id,
                              HttpServletResponse response) throws Exception {
        try {
            if (id != null && !id.isEmpty()) {
                log.debug("Search for id " + id + " to redirect");
                final String url = shortenUrlService.findUrl(id);
                if (url != null) {
                    log.debug("Found for id " + id + " the url " + url);
                    response.addHeader("Location", url);
                    response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                } else {
                    //TODO add metric how many failures to find id
                    log.warn("Not found for id " + id + " the url " + url);
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } else {
                //TODO add metric how many empty ids sent
                log.warn("id is empty or null");
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "id is empty");
            }
        }catch (Exception e){
            log.error(e.toString(),e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    "Failed to handle the redirect request");
        }
    }
}
