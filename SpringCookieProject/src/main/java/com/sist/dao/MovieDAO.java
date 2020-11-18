package com.sist.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAO {

	@Autowired
	private MovieMapper mapper;
	public List<MovieVO> movieListData() {
		
		return mapper.movieListData();
	}
	
	public MovieVO movieDetailData(int no) {
		
		return mapper.movieDetailData(no);
	}
}
