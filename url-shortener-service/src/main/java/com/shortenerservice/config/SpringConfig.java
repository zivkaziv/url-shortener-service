package com.shortenerservice.config;

import com.shortenercommon.interceptors.TimerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//Configuration file from the spring controllers
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter{

    @Autowired
    TimerInterceptor timerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timerInterceptor);
    }
}
