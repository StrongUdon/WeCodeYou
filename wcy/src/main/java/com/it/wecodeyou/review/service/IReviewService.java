package com.it.wecodeyou.review.service;

import java.util.ArrayList;

import com.it.wecodeyou.review.model.ReviewVO;

public interface IReviewService {

	//리뷰는 수정이 불가하여 수정 기능 없음
	
	//작성 insert
	public void insertReview(ReviewVO rvo);
	
	//개별 출력 (상세조회)
	public ReviewVO getOneReview(Integer reviewNo);
	
	//리스트 출력 (강의별로) => 각 강의의 상세페이지 하단에서 출력 
	public ArrayList<ReviewVO> getAllReviewByLec(ReviewVO rvo);
	
	//리스트 출력 (사용자별로) => 마이페이지에서 확인 가능
	public ArrayList<ReviewVO> getAllReviewByUser(String reviewUser);
	
	//삭제 (삭제 권한은 관리자에게만)
	public void deleteReview(Integer reviewNo);
	
}
