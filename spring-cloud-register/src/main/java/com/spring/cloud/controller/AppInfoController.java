package com.spring.cloud.controller;

import org.springframework.beans.BeansException;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AppInfoController implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	@ResponseBody
	@RequestMapping("/index")
	public String index(){
		EurekaDiscoveryClient  application=applicationContext.getBean(EurekaDiscoveryClient.class);
		System.out.println(application.getLocalServiceInstance().getServiceId());
		System.out.println(application.getServices());
		return "success";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
}
