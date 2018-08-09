package com.mbxx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@PropertySource(value = "classpath:application.yml")
public class MbxxConfig {
}
