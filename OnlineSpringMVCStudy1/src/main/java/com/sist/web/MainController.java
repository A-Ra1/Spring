package com.sist.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// MVC 중 모델클래스는 항상 @Controller 필수
// 모델클래스 : 요청처리 , 결과값 전송

// 1. 값 받는 방법
@Controller
public class MainController {

	// ID, Password
	// 1. 입력하는 JSP
	@RequestMapping("main/output.do")
	// 매개변수는 DispatcherServlet이 설정해준다
	public String main_output(HttpServletRequest request) {
		
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		request.setAttribute("id", id);
		request.setAttribute("pwd", pwd);
		return "main/output";
		/*
		 *  return "폴더명/JSP명" => .jsp생략
		 *  
		 */
	}
	
	@RequestMapping("main/input.do")
	public String main_input() {
		
		return "main/input";
	}
	
	@RequestMapping("main/output2.do")
	public String main_output2(String id, String pwd, Model model) {
		
		// Model => 인터페이스 (해당 JSP로 데이터 전송(만)하는 역할)
		model.addAttribute("id", id);
		model.addAttribute("pwd", pwd);
		// Spring : 요청값을 받는 경우 매개변수로 받고, 전송시엔 Model을 사용
		/*
		 *  public class Model {
		 *  
		 *   public void addAttribute(String ke, Object obj) {
		 *      
		 *      	request.setAttribute(key, obj) => DispatcherServlet
		 *      }
		 *   }
		 */
		return "main/output2";
	}
}
