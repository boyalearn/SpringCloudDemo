package com.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import com.spring.cloud.feign.FeignConfig;
import feign.RequestLine;


@Component
@FeignClient(value = "GETWAY-API",configuration=FeignConfig.class)
public interface IndexInterface {
	/*@RequestMapping(method=RequestMethod.GET ,value = "/index")*/
	@RequestLine("GET /server/index")
    String hi();
	
	/*@RequestMapping(method=RequestMethod.GET ,value = "/index")*/
	@RequestLine("GET /server/index")
    String say();
}
