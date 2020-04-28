package com.it.wecodeyou.interest.repository;

import java.sql.SQLException;

import com.it.wecodeyou.interest.model.InterestVO;

public interface IInterestMapper {

	// insert (설문조사 결과 저장)
	public void insertInterest(InterestVO ivo) throws SQLException ;

	// check (중복검사)
	public Integer checkUserNo(Integer interestUserNo) throws SQLException ;

}
