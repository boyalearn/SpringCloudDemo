package com.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.service.IndexInterface;

@Controller
public class ClitentController {
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	
	@Value("${client.password}")
	private String password;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@ResponseBody
    @HystrixCommand(fallbackMethod = "defaultRest",commandProperties= {
    		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000"),
    		@HystrixProperty(name="execution.timeout.enabled",value="true"),
    		@HystrixProperty(name="execution.isolation.thread.interruptOnTimeout",value="5000")},
    		threadPoolProperties = {
    	            @HystrixProperty(name = "coreSize", value = "1"),
    	            @HystrixProperty(name = "maxQueueSize", value = "10"),
    	            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
    	            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
    	            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
    	            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    	    })
    @RequestMapping(value="index1",method=RequestMethod.GET)
	public String getIndex1() {
    	log.info("index1.hhhhhh");
		String msg=restTemplate.getForObject("http://localhost:5555/server/index", String.class);
		System.out.println("msg:"+msg);
		return msg;
	}
    
	@ResponseBody
	@RequestMapping(value="index4",method=RequestMethod.GET)
	public String getIndex4() {
		System.out.println("password:"+password);
		return password;
	}
	
    @Autowired
    IndexInterface indexInterface;
    
    
    @ResponseBody
    @HystrixCommand(fallbackMethod = "defaultRest")
    @RequestMapping(value="index2",method=RequestMethod.GET)
	public String getIndex2() {
		String msg=indexInterface.hi();
		System.out.println("msg:"+msg);
		return msg;
	}
    
    
    @ResponseBody
    @HystrixCommand(fallbackMethod = "defaultRest",commandProperties= {
    		@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000"),
    		@HystrixProperty(name="execution.timeout.enabled",value="true"),
    		@HystrixProperty(name="execution.isolation.thread.interruptOnTimeout",value="1000")},
    		threadPoolProperties = {
    	            @HystrixProperty(name = "coreSize", value = "1"),
    	            @HystrixProperty(name = "maxQueueSize", value = "10"),
    	            @HystrixProperty(name = "keepAliveTimeMinutes", value = "1000"),
    	            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "8"),
    	            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
    	            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    	    })
    @RequestMapping(value="index5",method=RequestMethod.GET)
	public String getIndex5() {
		String msg=indexInterface.say();
		System.out.println("msg:"+msg);
		return msg;
	}
    
    
    public String defaultRest(){
    	System.err.println("have a error");
    	return "have a error";
    }


}
