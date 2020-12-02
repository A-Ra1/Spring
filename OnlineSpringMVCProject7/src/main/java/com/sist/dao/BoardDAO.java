package com.sist.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.mongodb.*;
import java.text.*;

@Repository
public class BoardDAO {

	private MongoClient mc; // Connection
	private DB db; // XE (데이터베이스) => mydb
	private DBCollection dbc; // 테이블
	public BoardDAO() {
		
		try {
			
			// 연결
			mc=new MongoClient("localhost", 27017);
			
			// 데이터베이스 연결
			db=mc.getDB("mydb");
			
			// 테이블 연결
			dbc=db.getCollection("board");
			
		} catch (Exception e) {

		}
	}
		// 추가
		public void boardInsert(BoardVO vo) {
			
			try {
				
				int max=0;
				DBCursor cursor=dbc.find();
				// DBCursor => ResultSet
				// dbc.find(); => ps.executeQuery(SELECT * FROM board) 
				while(cursor.hasNext()) {
					
					BasicDBObject obj=(BasicDBObject)cursor.next();
					int no=obj.getInt("no");
					if(max<no)
						max=no;
				}
				
				cursor.close();
				// Sequence => 자동 증가번호 (SELECT MAX(no) FROM board)
				// 추가
				BasicDBObject obj=new BasicDBObject();
				obj.put("no", max+1);
				obj.put("name", vo.getName());
				obj.put("subject", vo.getSubject());
				obj.put("content", vo.getContent());
				obj.put("pwd", vo.getPwd());
				obj.put("regdate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				obj.put("hit", 0);
				
				dbc.insert(obj);
				
			} catch (Exception e) {

				System.out.println(e.getMessage());
			
			}
		
		}
		
		// 데이터 읽기
		public List<BoardVO> boardListData(int page) {
			
			List<BoardVO> list=new ArrayList<BoardVO>();
			
			try {
				
				int rowSize=10;
				int skip=(rowSize*page)-rowSize;
				 
				DBCursor cursor=dbc.find().skip(skip).limit(rowSize).sort(new BasicDBObject("no",-1));
				while(cursor.hasNext()) {
					
					BasicDBObject obj=(BasicDBObject)cursor.next();
					BoardVO vo=new BoardVO();
					vo.setNo(obj.getInt("no"));
					vo.setSubject(obj.getString("subject"));
					vo.setName(obj.getString("name"));
					vo.setRegdate(obj.getString("regdate"));
					vo.setHit(obj.getInt("hit"));
					list.add(vo);
					
				}
				
				cursor.close();
				
			} catch (Exception e) {

			}
			return list;
		}
		
		// 상세보기
		
		public BoardVO boardDetailData(int no, int type) {
			
			BoardVO vo=new BoardVO();
			
			try {
				
				BasicDBObject where=new BasicDBObject();
				where.put("no", no);
				
				BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
//				dbc.findOne => SELECT * FROM WHERE no=1; => {no:1}
				
				if(type==1) {
				
				int hit=obj.getInt("hit");
				BasicDBObject up=new BasicDBObject("$set",new BasicDBObject("hit", hit+1));
				dbc.update(where, up); // 조회수 증가
				
				}
				
				obj=(BasicDBObject)dbc.findOne(where);
				vo.setNo(obj.getInt("no"));
				vo.setName(obj.getString("name"));
				vo.setSubject(obj.getString("subject"));
				vo.setContent(obj.getString("content"));
				vo.setRegdate(obj.getString(""));
				vo.setHit(obj.getInt("hit"));
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			
			}
			return vo;
		}
		// 수정하기
		public boolean boardUpdate(BoardVO vo) {
			
			boolean bCheck=false;
			
			try {
				
				// 몽고디비에 저장된 비밀번호 읽기
				BasicDBObject where=new BasicDBObject();
				where.put("no", vo.getNo());
				
				BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
				// find : 리턴형 DBCursor ~ 여러개{}, findOne : 리턴형 BasicDBObject ~ 한개{}
				if(vo.getPwd().equals(obj.getString("pwd"))) {
					
					bCheck=true;
					BasicDBObject updateObj=new BasicDBObject();
					updateObj.put("name", vo.getName());
					updateObj.put("subject", vo.getSubject());
					updateObj.put("content", vo.getContent());
					
					BasicDBObject update=new BasicDBObject("$set", updateObj);
					// 몽고디비에 전송
					dbc.update(where, update); // where에 해당하는 데이터를 update로 바꾸어라
					
				} else {
					
					bCheck=false;
				}
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			return bCheck;
		}
		// 삭제하기
		
		public boolean boardDelete(int no, String pwd) {
			
			boolean bCheck=false;
			
			try {
				
				BasicDBObject where=new BasicDBObject();
				where.put("no", no);
				
				// 비밀번호 가져오기
				BasicDBObject obj=(BasicDBObject)dbc.findOne(where);
				
				// 조건
				if(pwd.equals(obj.getString("pwd"))) {
					
					bCheck=true;
					dbc.remove(where);
					
				} else {
					
					bCheck=false;
				}
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			return bCheck;
		}
		
		// 총페이지
		public int boardTotalPage() {
			
			int total=0;
			
			try {
				
				DBCursor cursor=dbc.find();
				total=cursor.count(); // SELECT COUNT(*) FROM board
			} catch (Exception e) {

				System.out.println(e.getMessage());
			}
			return (int)Math.ceil(total/10.0);
		}
	
}
