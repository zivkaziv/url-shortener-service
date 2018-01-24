package com.shortenerservice.services;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
public class UrlHashServiceImpl implements UrlHashService {
    @Override
    public String hash(String url) {
        return Hashing.murmur3_32()
                .hashString(url, StandardCharsets.UTF_8).toString();
    }

    //This function takes the first char and adding it to the end of the url. In this way we
    //can save the persistence of problematic urls
    @Override
    public String hashOnUrlWithFirstChar(String url, int tryNumber) {
        StringBuilder newUrlForHash = new StringBuilder(url);
        for(int tries = 0; tries < tryNumber ;tries++ ){
            newUrlForHash.append(url.substring(0, 1));
        }
        return hash(newUrlForHash.toString());
    }
}
