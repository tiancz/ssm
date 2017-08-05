package com.tian.cola.controller.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:07:48
 *@功能:
 */
@Controller
@RequestMapping("/home")
public class Home {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Home.class);

	@RequestMapping("/home")
	public String toHome(){
		LOGGER.info("to home");
		String url = "";
		url = "home";
		return url;
	}
	
}
