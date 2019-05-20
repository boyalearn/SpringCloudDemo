package com.spring.cloud.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class IndexInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		// TODO Auto-generated method stub
		template.header("token", "myToken");
		System.out.println("token: myToken");
	}

}
