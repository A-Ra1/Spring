package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {
  
	public static void main(String[] args) {
		
		// xml 파싱
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		
		Sawon sa=(Sawon)app.getBean("sa");
		System.out.println("sa="+sa);
		sa.init();
		sa.print();
		
		
		Sawon sa1=(Sawon)app.getBean("sa");
		System.out.println("sa1="+sa1);
		sa.init();
		sa.print();
	}
	
}
