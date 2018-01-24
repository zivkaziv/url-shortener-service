package com.shortenercommon.models;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Component
public class ShortenUrl {
    //The main entity the holds the URL
    private String id;
    private String url;
    private Long createTimestamp;
    private String returnedUrl;

    public ShortenUrl(){

    }

    public String getId() {
        return id;
    }

    public void fillId(String id) {
        this.id = id;
        this.createTimestamp = new DateTime().getMillis();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setReturnedUrl(String requestUrl,String requestUri){
        String prefix = requestUrl.substring(0, requestUrl.indexOf(requestUri, "http://".length()));
        this.returnedUrl = prefix + "/" + this.getId();
    }

    public String getReturnedUrl(){ return this.returnedUrl; }
}
