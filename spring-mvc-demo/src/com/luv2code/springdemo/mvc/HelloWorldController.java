package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

//	need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
//	need a controller method to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
//	new controller method to read form data
//	add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
//		read the request parameter from the html form
		String name = request.getParameter("studentName");
		
//		convert data to all caps
		name = name.toUpperCase();
		
//		create the message
		String result = "Yo! " + name;
		
//		add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
		
//		convert data to all caps
		name = name.toUpperCase();
		
//		create the message
		String result = "Hey my friend from v3! " + name;
		
//		add message to model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
