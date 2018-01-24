package com.shortenercommon.services;

import com.google.gson.Gson;
import com.shortenercommon.repositories.UrlStoreRepository;
import com.shortenercommon.models.ShortenUrl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShortenUrlServiceImplTest {

    @InjectMocks
    private ShortenUrlServiceImpl shortenUrlService;

    @Mock
    private UrlStoreRepository urlStoreRepository;

    private ShortenUrl shortenUrlMock;
    private String shortenUrlJson;

    @Before
    public void setUp() throws Exception {
        shortenUrlMock = new ShortenUrl();
        shortenUrlMock.fillId("123");
        shortenUrlMock.setUrl("http://www.cnn.com");

        shortenUrlJson = new Gson().toJson(shortenUrlMock);
    }

    @Test
    public void findUrl() throws Exception {
        //Arrange
        when(urlStoreRepository.findById(shortenUrlMock.getId())).thenReturn(shortenUrlJson);

        //Act
        String url = shortenUrlService.findUrl(shortenUrlMock.getId());

        //Assert
        Assert.assertEquals(shortenUrlMock.getUrl(),url);
    }

    @Test
    public void didntFindUrl() throws Exception {
        //Arrange

        //Act
        String url = shortenUrlService.findUrl("456");

        //Assert
        Assert.assertNull(url);
    }

    @Test
    public void storeUrl() throws Exception {
        //Arrange

        //Act
        urlStoreRepository.set(shortenUrlMock.getId(),shortenUrlJson);
        //Assert
        verify(urlStoreRepository, times(1)).set(shortenUrlMock.getId(),shortenUrlJson);
    }

}