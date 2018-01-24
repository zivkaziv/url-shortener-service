package com.shortenerservice.services;

import org.springframework.stereotype.Service;

@Service
public interface UrlValidator {
    boolean isUrlValid(String url);
}
