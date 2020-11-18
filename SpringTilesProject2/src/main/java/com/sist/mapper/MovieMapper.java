package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MovieVO;
		
public interface MovieMapper {

	@Select("SELECT no, title, poster, num "
			+"FROM (SELECT no, title, poster, rownum as num "
			+"FROM (SELECT no, title, poster "
			+"FROM daum_movie)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<MovieVO> movieListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM daum_movie")
	public int movieTotalPage();
	
	@Select("SELECT no, title, poster, rownum "
			+"FROM (SELECT no, title, poster "
			+"FROM daum_movie "
			+"ORDER BY hit DESC) "
			+"WHERE rownum<=5")
	public List<MovieVO> movieTop5Hit();
		
}
