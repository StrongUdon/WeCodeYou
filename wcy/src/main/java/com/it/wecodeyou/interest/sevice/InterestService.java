package com.it.wecodeyou.interest.sevice;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.interest.model.InterestVO;
import com.it.wecodeyou.interest.repository.IInterestMapper;

@Service
public class InterestService implements IInterestService{
	
	@Autowired
	   private IInterestMapper dao;

	@Override
	public void insertInterest(InterestVO ivo)  throws SQLException {
		// TODO Auto-generated method stub
		dao.insertInterest(ivo);
	}

	@Override
	public Integer checkUserNo(Integer interestUserNo)  throws SQLException {
		// TODO Auto-generated method stub
		return dao.checkUserNo(interestUserNo);
	}
	
}
