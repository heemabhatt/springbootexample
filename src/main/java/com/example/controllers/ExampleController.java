package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
	 @RequestMapping("/")
	   @ResponseBody
	   public String hello() {
	      return "Hello Spring Boot";
	   }

	 
	 @RequestMapping(method = RequestMethod.POST, value="/api/name")
	  @ResponseBody
	 public String postMessage(@RequestBody String name)
	 {
		 return "Post successful with name: "+name ;
	 }
}
