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
		System.out.println("Server1.index");
		log.info("Server1.index");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hello World one";
	}

}
