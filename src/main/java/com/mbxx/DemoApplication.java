package com.mbxx;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mbxx.dao")
public class DemoApplication {
    protected static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        logger.info("springboot开始");
        SpringApplication.run(DemoApplication.class, args);
        logger.info("springboot结束");
    }
}
