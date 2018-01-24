package com.shortenercommon.repositories;

import com.google.gson.Gson;
import com.shortenercommon.models.ShortenUrl;
import com.shortenercommon.services.ShortenUrlServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UrlStoreRepositoryImplTest {
    @InjectMocks
    private UrlStoreRepositoryImpl urlStoreRepository;

    @Mock
    private StringRedisTemplate stringRedisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperationsMock;

    private ShortenUrl shortenUrlMock;
    private String shortenUrlJson;

    @Before
    public void setUp() throws Exception {
        when(stringRedisTemplate.opsForValue()).thenReturn(valueOperationsMock);

        shortenUrlMock = new ShortenUrl();
        shortenUrlMock.fillId("123");
        shortenUrlMock.setUrl("http://www.cnn.com");

        shortenUrlJson = new Gson().toJson(shortenUrlMock);
    }

    @Test
    public void findByIdSuccess() throws Exception {
        //Arrange
        when(valueOperationsMock.get(shortenUrlMock.getId())).thenReturn(shortenUrlJson);
        //Act
        String json = urlStoreRepository.findById(shortenUrlMock.getId());

        //Assert
        Assert.assertNotNull(json);
        Assert.assertNotEquals(json,"");
    }

    @Test
    public void findByIdFailure() throws Exception {
        //Arrange

        //Act
        String json = urlStoreRepository.findById(shortenUrlMock.getId());

        //Assert
        Assert.assertNull(json);
    }

    @Test
    public void findByIdAndStoreEmptyValueInCaseValueAlreadyExist() throws Exception {
        //Arrange
        when(valueOperationsMock.get(shortenUrlMock.getId())).thenReturn(shortenUrlJson);
        //Act
        String json = urlStoreRepository.findByIdAndStoreEmptyValueWithTransaction(shortenUrlMock.getId());

        //Assert
        Assert.assertNotNull(json);
        Assert.assertNotEquals(json,"");
    }

    @Test
    public void findByIdAndStoreEmptyValueInCaseValueNotExist() throws Exception {
        //Arrange

        //Act
        String json = urlStoreRepository.findByIdAndStoreEmptyValueWithTransaction(shortenUrlMock.getId());

        //Assert
        Assert.assertNull(json);
    }


    @Test
    public void set() throws Exception {
        //Arrange

        //Act
        try {
            urlStoreRepository.set(shortenUrlMock.getId(), shortenUrlJson);
            Assert.assertTrue(true);
        }catch (Exception e){
            Assert.assertTrue(false);
        }
    }

}