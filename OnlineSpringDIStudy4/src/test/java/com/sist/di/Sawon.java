package com.sist.di;
/*
 *  Container : 여러개의 클래스를 모아서 관리하는 영역
 *  =========
 *  기본적으로 많이 사용하는 클래스
 *   ApplicationContext (Spring 4) 
 *    : XML 을 파싱하는 기능
 *   AnnotationConfigApplicationContext (Spring 5)
	  : Annotation
 */
public class Sawon {

	private String name;
	private String dept;
	private String job;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
