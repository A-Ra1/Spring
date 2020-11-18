package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface MovieMapper {

	@Select("SELECT no, title, poster, rownum "
			+"FROM daum_movie "
			+"WHERE rownum<20")
	public List<MovieVO> movieListData();
	
	@Select("SELECT * FROM daum_movie "
			+"WHERE no=#{no}")
	public MovieVO movieDetailData(int no);
}
