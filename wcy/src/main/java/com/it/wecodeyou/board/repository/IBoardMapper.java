package com.it.wecodeyou.board.repository;

import java.util.List;

import com.it.wecodeyou.board.model.BoardVO;

public interface IBoardMapper {
	//게시판 삽입문
	public void insertBoard(BoardVO rvo);

	//게시판 삭제
	public void deleteBoard(BoardVO rvo);
	
	//게시판 수정
	public void updateBoard(BoardVO rvo);
	
	//게시판 리스트
	public List<BoardVO> getAllInfo();
}
