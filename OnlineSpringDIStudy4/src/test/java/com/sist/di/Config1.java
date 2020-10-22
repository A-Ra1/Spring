package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 자바로 등록
public class Config1 {

	@Bean("sawon")
	public Sawon sawonInfo() {
		
		// app.xml과 같은 과정
		/*
		 *  map.put("sa", new Sawon())
		 *  public Object getBean(String id) {
		 *  
		 *  	return map.get(id);
		 *  }
		 *  Sawon sa=getBean("sa")
		 *  Sawon sa=new Sawon()
		 * 
		 */
		Sawon s=new Sawon(); // 객체 생성
		// DI
		s.setName("이순신");
		s.setDept("개발부");
		s.setJob("과장");
		return s;
	}
	
}
