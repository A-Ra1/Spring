package com.sist.manager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class MovieManager {
	
	public static void main(String[] args) {
		
		MovieManager m=new MovieManager();
		String json=""; //m.jsonAllData(1);
		json=json.substring(json.indexOf("["), json.lastIndexOf("]")+1);
		try {
			/*
			 * [] JSONArray
			 * {} JSONObject => JavaScript (객체)
			 * 
			 */
		
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(json);
			System.out.println("JSONArray => arr");
			System.out.println(arr.toJSONString());
			
			for(int i=0; i<arr.size(); i++) {
				
				JSONObject obj=(JSONObject)arr.get(i);
//				System.out.println((i+1)+":"+obj);
				System.out.println("영화명:"+obj.get("movieNm"));
				System.out.println("감독:"+obj.get("director"));
				System.out.println("장르:"+obj.get("genre"));
				System.out.println("등급:"+obj.get("watchGradeNm"));
				System.out.println("개봉일:"+obj.get("openDt"));
				System.out.println("줄거리:"+obj.get("synop"));
				System.out.println("=================================");
				
			}
			
		} catch (Exception e) {
		}
//		System.out.println(json);
	}

	public List<MovieVO> jsonAllData(int type) {
	
		List<MovieVO> list=new ArrayList<MovieVO>();
//		String json="";
		String url="http://www.kobis.or.kr/kobis/business/main/";
		switch(type) {
		
		case 1:
			url+="searchMainDailyBoxOffice.do";
			break;
		case 2:
			url+="searchMainRealTicket.do";
			break;
		case 3:
			url+="searchMainDailySeatTicket.do";
			break;
		case 4:
			url+="searchMainOnlineDailyBoxOffice.do";
			break;
			
		} try {

			Document doc=Jsoup.connect(url).get();
			String json=doc.toString();
			json=json.substring(json.indexOf("["), json.lastIndexOf("]")+1);
			
			JSONParser jp=new JSONParser();
			JSONArray arr=(JSONArray)jp.parse(json);
			System.out.println("JSONArray => arr");
			System.out.println(arr.toJSONString());
			
			for(int i=0; i<arr.size(); i++) {
				
				JSONObject obj=(JSONObject)arr.get(i);
//				System.out.println((i+1)+":"+obj);
				MovieVO vo=new MovieVO();
				vo.setMno(i+1);
				vo.setRank((int)obj.get("rank"));
				vo.setTitle_ko((String)obj.get("movieNm"));
				vo.setTitle_en((String)obj.get("movieNmEn"));
				vo.setDirector((String)obj.get("director"));
				vo.setGenre((String)obj.get("genre"));
				vo.setPoster("http://www.kobis.or.kr"+(String)obj.get("thumbUrl"));
				vo.setGrade((String)obj.get("watchGradeNm"));
				vo.setRegdate((String)obj.get("openDt"));
				vo.setStory((String)obj.get("showTm"));
				vo.setTime((String)obj.get("showTm"));
				vo.setRank_id((int)obj.get("rankInten"));
				vo.setNation((String)obj.get("repNationCd"));
				list.add(vo);
				
				System.out.println("영화명:"+obj.get("movieNm"));
				System.out.println("감독:"+obj.get("director"));
				System.out.println("장르:"+obj.get("genre"));
				System.out.println("등급:"+obj.get("watchGradeNm"));
				System.out.println("개봉일:"+obj.get("openDt"));
				System.out.println("줄거리:"+obj.get("synop"));
				System.out.println("=================================");
				
			}
			
		} catch (Exception e) {
		} 
		return list;
	}
}
