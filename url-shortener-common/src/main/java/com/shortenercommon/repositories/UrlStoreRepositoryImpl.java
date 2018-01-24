package com.shortenercommon.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class UrlStoreRepositoryImpl implements UrlStoreRepository {
    //This class is the one that holds the url repository in Redis DB

    @Autowired
    private StringRedisTemplate redisTemplate;

    public String findById(String id) {
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        return valueOps.get(id);
    }

    public String findByIdAndStoreEmptyValueWithTransaction(String id) throws IOException {
        redisTemplate.setEnableTransactionSupport(true);
        ValueOperations<String, String> valueOps = redisTemplate.opsForValue();
        String returnedValue = valueOps.get(id);
        if(returnedValue == null || returnedValue.isEmpty()){
            this.set(id,"");
        }
        redisTemplate.setEnableTransactionSupport(false);
        return valueOps.get(id);
    }
    public void set(String key, String value) throws IOException {
        ValueOperations<String, String> setOps = redisTemplate.opsForValue();
        setOps.set(key, value);
    }
}
