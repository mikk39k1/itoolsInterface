package com.example.itoolsinterface.configuration;

import com.example.itoolsinterface.interceptors.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    private static final List<String> CHECK_INTEGRITY_FOR_GET_PATH_PATTERNS = Arrays.asList(
            "/cardCreation",""
    );

    private static final List<String> CHECK_INTEGRITY_FOR_POST_PATH_PATTERNS = Arrays.asList(
            "/createNewCard","/getTemporaryAccess"
    );



    @Autowired
    SessionInterceptor sessionInterceptor;          //To control that users are logged in and thereby have access to continue on the webapplication


    /**
     * This is a method which is implemented from WebMvcConfigure, which allows
     * us to directly indicate which lists / pathPatterns should be handled with an interceptor
     * @param registry registeres with in-build method adding specific interceptors and their pathPatterns to verify
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns(CHECK_INTEGRITY_FOR_GET_PATH_PATTERNS)
                .addPathPatterns(CHECK_INTEGRITY_FOR_POST_PATH_PATTERNS)
                .excludePathPatterns("/authorization/login", "/authorization/accessDenied");

    }
}
