package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface RecipeMapper {

	@Select("SELECT no, title, poster, chef, num "
			+"FROM (SELECT no, title, poster, chef, rownum as num "
			+"FROM (SELECT no, title, poster, chef "
			+"FROM recipe_old ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<RecipeVO> recipeListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe_old")
	public int recipeTotalPage();
}
