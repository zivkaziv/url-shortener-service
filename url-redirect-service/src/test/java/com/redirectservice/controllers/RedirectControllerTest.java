//package com.redirectservice.controllers;
//
//import com.shortenercommon.models.ShortenUrl;
//import com.shortenercommon.services.ShortenUrlService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
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
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@WebMvcTest(value = RedirectController.class, secure = false)
//public class RedirectControllerTest {
//    @InjectMocks
//    private RedirectController redirectController;
//
//    @MockBean
//    private ShortenUrlService shortenUrlService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    ShortenUrl shortenUrlMock;
//
//    @Before
//    public void setUp() throws Exception {
//        shortenUrlMock = new ShortenUrl();
//        shortenUrlMock.setUrl("http://www.cnn.com");
//    }
//
//    @Test
//    public void redirectToUrlExistId() throws Exception {
//        //Arrange
//        String shortUrlId = "123";
//        String fullUrl = "http://www.cnn.com";
//        shortenUrlMock.fillId(shortUrlId);
//        shortenUrlMock.setUrl(fullUrl);
//        Mockito.when(shortenUrlService.findUrl(shortenUrlMock.getId())).thenReturn(shortenUrlMock.getUrl());
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/"+shortUrlId);
//
//        //Act
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        //Assert
//        Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_MOVED_PERMANENTLY);
//        Assert.assertNotEquals(result.getResponse().getHeaderNames().size(),0);
//        Assert.assertEquals(result.getResponse().getHeader("location"),fullUrl);
//    }
//
//    @Test
//    public void redirectToUrlNotExistId() throws Exception {
//        //Arrange
//        String shortUrlId = "123";
//        String fullUrl = "http://www.cnn.com";
//        shortenUrlMock.fillId(shortUrlId);
//        shortenUrlMock.setUrl(fullUrl);
//        Mockito.when(shortenUrlService.findUrl(shortenUrlMock.getId())).thenReturn(shortenUrlMock.getUrl());
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/456");
//
//        //Act
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        //Assert
//        Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_NOT_FOUND);
//        Assert.assertEquals(result.getResponse().getHeaderNames().size(),0);
//    }
//
//    @Test
//    public void redirectToUrlEmptyString() throws Exception {
//        //Arrange
//        String shortUrlId = "123";
//        String fullUrl = "http://www.cnn.com";
//        shortenUrlMock.fillId(shortUrlId);
//        shortenUrlMock.setUrl(fullUrl);
//        Mockito.when(shortenUrlService.findUrl(shortenUrlMock.getId())).thenReturn(shortenUrlMock.getUrl());
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
//        MvcResult result = null;
//        //Act
//        try {
//            result = mockMvc.perform(requestBuilder).andReturn();
//        }catch (Exception e){
//            Assert.assertTrue(false);
//        }
//        //Assert
//        if(result != null) {
//            Assert.assertNotNull(result);
//            Assert.assertEquals(result.getResponse().getStatus(), HttpServletResponse.SC_NOT_FOUND);
//            Assert.assertEquals(result.getResponse().getHeaderNames().size(), 0);
//        }else {
//            Assert.assertTrue(false);
//        }
//    }
//
//}