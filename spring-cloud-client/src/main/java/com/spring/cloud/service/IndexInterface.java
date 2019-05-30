package com.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.feign.FeignConfig;

import feign.RequestLine;

@Component
@FeignClient(value = "cloud-server",configuration=FeignConfig.class)
public interface IndexInterface {
	@HystrixCommand()
	@RequestLine(value = "GET /index")
    String hi();
}
