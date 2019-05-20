package com.spring.cloud.hystrix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import feign.Feign;

public class FeignApiWithoutHystrixConfg {
	@Scope("prototype")
    @Bean
    public Feign.Builder feignBuilder() {
        return Feign.builder();
    }

}
