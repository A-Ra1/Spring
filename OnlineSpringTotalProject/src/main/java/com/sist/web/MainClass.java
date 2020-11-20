package com.sist.web;
/*
 *  스프링 
 *   DL (등록된 클래스 찾기 (getBean())
 *   DI (필요한 데이터를 주입해서 메모리 할당 => 메모리에 저장)
 *   AOP (어느 메소드에 추가여부(PointCut) , 메소드의 어떤 위치(Joinpoint)
 *   										Before : 메소드 시작전
 *   									    After : 무조건 호출 (finally)
 *   										Around : 코딩 위 아래
 *   									    AfterThrowing : catch 수행
 *   										AfterReturning : 리턴값을 받아서 수행
 *   PointCut+JoinPoint => Advice
 *   Advice가 여러개 => Aspect (공통으로 사용디는 메소드의 집합:공통모듈)
 *   트랜잭션, 로그파일, 보안처리를 할 때 AOP 적용
 *   
 *   1. setterDI
 *     <bean id="aaa" class="aaaa"
 *      p:username=""
 *     />
 *   2. 생성자 DI => 생성자의 매개변수를 이용하여 값 주입
 *    <bean id="aaa" class="aaaa"
 *      c:ip=""
 *     />
 *   3. 스프링에 등록된 객체주소 주입
 *      ===================== @Autowired
 *      
 *      스프링의 장점 : 결합성이 낮은 프로그램을 구현 => 유지보수가 편리
 *      			클래스가 독립적으로 수행된다 (POJO)
 *      			메모리 절약
 *        ** 단점 : 어렵다 (xml파싱, 어노테이션)
 *      메이븐 : 라이브러리 관리, 프로젝트 관리, 배포 관리
 *      클래스를 제작 => 스프링에 등록(관리)  xml (application-context.xml)
 *      필요한 클래스를 등록 (어노테이션)
 *        
 */
public class MainClass {

	public static void main(String[] args) {

	}

}
