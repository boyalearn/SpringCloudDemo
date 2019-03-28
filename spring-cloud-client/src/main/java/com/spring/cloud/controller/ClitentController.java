package com.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.service.IndexInterface;

@Controller
public class ClitentController {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private RestTemplate restTemplate;
	
	@ResponseBody
    //@HystrixCommand(fallbackMethod = "defaultRest")
	@Retryable
    @RequestMapping("index1")
	public String getIndex1() {
    	log.info("index1.hhhhhh");
		String msg=restTemplate.getForObject("http://cloud-server/index", String.class);
		System.out.println("msg:"+msg);
		return msg;
	}
    
    @Autowired
    IndexInterface indexInterface;
    @Retryable(maxAttempts=5)
    @ResponseBody
    @HystrixCommand(fallbackMethod = "defaultRest")
    @RequestMapping("index2")
	public String getIndex2() {
		String msg=indexInterface.hi();
		System.out.println("msg:"+msg);
		return msg;
	}
    
    public String defaultRest(){
    	System.err.println("have a error");
    	return "have a error";
    }

	@Recover
	public String recover(RemoteAccessException e) {
	    System.err.println(e.getMessage());
	    return "call Error";
	}

}
