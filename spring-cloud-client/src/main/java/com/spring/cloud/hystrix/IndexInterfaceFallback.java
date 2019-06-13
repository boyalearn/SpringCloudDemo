package com.spring.cloud.hystrix;

import org.springframework.stereotype.Component;

import com.spring.cloud.service.IndexInterface;

@Component
public class IndexInterfaceFallback implements IndexInterface{

	@Override
	public String hi() {

		return "errorr";
	}

	@Override
	public String say() {
		// TODO Auto-generated method stub
		return "say error";
	}

}
