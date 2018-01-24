//package com.shortenerservice.controllers;
//
//import com.google.gson.Gson;
//import com.shortenercommon.models.ShortenUrl;
//import com.shortenercommon.services.ShortenUrlService;
//import com.shortenerservice.services.UrlHashService;
//import com.shortenerservice.services.UrlValidator;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import javax.servlet.http.HttpServletResponse;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@WebMvcTest(value = ShortenerController.class, secure = false)
//public class ShortenerControllerTest {
//    @InjectMocks
//    private ShortenerController shortenerController;
//
//    @MockBean
//    private ShortenUrlService shortenUrlService;
//
//    @MockBean
//    private UrlValidator urlValidator;
//
//    @MockBean
//    private UrlHashService urlHashService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    ShortenUrl shortenUrlMock;
//
//    @Before
//    public void setUp() throws Exception {
//        shortenUrlMock = new ShortenUrl();
//    }
//
//    @Test
//    public void shortenUrlNotValidUrl() throws Exception {
//        //Arrange
//        String fullUrl = "http://www.cnn.com";
//        shortenUrlMock.setUrl(fullUrl);
//        Mockito.when(urlValidator.isUrlValid(Mockito.anyString())).thenReturn(false);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/url")
//                .accept(MediaType.APPLICATION_JSON).content(new Gson().toJson(shortenUrlMock))
//                .contentType(MediaType.APPLICATION_JSON);
//
//        //Act
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        //Assert
//        Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_BAD_REQUEST);
//        Assert.assertNotEquals(result.getResponse().getErrorMessage(),"");
//    }
//
//    @Test
//    public void shortenUrlValidUrl() throws Exception {
//        //Arrange
//        String fullUrl = "http://www.cnn.com";
//        String dummyId = "1a2s3d";
//        shortenUrlMock.setUrl(fullUrl);
//        Mockito.when(urlValidator.isUrlValid(shortenUrlMock.getUrl())).thenReturn(true);
//        Mockito.when(urlHashService.hash(Mockito.anyString())).thenReturn(dummyId);
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/url")
//                .accept(MediaType.APPLICATION_JSON).content(new Gson().toJson(shortenUrlMock))
//                .contentType(MediaType.APPLICATION_JSON);
//
//        //Act
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        //Assert
//        Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_OK);
//        Assert.assertNotEquals(result.getResponse().getContentAsString(),"");
//        ShortenUrl shortenUrlResponse = new Gson().fromJson(result.getResponse().getContentAsString(),ShortenUrl.class);
//        Assert.assertEquals(shortenUrlResponse.getId(),dummyId);
//        Assert.assertEquals(shortenUrlResponse.getUrl(),fullUrl);
//    }
//
//}