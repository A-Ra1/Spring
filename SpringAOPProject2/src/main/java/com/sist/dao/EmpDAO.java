package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO {
    @Autowired
	private DBConnection dbConn;
	private Connection conn;
	private PreparedStatement ps;
	public EmpDAO()
	{
		
	}
	public List<EmpVO> empListData()
	   {
		   //conn=dbConn.getConn();
		   List<EmpVO> list=new ArrayList<EmpVO>();
		   // @Before
		   try
		   {
			   // @Around => 실행 전 => setAutoCommit(false)
			   // 핵심 코딩(DML)
			   // 실행 후 => commit
			   
			   String sql="SELECT empno,ename,job,hiredate,sal,"
					     +"(SELECT dname FROM dept d WHERE d.deptno=e.deptno) as dname,"
					     +"(SELECT loc FROM dept d WHERE d.deptno=e.deptno) as loc "
					     +"FROM emp e";
			   ps=dbConn.getConn().prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   EmpVO vo=new EmpVO();
				   vo.setEmpno(rs.getInt(1));
				   vo.setEname(rs.getString(2));
				   vo.setJob(rs.getString(3));
				   vo.setHiredate(rs.getDate(4));
				   vo.setSal(rs.getInt(5));
				   vo.setDname(rs.getString(6));
				   vo.setLoc(rs.getString(7));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   // @After-Throwing => rollback
			   System.out.println(ex.getMessage());
		   }
		   
		   return list; // @After-Returning
	   }
	   // 상세보기 
	   public EmpVO empDetailData(int empno)
	   {
		   EmpVO vo=new EmpVO();
		   
		   try
		   {
			   
			   String sql="SELECT empno,ename,job,hiredate,sal,"
					     +"(SELECT dname FROM dept d WHERE d.deptno=e.deptno) as dname,"
					     +"(SELECT loc FROM dept d WHERE d.deptno=e.deptno) as loc "
					     +"FROM emp e "
					     +"WHERE empno=?";
			   ps=dbConn.getConn().prepareStatement(sql);
			   ps.setInt(1, empno);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setEmpno(rs.getInt(1));
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setHiredate(rs.getDate(4));
			   vo.setSal(rs.getInt(5));
			   vo.setDname(rs.getString(6));
			   vo.setLoc(rs.getString(7));
			   rs.close();
		   }catch(Exception ex)
		   {
			   System.out.println(ex.getMessage());
		   }
		   
		   return vo;
	   }
	   
	   public void deptInsert(int deptno, String dname, String loc) {
		   
		   try {
			   
			   dbConn.getConnection();
			   conn=dbConn.getConn();
			   conn.setAutoCommit(false);
			   String sql="INSERT INTO dept VALUES(?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, deptno);
			   ps.setString(2, dname);
			   ps.setString(3, loc);
			   ps.executeUpdate();
			   
			   sql="INSERT INTO dept VALUES(?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, deptno);
			   ps.setString(2, dname);
			   ps.setString(3, loc);
			   ps.executeUpdate();
			   
			   conn.commit();
		} catch (Exception e) {
		
			try {
				
				conn.rollback();
				
			} catch (Exception e2) {
			}
			System.out.println(e.getMessage());
			
		} finally {
			
			try {

				conn.setAutoCommit(true); 
				
			} catch (Exception e2) {
			}
			dbConn.disConnection();
			
		}
	   }
}