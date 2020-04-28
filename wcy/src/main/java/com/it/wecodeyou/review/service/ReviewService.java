package com.it.wecodeyou.review.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.review.model.ReviewVO;
import com.it.wecodeyou.review.repository.IReviewMapper;

@Service
public class ReviewService implements IReviewService{

	
	@Autowired
	private IReviewMapper dao;
	
	
	
	@Override
	public void insertReview(ReviewVO rvo) {
		dao.insertReview(rvo);
	}

	@Override
	public ReviewVO getOneReview(Integer reviewNo) {
		return dao.getOneReview(reviewNo);
	}

	@Override
	public ArrayList<ReviewVO> getAllReviewByLec(ReviewVO rvo) {
		return null;
	}

	@Override
	public ArrayList<ReviewVO> getAllReviewByUser(String reviewUser) {
		return null;
	}

	@Override
	public void deleteReview(Integer reviewNo) {
		dao.deleteReview(reviewNo);
	}



}
