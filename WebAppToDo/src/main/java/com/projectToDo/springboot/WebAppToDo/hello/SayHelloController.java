package com.projectToDo.springboot.WebAppToDo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello()
	{
		
		return "Hello! What are you learning today?";
	}
	//\src\main\resources\META-INF\resources\WEB-INF\jsp\
	@RequestMapping("say-hello-jsp")
	public String sayHelloJSP()
	{
		return "Hello";
	}


}
