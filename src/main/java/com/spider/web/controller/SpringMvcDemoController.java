package com.spider.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.spider.common.bean.UserInfo;
import com.spider.services.UserService;

@Controller
@RequestMapping("/demo")
public class SpringMvcDemoController {
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping("/test")
	public String test(){
		return "this a my test demo springmvc";
	}
	
	@ResponseBody
	@RequestMapping("/queryAll")
	public String testQueryAll(){
		return JSON.toJSON(userService.getUsers()).toString();
	}
	
	@ResponseBody
	@RequestMapping("/user/{userId}")
	public String showUserInfo(@PathVariable int userId){
		UserInfo userInfo = userService.getUserById(userId);
		return JSON.toJSON(userInfo).toString();
	}
}
