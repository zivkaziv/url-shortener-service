package com.shortenerservice.services;

import org.springframework.stereotype.Service;

@Service
public interface UrlHashService {
    String hash(String url);
    String hashOnUrlWithFirstChar(String url, int tryNumber);
}
