package com.shortenerservice.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlValidatorImplTest {
    UrlValidatorImpl urlValidator;

    @Before
    public void setUp() throws Exception {
        urlValidator = new UrlValidatorImpl();
    }

    @Test
    public void validUrlHttp() throws Exception {
        //Arrange
        String validUrl = "http://www.cnn.com";

        //Act
        Boolean isValid =  urlValidator.isUrlValid(validUrl);

        //Assert
        Assert.assertTrue(isValid);
    }

    @Test
    public void validUrlHttps() throws Exception {
        //Arrange
        String validUrl = "https://www.cnn.com";

        //Act
        Boolean isValid =  urlValidator.isUrlValid(validUrl);

        //Assert
        Assert.assertTrue(isValid);
    }

    @Test
    public void notValidUrlNoProtocol() throws Exception {

        //Arrange
        String validUrl = "www.cnn.com";

        //Act
        Boolean isValid =  urlValidator.isUrlValid(validUrl);

        //Assert
        Assert.assertFalse(isValid);
    }

    @Test
    public void validUrlNoWWW() throws Exception {

        //Arrange
        String validUrl = "https://cnn.com";

        //Act
        Boolean isValid =  urlValidator.isUrlValid(validUrl);

        //Assert
        Assert.assertTrue(isValid);
    }

    @Test
    public void validUrlQueryParams() throws Exception {

        //Arrange
        String validUrl = "https://cnn.com?utm_source=231&utm_medium=3123";

        //Act
        Boolean isValid =  urlValidator.isUrlValid(validUrl);

        //Assert
        Assert.assertTrue(isValid);
    }
    @Test
    public void validUrlNull() throws Exception {

        //Arrange

        //Act
        Boolean isValid = urlValidator.isUrlValid(null);
        //Assert
        Assert.assertFalse(isValid);
    }
}