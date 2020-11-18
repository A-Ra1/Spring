package com.sist.dao;
/*
 * <select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
    SELECT no,title,chef,poster,num 
    FROM (SELECT no,title,chef,poster,rownum as num 
    FROM (SELECT no,title,chef,poster 
    FROM recipe))
    WHERE num BETWEEN #{start} AND #{end}
  </select>
  <!-- 총페이지  -->
  <select id="recipeTotalPage" resultType="int">
    SELECT CEIL(COUNT(*)/20.0) FROM recipe
  </select>
  <!-- chef 데이터 -->
  <select id="recipeChefData" resultType="RecipeVO" parameterType="hashmap">
    SELECT no,title,chef,poster,num 
    FROM (SELECT no,title,chef,poster,rownum as num 
    FROM (SELECT no,title,chef,poster 
    FROM recipe WHERE chef=#{chef}))
    WHERE num BETWEEN #{start} AND #{end}
  </select>
  <select id="recipeChefTotalPage" resultType="int" parameterType="string">
    SELECT CEIL(COUNT(*)/20.0) FROM recipe
    WHERE chef=#{chef}
  </select>
 */
import java.util.*;

import org.apache.ibatis.annotations.Select;

public interface RecipeMapper {

	@Select("SELECT no,title,chef,poster,num " 
   + "FROM (SELECT no,title,chef,poster,rownum as num " 
   + "FROM (SELECT no,title,chef,poster " 
   + "FROM recipe_old)) "
   + "WHERE num BETWEEN #{start} AND #{end}")
	
	public List<RecipeVO> recipeListData(Map map);
//			   ========== 				=========
//	 			resulttype				parametertype
	
	@Select("SELECT CEIL(COUNT(*)/20.0) FROM recipe_old")
	public int recipeTotalPage();
}
