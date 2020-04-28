package com.it.wecodeyou.review.model;

import java.sql.Timestamp;

public class ReviewVO {
	
	private Integer reviewNo;
	private String reviewUser;			//user테이블 email 참조하는 외래키
	private Integer reviewProductNo;	//prodect테이블 prodeuct_no 참조하는 외래키
	private Integer reviewStar;
	private String content;
	private Timestamp reviewCreatedAt;
	
	public ReviewVO() {}
	
	

	public ReviewVO(Integer reviewNo, String reviewUser, Integer reviewProductNo, Integer reviewStar,
			String content, Timestamp reviewCreatedAt) {
		super();
		this.reviewNo = reviewNo;
		this.reviewUser = reviewUser;
		this.reviewProductNo = reviewProductNo;
		this.reviewStar = reviewStar;
		this.content = content;
		this.reviewCreatedAt = reviewCreatedAt;
	}


	public Integer getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(Integer reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}

	public Integer getReviewProductNo() {
		return reviewProductNo;
	}

	public void setReviewProductNo(Integer reviewProductNo) {
		this.reviewProductNo = reviewProductNo;
	}

	public Integer getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(Integer reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getReviewCreatedAt() {
		return reviewCreatedAt;
	}

	public void setReviewCreatedAt(Timestamp reviewCreatedAt) {
		this.reviewCreatedAt = reviewCreatedAt;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", reviewUser=" + reviewUser + ", reviewProductNo=" + reviewProductNo
				+ ", reviewStar=" + reviewStar + ", content=" + content
				+ ", reviewCreatedAt=" + reviewCreatedAt + "]";
	}
	
	
	
}
