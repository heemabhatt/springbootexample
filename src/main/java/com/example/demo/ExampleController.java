package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
 
	@Autowired
	private MetricService metricService;
	
	 @RequestMapping("/api")
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
	 
	 @RequestMapping(value = "/metric", method = RequestMethod.GET)
	 @ResponseBody
	 public Map getMetric() {
	     return metricService.getFullMetric();
	 }
}
