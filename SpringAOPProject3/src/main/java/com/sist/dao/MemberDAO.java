package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	@Autowired
	private MemberMapper mapper;
	
	public String isLogin(String id, String pwd) {
		
		String result="";
		int count=mapper.idCheck(id);
		if(count==0) {
			
			result="NOID";
			
		} else {
			
			String db_pwd=mapper.memberGetPassword(id);
			if(db_pwd.equals(pwd)) {
				
				result="OK"; // Session
				
			} else {
				
				result="NOPWD";
			}
		}
		return result;
	}
	
}
