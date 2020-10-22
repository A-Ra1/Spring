package com.sist.di2;

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

public class ApplicationContext {

	private Map map=new HashMap();
	public ApplicationContext(String path) {
		
		try {
			
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParser xp=new XMLParser();
			sp.parse(new File(path), xp);
			map=xp.map;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// DL (lookup) : 이름 (key)를 가지고 클래스 객체 주소를 찾아주는 역할
	
	public Object getBean(String key) {
		
		return map.get(key);
	}
}
