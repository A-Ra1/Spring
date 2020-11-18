package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 *  스프링에서 어노테이션으로 메모리 할당 요청
 *  ==============================
 *  @Controller : 모델클래스 연결 시 사용 (return 시 반드시 jsp파일명 or .do 사용) 화면 변경, 이동 시 사용
 *  @RestController : 모델클래스 연결 시 사용 (화면 변경 X, 스크립트나 xml, JSON 전송 시 사용) 
 *  @Repository : 저장소 (DB 관련, DAO)
 *  @Component : Jsoup, 뉴스, openAPI 
 *  @Service : DAO가 여러개일 때 조립해서 사용
 *  
 *  DAO와 Service의 차이
 *  
 *  스프링에서 어노테이션으로 할당된 클래스의 메모리 주소를 받는다
 *  @Autowired : 스프링 내부에서 찾아 자동으로 주입
 *  @Resource : 프로그래머가 요청, 반드시 id명을 사용한다
 */

import java.util.*;
@Repository
public class RecipeDAO {

	@Autowired // 구현된 클래스를 받아온다
	private RecipeMapper mapper;
	
	public List<RecipeVO> recipeListData(Map map) {
	
		return mapper.recipeListData(map);
	}
	
	public int recipeTotalPage() {
		
		return mapper.recipeTotalPage();
	}
}
