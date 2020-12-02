package com.sist.web;

import java.util.*;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

	@Autowired
	private RecipeDAO dao;
	
	@RequestMapping("recipe/list.do")
	public String recipe_list(String page, Model model) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<RecipeVO> list=dao.recipeListData(curpage);
		int count=dao.recipeCount();
		int totalpage=(int)(Math.ceil(count/12.0));
		model.addAttribute("curpage", curpage);
		model.addAttribute("count", count);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "recipe/list";
	}
	
	@RequestMapping("recipe/recipe_detail.do")
	public String recipe_detail(int no, Model model) {
		
		RecipeDetailVO vo=dao.recipeDetailData(no);
		StringTokenizer st=new StringTokenizer(vo.getFoodmake(),"\n");
		while(st.hasMoreTokens()) {
			
			vo.getmList().add(st.nextToken());
		}
		model.addAttribute("vo", vo);
		return "recipe/detail";
	}
	
	@RequestMapping("recipe/chef_list.do")
	public String recipe_chief_list(String page, Model model) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<ChefVO> list=dao.chefListData(curpage);
		model.addAttribute("list", list);
		return "recipe/chef_list";
	}
	
	@RequestMapping("recipe/chef_product.do")
	public String recipe_chef_product(String chef, Model model, String page, String fd) {
		
		/*
		 * 화면 변경 : forward (jsp파일명) 
		 * 내용 변경 : redirect (.do)
		 */
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		if(fd==null) {
		    list=dao.chefProductData(chef, curpage); 
		} else {
			
			list= dao.chefProductFindData(chef, fd);
		}
		
		// jsp로 전송
		model.addAttribute("list", list);
		model.addAttribute("chef", chef);
		return "recipe/chef_product";
	}
	
}
