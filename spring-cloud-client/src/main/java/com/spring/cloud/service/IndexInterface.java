package com.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-server")
public interface IndexInterface {
	@RequestMapping(value = "/index")
    String hi();
}
