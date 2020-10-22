package com.sist.di2;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;

public class EmpDAO extends SqlSessionDaoSupport{

	public List<EmpVO> empListData() {
		
		return getSqlSession().selectList("empListData");
		// getSqlSession 안에 예외처리가 포함되어 있음 
	}
}
