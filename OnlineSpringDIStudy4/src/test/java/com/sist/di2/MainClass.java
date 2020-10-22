package com.sist.di2;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext app=new ClassPathXmlApplicationContext("app3.xml");
	
//		EmpDAO dao=new EmpDAO(); => 스프링 내 생성된 객체가 아니기 때문에 데이터 리딩 X , new로 생성해도 X
		EmpDAO dao=(EmpDAO)app.getBean("dao"); // app3에서 세팅된 객체
		
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getSal()+" "
					+vo.getRegdate().toString());
			
		}
		
	}

}
