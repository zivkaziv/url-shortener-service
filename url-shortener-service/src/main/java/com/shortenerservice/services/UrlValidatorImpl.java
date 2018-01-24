package com.shortenerservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class UrlValidatorImpl implements UrlValidator{

    //In this method we can check all the validations we want from the url
    public boolean isUrlValid(String url) {
        boolean valid = true;
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            valid = false;
        }
        return valid;
    }
}
