package com.shortenercommon.repositories;

import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface UrlStoreRepository {
    String findById(String id);
    String findByIdAndStoreEmptyValueWithTransaction(String id) throws IOException;
    void set(String key, String value) throws IOException;
}
