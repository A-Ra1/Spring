package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAO {

	@Autowired
	private MongoTemplate mt;
	public List<RecipeVO> recipeListData(int page) {
		
		Query query=new Query(); // WHERE 조건절, SORT, SKIP, LIMIT
		int rowSize=12;
		int skip=(page*rowSize)-(rowSize);
		query.skip(skip).limit(rowSize);
		query.with(new Sort(Sort.Direction.ASC,"no"));
		return mt.find(query, RecipeVO.class,"recipe");
	}
	
	public int recipeCount() {
		
		Query query=new Query();
		int count=(int)mt.count(query, "recipe");
		return count;
	}
	
	public RecipeDetailVO recipeDetailData(int no) {
		
		RecipeDetailVO vo=new RecipeDetailVO();
		BasicQuery query=new BasicQuery("{no:"+no+"}");
		vo=mt.findOne(query, RecipeDetailVO.class, "recipe_detail");
		return vo;
	}
	
	public List<ChefVO> chefListData(int page) {
		
		Query query=new Query(); // WHERE 조건절, SORT, SKIP, LIMIT
		int rowSize=20;
		int skip=(page*rowSize)-(rowSize);
		query.skip(skip).limit(rowSize);
		query.with(new Sort(Sort.Direction.ASC,"no"));
		return mt.find(query, ChefVO.class,"chef");
	}
	
	public List<RecipeVO> chefProductData(String chef, int page) {
		
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		BasicQuery query=new BasicQuery("{chef:'"+chef+"'}"); 
		int rowSize=20;
		int skip=(page*rowSize)-(rowSize);
		query.skip(skip).limit(rowSize);
		list=mt.find(query, RecipeVO.class,"recipe");
		return list;
	}
	
	public List<RecipeVO> chefProductFindData(String chef, String fd) {
		
		List<RecipeVO> list=new ArrayList<RecipeVO>();
		BasicQuery query=new BasicQuery("{$and:[{chef:'"+chef+"'},{title:{$regex:'.*"+fd+"'}}]}");
		list=mt.find(query, RecipeVO.class, "recipe");
		return list;
		
	}
	
	public int chefTotalPage() {
		
		BasicQuery query=new BasicQuery("{}");
		List<ChefVO> list=mt.find(query, ChefVO.class, "chef");
		int count=list.size();
		int total=(int)(Math.ceil(count/20.0));
		return total;
	}
}
