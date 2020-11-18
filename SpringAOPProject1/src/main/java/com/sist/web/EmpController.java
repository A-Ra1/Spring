package com.sist.web;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.sist.dao.*;

@Controller
public class EmpController {

	@Autowired
	private EmpDAO dao;
	
	@GetMapping("emp/list.do")
	public String emp_list(Model model) {
		
		List<EmpVO> list=dao.empListData();
		model.addAttribute("list", list);
		return "emp/list";
	}
	
	@GetMapping("emp/detail.do")
	public String emp_detail(int empno, Model model) {
		
		EmpVO vo=dao.empDetailData(empno);
		model.addAttribute("vo", vo);
		return "emp/detail";
	}

}
