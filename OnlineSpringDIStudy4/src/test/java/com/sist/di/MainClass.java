package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		String[] xml={"app1.xml","app2.xml"};
		ApplicationContext app=new ClassPathXmlApplicationContext(xml);
		// = ApplicationContext app=new ClassPathXmlApplicationContext("app1.xml","app2.xml");
		Sawon sa=(Sawon)app.getBean("sa"); // 형변환1
		System.out.println("이름:"+sa.getName());
		System.out.println("부서:"+sa.getDept());
		System.out.println("직위:"+sa.getJob());
		
		Member mem=app.getBean("mem", Member.class); // 형변환2 (제네릭스) = List<String>
		System.out.println("이름:"+mem.getName());
		System.out.println("주소:"+mem.getAddr());
		System.out.println("전화:"+mem.getTel()
		);
		
	}

}
