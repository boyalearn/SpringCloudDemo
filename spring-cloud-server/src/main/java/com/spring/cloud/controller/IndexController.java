package com.spring.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		String filename = file.getOriginalFilename();
		String path = "D://UpLoadFile";
		File filepath = new File(path, filename);
		//判断路径是否存在，如果不存在就创建一个
		if (!filepath.getParentFile().exists()) {
			filepath.getParentFile().mkdirs();
		}
		//将上传文件保存到一个目标文件当中
		file.transferTo(new File(path + File.separator + filename));
		return "OK";
	}


}
