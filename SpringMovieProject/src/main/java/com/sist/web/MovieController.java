package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.manager.*;

// Model

@Controller
public class MovieController {

	@Autowired
	private MovieManager mgr;
	
	@RequestMapping("movie/main.do")
	public String movie_main(int no, Model model) {
		
	
		List<MovieVO> list=mgr.jsonAllData(no);
		model.addAttribute("list", list);
		return "movie/main";
	}
}
