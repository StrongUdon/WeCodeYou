package com.it.wecodeyou.interest_list.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.it.wecodeyou.interest_list.model.Interest_ListVO;

public interface IInterest_ListService {

	// 전체 타입 목록 출력 (String 리스트 ex. "lang", "period"...)
	public ArrayList<Interest_ListVO> getOneInterestType() throws SQLException;
	
	//

	// 전체 interst_list 정보 출력
	public ArrayList<Interest_ListVO> getAllInterestList() throws SQLException;
}
