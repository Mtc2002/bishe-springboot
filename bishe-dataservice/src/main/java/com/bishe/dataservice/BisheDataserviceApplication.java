package com.bishe.dataservice;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动dubbo服务
@EnableDubbo
//Mapper扫描包
@MapperScan(basePackages = "com.bishe.dataservice.mapper")
@SpringBootApplication
public class BisheDataserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BisheDataserviceApplication.class, args);
    }

}
