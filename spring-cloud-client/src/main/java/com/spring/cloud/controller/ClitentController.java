package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.service.IndexInterface;

@Controller
public class ClitentController {
	
	@Autowired
    private RestTemplate restTemplate;;
    
    @Autowired
    IndexInterface indexInterface;
    @ResponseBody
    @RequestMapping("index1")
	public String getIndex1() {
		String msg=restTemplate.getForObject("http://cloud-server/index", String.class);
		System.out.println("msg:"+msg);
		return msg;
	}
    @ResponseBody
    @RequestMapping("index2")
	public String getIndex2() {
		String msg=indexInterface.hi();
		System.out.println("msg:"+msg);
		return msg;
	}

}
