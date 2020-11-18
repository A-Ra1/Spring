package com.sist.aspect;

import com.sist.dao.*;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * @Aspect : 공통모듈 (DAO에서 공통 사용 내용을 모아준다), 메모리 할당은 하지 않는다
   @Component : 메모리 할당 (메모리 할당을 하지 않으면 다른 클래스를 가져오지 못한다)
	
	자동 호출 
	1. 언제 호출할건지 : PointCut
	2. 어디서 호출할건지 : JoinPoint
	=========================== Advice
	Advice 여러개를 모은 기능 : Aspect
 */

@Aspect
@Component
public class DBAspect {

	@Autowired
	private DBConnection dbConn;
	
	@Before("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void before() {
		
		dbConn.getConnection();
	}
	
	@After("execution(* com.sist.dao.EmpDAO.emp*(..))")
	public void after() {
		
		dbConn.disConnection();
	}
	
	@Around("execution(* com.sist.web.EmpController.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		
		Object obj=null;
		System.out.println("사용자 호출전 :"+jp.getSignature().getName());
		obj=jp.proceed();
		System.out.println("사용자 호출후 :"+jp.getSignature().getName());
		return obj;
	}
	
	@AfterReturning(value="execution(* com.sist.web.EmpController.*(..))", returning="val")
	public void afterReturning(JoinPoint jp, Object val) {
		
		System.out.println("리턴값:"+val);
	}
	
	@AfterThrowing(value="execution(* com.sist.web.EmpController.*(..))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		
		System.out.println(ex.getMessage());
	}
}
