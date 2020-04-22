package com.it.wecodeyou.interest_list.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.interest_list.model.Interest_ListVO;
import com.it.wecodeyou.interest_list.repository.IInterest_ListMapper;

@Service
public class Interest_ListService implements IInterest_ListService {

	@Autowired
	private IInterest_ListMapper dao;

	@Override
	public ArrayList<String> getOneInterestType() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getOneInterestType();
	}

	@Override
	public ArrayList<Interest_ListVO> getAllInterestList() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getAllInterestList();
	}
//d
}
