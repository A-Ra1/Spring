package com.sist.board.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
@Repository
public class BoardDAO {
	@Autowired
    private DBConnection dbConn;
	private CallableStatement cs; // 프로시저
	private PreparedStatement ps; // sql
	public List<BoardVO> boardListData(int page)
	{
		System.out.println("BoardDAO:"+dbConn);
		List<BoardVO> list=new ArrayList<BoardVO>();
		// dbConn.getConnection()
		/*
		 *   CREATE OR REPLACE PROCEDURE projetBoardListData(
			   pStart NUMBER,
			   pEnd NUMBER,
			   pResult OUT SYS_REFCURSOR,
			   pTotal OUT NUMBER
			)
		 */
		try
		{
			String sql="{CALL projectBoardListData(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(1, start);
			cs.setInt(2, end);
			cs.registerOutParameter(3, OracleTypes.CURSOR);
			// 실행
			cs.executeQuery();
			
			// 데이터 받기
			ResultSet rs=(ResultSet)cs.getObject(3);
			while(rs.next())
			{
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setRegdate(rs.getDate(4));
				vo.setName(rs.getString(3));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){
		}
		// dbConn.disConnection
		return list;
		
		
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE projectBoardInsert(
		   pName project_board.name%TYPE,
		   pSubject project_board.subject%TYPE,
		   pContent project_board.content%TYPE,
		   pPwd project_board.pwd%TYPE
		)
		IS
	 */
	public void boardInsert(BoardVO vo)
	{
		try
		{
			String sql="{CALL projectBoardInsert(?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			
			cs.setString(1, vo.getName());
			cs.setString(2, vo.getSubject());
			cs.setString(3, vo.getContent());
			cs.setString(4, vo.getPwd());
			
			cs.executeQuery();
			
		}catch(Exception ex){
		}
	}
	/*
	 *   CREATE OR REPLACE PROCEDURE projectBoardDetailData(
		   pNo project_board.no%TYPE,
		   pResult OUT SYS_REFCURSOR
		)
	 */
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		// getConnection() => @Before
		try
		{
			String sql="{CALL projectBoardDetailData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			// 데이터 받기
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex){
		}
		// disConnection() => @After
		return vo;
	}
	
	// 수정데이터 읽기
	public BoardVO boardUpdateData(int no) {
		
		BoardVO vo=new BoardVO();
		
		try {
			
			String sql="{CALL projectBoardUpdateData(?,?)}";
			cs=dbConn.getConn().prepareCall(sql); // 오라클연결
			cs.setInt(1, no);
			// out변수는 저장공간을 만들어준다
			cs.registerOutParameter(2, OracleTypes.CURSOR );
			cs.executeQuery();
			// 저장공간에서 값을 가지고 온다
			ResultSet rs=(ResultSet)cs.getObject(2);
			rs.next();
			
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
		} catch (Exception ex) {
		}
		return vo;
	}
    
	public boolean boardUpdate(BoardVO vo) {
		
		boolean bCheck=false;
		// dbConn.getConnection()
		try {
			
			String sql="{CALL projectBoardUpdate(?,?,?,?,?,?)}";
			// 값을 채워서 오라클로 전송
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getNo());
			cs.setString(2, vo.getName());
			cs.setString(3, vo.getSubject());
			cs.setString(4, vo.getContent());
			cs.setString(5, vo.getPwd());
			cs.registerOutParameter(6, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(6);
			bCheck=Boolean.parseBoolean(result);
			
		} catch (Exception ex) {
		}
		// dbConn.disConnection()
		return bCheck;
	}
	
	public boolean boardDelete(int no, String pwd) {
		
		boolean bCheck=false;
		try {
			
			String sql="{CALL projectBoardDelete(?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, pwd);
			cs.registerOutParameter(3, OracleTypes.VARCHAR);
			cs.executeQuery();
			String result=cs.getString(3);
			bCheck=Boolean.parseBoolean(result);
			
		} catch (Exception ex) {
		}
		return bCheck;
	}
	
	public int boardTotalPage() {
		
		int total=0;
		try {

			String sql="SELECT boardTotalPage() FROM project_board";
			ps=dbConn.getConn().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			ps.close();
			
		} catch (Exception ex) {
		}
		return total;
	}
	
	// 댓글
	public List<ReplyVO> replyListData(int type, int cno, int page) {
		
		List<ReplyVO> list=new ArrayList<ReplyVO>();
		
		try {
			
			String sql="{CALL replyListData(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, type);
			cs.setInt(2, cno);
			int rowSize=5;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			cs.setInt(3, start);
			cs.setInt(4, end);
			cs.registerOutParameter(5, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(5);
			
			// 순서 맞추어서 넣어주기
			while(rs.next()) {
				
				ReplyVO vo=new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setType(rs.getInt(2));
				vo.setCno(rs.getInt(3));
				vo.setId(rs.getString(4));
				vo.setName(rs.getString(5));
				vo.setMsg(rs.getString(6));
				vo.setDbday(rs.getString(7));
				list.add(vo);
				
			}
			
		} catch (Exception ex) {
		}
	
		return list;
				
	}
	
	public void replyInsert(ReplyVO vo) {
		
		try {
			
			String sql="{CALL replyInsert(?,?,?,?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, vo.getType());
			cs.setInt(2, vo.getCno());
			cs.setString(3, vo.getId());
			cs.setString(4, vo.getName());
			cs.setString(5, vo.getMsg());
			cs.executeQuery();
			
		} catch (Exception ex) {
		}
	}
	
	public void replyUpdate(int no, String msg) {
		
		try {

			String sql="{CALL replyUpdate(?,?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.setString(2, msg);
			cs.executeQuery();
		} catch (Exception ex) {
		}
	}
	
	public void replyDelete(int no) {
		
		try {
			
			String sql="{CALL replyDelete(?)}";
			cs=dbConn.getConn().prepareCall(sql);
			cs.setInt(1, no);
			cs.executeQuery();
			
		} catch (Exception ex) {
		}
	}
	
	// 로그인
	public MemberVO memberLogin(String id, String pwd) {
		
		MemberVO vo=new MemberVO();
		
		try {
			
			dbConn.getConnection();
			String sql="SELECT COUNT(*) FROM member5 "
					+"WHERE id=?";
			ps=dbConn.getConn().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0) {
				
				vo.setMsg("NOID");
			
			} else {
				
				sql="SELECT pwd, name FROM member5 "
					+"WHERE id=?";
				ps=dbConn.getConn().prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				
				if(db_pwd.equals(pwd)) {
					
					vo.setId(id);
					vo.setName(name);
					vo.setMsg("OK");
					
				} else {
					
					vo.setMsg("NOPWD");
				}
			}
			
		} catch (Exception ex) {

			System.out.println(ex.getMessage());
		
		} finally {
			
			dbConn.getConnection();
		}
		return vo;
	}
}