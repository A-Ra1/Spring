package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper mapper;
	
	public List<BoardVO> boardListData(Map map) {
		
		return mapper.boardListData(map);
				
	}
	
	public void boardInsert(BoardVO vo) {
		
		mapper.boardInsert(vo);
	}
	
	public BoardVO boardDetailData(int no) {
		
		// 조회수 증가
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void boardReplyInsert(int root, BoardVO vo) {
		
		BoardVO pvo=mapper.boardParentData(root);
		mapper.boardGsIncrement(pvo);
		vo.setGi(pvo.getGi());
		vo.setGs(pvo.getGs()+1);
		vo.setGt(pvo.getGt()+1);
		mapper.boardReplyInsert(vo);
		mapper.boardDepthIncrement(root);
		
	}
}
