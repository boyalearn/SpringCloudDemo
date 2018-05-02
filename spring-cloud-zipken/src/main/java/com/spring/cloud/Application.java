package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin.server.EnableZipkinServer;

@EnableEurekaClient // 配置本应用将使用服务注册和服务发现
@SpringBootApplication
@EnableZipkinServer // 启动Zipkin服务
public class Application {
	public static void main(String[] args) {
		args = new String[1];
        args[0] = "--spring.profiles.active=zipkin-http";
        SpringApplication.run(Application.class, args);
    }

}
