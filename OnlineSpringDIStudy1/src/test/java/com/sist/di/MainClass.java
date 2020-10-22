package com.sist.di;

public class MainClass {

	public static void main(String[] args) {

		Sawon s=new Sawon();
		s.setName("홍길동");
		s.setSex("남자");
		s.setAge(30);
		
		s.init();
		// 메모리를 할당하고 값을 채우는 과정 => DI (의존성 주입) 
		s.print();
	}

}
