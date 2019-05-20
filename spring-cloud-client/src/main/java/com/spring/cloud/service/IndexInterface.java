package com.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.cloud.feign.FeignConfig;

import feign.RequestLine;

@Component
@FeignClient(value = "cloud-server",configuration=FeignConfig.class)
public interface IndexInterface {
	@RequestLine(value = "GET /index")
    String hi();
}
