package com.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	private Logger log=LoggerFactory.getLogger(this.getClass());
	@ResponseBody
	@RequestMapping("index")
	public String index() {
        log.info("Server2.index");
		
		if(Math.random()>0.3) {
		throw new NullPointerException();
		}
		return "Hello World two";
	}

}
