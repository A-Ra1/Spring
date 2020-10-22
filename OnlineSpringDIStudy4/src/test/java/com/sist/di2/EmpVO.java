package com.sist.di2;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

// VO => 스프링에서 관리하는 클래스가 아니다
// == 데이터형, 스프링에서는 기능적인 클래스만 관리 (DAO, Manager) : 사용자 정의 데이터형
//											  ====== 웹크롤링, 트위터, openApi
// Model
// Service (DAO + DAO)
// DAO : @Repository
// Manager : @Component
// Model : @Controller
// Service : @Service
// AOP (공통모듈) : Aspect

//@Setter
//@Getter

public class EmpVO {

	private int empno;
	private String ename;
	private String job;
	private Date regdate;
	private int sal;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
