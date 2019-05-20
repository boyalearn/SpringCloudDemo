package com.spring.cloud.feign;

import org.springframework.context.annotation.Bean;

import com.spring.cloud.feign.interceptor.IndexInterceptor;

import feign.Contract;
import feign.Logger;
import feign.RequestInterceptor;

public class FeignConfig {
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.BASIC;
	}

	@Bean
	public Contract feignContract() {
		return new Contract.Default();
	}

	@Bean
	public RequestInterceptor tulingInterceptor() {
		return new IndexInterceptor();
	}
}
