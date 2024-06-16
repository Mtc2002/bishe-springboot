package com.bishe.front.settings;


import com.bishe.front.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMveConfiguration implements WebMvcConfigurer {


   /* @Value("${jwt.secret}")*/
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TokenInterceptor tokenInterceptor = new TokenInterceptor(jwtSecret);
        String [] addPath = {"/v1/patient/upData","/v1/patient/insert","/v1/patient/delete"};
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns(addPath);
    }

    /*统一跨域处理*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("===========addCorsMappings===========");
        //addMapping处理请求地址，拦截这些地址，使用跨域处理逻辑
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                //支持跨域的请求头，在请求头包含哪些数据时，支持跨域
                .allowedHeaders("*");
    }
}
