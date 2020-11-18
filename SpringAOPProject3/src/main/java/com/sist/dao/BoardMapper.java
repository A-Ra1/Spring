package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface BoardMapper {
	
	@Select("SELECT no, subject, name, regdate, hit, gt, num "
			+"FROM (SELECT no, subject, name, regdate, hit, gt, rownum as num "
			+"FROM (SELECT no, subject, name, regdate, hit, gt "
			+"FROM spring_reply ORDER BY gi DESC, gs ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	
	public List<BoardVO> boardListData(Map map);
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true,
			statement="SELECT NVL(MAX(no)+1, 1) as no FROM spring_reply")
	
	@Insert("INSERT INTO spring_reply(no, name, subject, content, pwd, gi) "
			+"VALUES (#{no}, #{name}, #{subject}, #{content}, #{pwd}, " 
			+"(SELECT NVL(MAX(gi)+1, 1) FROM spring_reply))")
	
	public void boardInsert(BoardVO vo);
	
	
	// 상세보기
	@Update("UPDATE spring_reply SET "
			+"hit=hit+1 "
			+"WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, regdate, hit "
			+"FROM spring_reply "
			+"WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	// 답변
	@Select("SELECT gi, gs, gt FROM spring_reply "
			+"WHERE no=#{no}")
	public BoardVO boardParentData(int no);
	
	@Update("UPDATE spring_reply SET "
			+"gs=gs+1 "
			+"WHERE gi=#{gi} AND gs>#{gs}")
	public void boardGsIncrement(BoardVO vo);
	
	@SelectKey(keyProperty="no", resultType=int.class, before=true, 
			statement="SELECT NVL(MAX(no)+1,1) as no FROM spring_reply")
	@Insert("INSERT INTO spring_reply(no, name, subject, content, pwd, gi, gs, gt, root) "
			+"VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd},"
			+"#{gi}, #{gs}, #{gt}, #{root})")
	public void boardReplyInsert(BoardVO vo);
	
	@Update("UPDATE spring_reply SET "
			+"depth=depth+1 "
			+"WHERE no=#{no}")
	public void boardDepthIncrement(int no);
}
