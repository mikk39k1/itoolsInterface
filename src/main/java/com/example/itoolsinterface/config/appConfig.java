package com.example.itoolsinterface.config;

import com.example.itoolsinterface.interceptors.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class appConfig implements WebMvcConfigurer {

    private static final List<String> CHECK_INTEGRITY_FOR_GET_PATH_PATTERNS = List.of("home/index");

    @Autowired
    SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns(CHECK_INTEGRITY_FOR_GET_PATH_PATTERNS);
    }

}
