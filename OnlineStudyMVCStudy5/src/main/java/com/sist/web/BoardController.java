package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import com.sist.dao.*;

// 여기서는 반드시 return값으로 파일명이 들어가야한다. (script는 넘어갈 수 없다) => 오류

@Controller
public class BoardController {
	
	// 1. 스프링으로부터 필요한 클래스 객체를 받아둔다
	// 스프링에서 생성된 객체 주소를 받을 경우에 지역변수는 사용할 수 없다

	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("board/list.do")
	public String board_list(String page, Model model) {
		
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		// 현재 페이지 데이터값을 읽어온다
		Map map=new HashMap();
		int rowSize=10;
		int start=(curpage*rowSize)-(rowSize-1);
		int end=curpage*rowSize;
		map.put("start", start);
		map.put("end", end);
		List<BoardVO> list=dao.boardListData(map);
		
		// 총페이지
		int totalpage=dao.boardTotalPage();
		
		// jsp로 데이터 전송 => 전송만 담당 (Model)
		
		/*
		 *  스프링에서는 request를 사용하지 않는다
		 *  => 스프링에서 메소드의 매개변수를 이용하여 데이터값을 받는다 (getParameter())
		 *  결과값을 모아서 전송해주는 기능 (Model 인터페이스를 이용하여 데이터 전송)
		 *  
		 */
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		
		return "board/list"; //forward (파일명이 넘어오면 forward(request를 전송하며 넘어간다), 경로명까지 넘어오면 redirect (request를 버리면서 넘어간다))
	}
	
	@RequestMapping("board/insert.do")
	public String board_insert() {
		
		return "board/insert"; 
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) throws Exception {
		
		List<MultipartFile> list=vo.getFiles();
		
		if(list==null || list.size()<1) {
			
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
			
		} else {
			
			String fn="";
			String fs="";
			for(MultipartFile mf:list) {
				
//				System.out.println(mf.getOriginalFilename());
				String filename=mf.getOriginalFilename();
				File file=new File("c:\\upload\\"+filename);
				mf.transferTo(file); // 업로드하는 소스
				fn+=filename+",";
				fs+=file.length()+",";
			}
			
			fn=fn.substring(0, fn.lastIndexOf(","));
			fs=fs.substring(0, fs.lastIndexOf(","));
			vo.setFilename(fn);
			vo.setFilesize(fs);
			vo.setFilecount(list.size());
		}
		
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(int no, Model model) {
		
		
//		db연동
		BoardVO vo=dao.boardDetailData(no);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	@RequestMapping("board/update.do")
	public String board_update(int no, Model model) {
		
		BoardVO vo=dao.boardUpdateData(no);
		model.addAttribute("vo", vo);
		return "board/update";
		
	}
	
	@RequestMapping("board/delete.do")
	public String board_delete(int no, Model model) {
		
		model.addAttribute("no", no);
		return "board/delete";
	}
	
	
}
