package com.bishe.front;

import com.bishe.common.util.JwtUtil;
import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//启动swgger和ui
@EnableSwaggerBootstrapUI
@EnableSwagger2
//启动Dubbo服务
@EnableDubbo
@SpringBootApplication
public class BisheWebApplication {

    //创建JwtUtil
    @Value("${jwt.secret}")
    private String secretKey;
    @Bean
    public JwtUtil jwtUtil(){
        JwtUtil jwtUtil = new JwtUtil(secretKey);
        return jwtUtil;
    }

    public static void main(String[] args) {
        SpringApplication.run(BisheWebApplication.class, args);
    }

}
