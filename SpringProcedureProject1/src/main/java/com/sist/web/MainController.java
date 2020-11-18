package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.dao.*;

@Controller
public class MainController {

	@Autowired
	private StudentDAO dao;
	
	@RequestMapping("main/list.do")
	public String main_list(Model model) {
		
		List<StudentVO> list=dao.studentListData();
		model.addAttribute("list", list);
		return "list";
		
	}
	
	@RequestMapping("main/insert.do")
	public String main_insert() {
		
		return "insert";
	}
	
	@RequestMapping("main/insert_ok.do")
	public String main_insert_ok(StudentVO vo) {
		
		dao.studentInsert(vo);
		return "redirect:list.do";
		
	}
	
	@RequestMapping("main/delete.do")
	public String main_delete(int hakbun) {
		
		dao.studentDelete(hakbun);
		return "redirect:list.do";
	}
	
	@RequestMapping("main/update.do")
	public String main_update(int hakbun, Model model) {
		
		StudentVO vo=dao.studentDetailData(hakbun);
		model.addAttribute("vo", vo);
		return "update";
		
	}
	
	@RequestMapping("main/update_ok.do")
	public String main_update_ok(StudentVO vo) {
		
		dao.studentUpdate(vo);
		return "redirect:list.do";
	}
}
