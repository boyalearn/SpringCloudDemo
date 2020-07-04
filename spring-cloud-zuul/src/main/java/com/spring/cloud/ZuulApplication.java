package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringCloudApplication
public class ZuulApplication {
	public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
