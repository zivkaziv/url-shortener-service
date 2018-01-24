package com.shortenercommon.models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortenUrlTest {
    @Test
    public void getId() throws Exception {
        //Arrange
        ShortenUrl shortenUrlMock = new ShortenUrl();
        String mockId = "123";
        shortenUrlMock.fillId("123");

        //Act
        String id = shortenUrlMock.getId();

        //Assert
        Assert.assertNotNull(id);
        Assert.assertEquals(mockId,id);
    }

    @Test
    public void fillId() throws Exception {
        //Arrange
        ShortenUrl shortenUrlMock = new ShortenUrl();
        String mockId = "123";

        //Act
        shortenUrlMock.fillId(mockId);

        //Assert
        Assert.assertNotNull(shortenUrlMock.getId());
        Assert.assertEquals(mockId,shortenUrlMock.getId());
    }

    @Test
    public void getUrl() throws Exception {
        //Arrange
        ShortenUrl shortenUrlMock = new ShortenUrl();
        String mockUrl = "http://www.123.com";
        shortenUrlMock.setUrl(mockUrl);

        //Act
        String url = shortenUrlMock.getUrl();

        //Assert
        Assert.assertNotNull(url);
        Assert.assertEquals(mockUrl,url);
    }

    @Test
    public void setUrl() throws Exception {
        //Arrange
        ShortenUrl shortenUrlMock = new ShortenUrl();
        String mockUrl = "http://www.123.com";

        //Act
        shortenUrlMock.setUrl(mockUrl);

        //Assert
        Assert.assertNotNull(shortenUrlMock.getUrl());
        Assert.assertEquals(shortenUrlMock.getUrl(),mockUrl);
    }

    @Test
    public void setReturnedUrl() throws Exception {
        //Arrange
        ShortenUrl shortenUrlMock = new ShortenUrl();
        String mockId = "123";
        String mockUrl = "http://www.cnn.com/";
        shortenUrlMock.fillId(mockId);

        //Act
        shortenUrlMock.setReturnedUrl(mockUrl,"/");
        String returnedUrl = shortenUrlMock.getReturnedUrl();

        //Assert
        Assert.assertNotNull(returnedUrl);
        Assert.assertEquals(mockUrl + mockId,returnedUrl);
    }


}