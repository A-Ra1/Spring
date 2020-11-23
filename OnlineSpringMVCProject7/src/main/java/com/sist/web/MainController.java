package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("main/main.do")
	public String main_main() {
		
		return "main";
	}
	
	@RequestMapping("recipe/list.do")
	public String recipe_list() {
		
		return "recipe/list";
	}
}
