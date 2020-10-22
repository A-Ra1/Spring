package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

	@Bean("mem")
	public Member memberInfo() {
		
		Member m=new Member();
		m.setName("춘향이");
		m.setAddr("서울");
		m.setTel("010-1111-1111");
		return m;
	}
}
