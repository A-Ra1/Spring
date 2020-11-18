package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FoodController {

	@RequestMapping("food/list.do")
	public String food_list() {
		
		return "food/list";
	}
	
}
