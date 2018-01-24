package com.shortenercommon.services;

import com.google.gson.Gson;
import com.shortenercommon.repositories.UrlStoreRepository;
import com.shortenercommon.models.ShortenUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Component
public class ShortenUrlServiceImpl implements ShortenUrlService {
    //In this class
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UrlStoreRepository urlStoreRepository;

    //Find the url in the storage repository and return the answer.
    //In case we want to add more business logic for the find url it will be here
    //(e.g. adding analytics for each url)
    @Override
    public String findUrl(String id) throws IOException {
        log.debug("Search for id - " + id);
        String urlAsJson = urlStoreRepository.findById(id);

        if(urlAsJson != null && !urlAsJson.isEmpty()){
            ShortenUrl shortenUrl = new Gson().fromJson(urlAsJson, ShortenUrl.class);
            log.debug("Found url - " + shortenUrl.getUrl() + " for id " + shortenUrl.getId() );
            return shortenUrl.getUrl();
        }
        log.debug("Not found url for id " + id);
        return null;
    }

    //Find the url in the storage repository and in case it's available save there empty value.
    //Use transaction in order to be sure this id won't be taken
    @Override
    public String findUrlAndStoreEmptyValueInCaseItsEmpty(String id) throws IOException {
        log.debug("Search for id - " + id);
        String urlAsJson = urlStoreRepository.findByIdAndStoreEmptyValueWithTransaction(id);

        if(urlAsJson != null && !urlAsJson.isEmpty()){
            ShortenUrl shortenUrl = new Gson().fromJson(urlAsJson, ShortenUrl.class);
            log.debug("Found url - " + shortenUrl.getUrl() + " for id " + shortenUrl.getId() );
            return shortenUrl.getUrl();
        }
        log.debug("Not found url for id " + id);
        return null;
    }

    //Store the URL in the selected repositories
    @Override
    public void storeUrl(ShortenUrl shortenUrl) throws IOException {
        String urlAsJson = new Gson().toJson(shortenUrl);
        urlStoreRepository.set(shortenUrl.getId(),urlAsJson);
    }
}
