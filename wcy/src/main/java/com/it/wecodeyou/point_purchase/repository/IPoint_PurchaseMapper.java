package com.it.wecodeyou.point_purchase.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import com.it.wecodeyou.point_purchase.model.Point_PurchaseVO;

public interface IPoint_PurchaseMapper {

	//구매내역 전체 조회 (관리자)
	public ArrayList<Point_PurchaseVO> getAllPurchaseList() throws SQLException;
	
	//한명의 구매내역 조회
	public ArrayList<Point_PurchaseVO> getOnePurchaseList(Integer user_no)throws SQLException;
	
	//구매 완료 시 insert
	public void insertPointPurchase(Point_PurchaseVO pvo);
	
}
