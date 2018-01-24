package com.shortenercommon.services;

import com.shortenercommon.models.ShortenUrl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Component
public interface ShortenUrlService {
    String findUrl(String id) throws IOException;
    //In case the id is free store there empty value
    String findUrlAndStoreEmptyValueInCaseItsEmpty(String id) throws IOException;

    void storeUrl(ShortenUrl shortenUrl) throws IOException;
}
