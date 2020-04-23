package com.it.wecodeyou.point_purchase.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.it.wecodeyou.point_purchase.model.Point_PurchaseVO;

public interface IPoint_PurchaseService {

	//구매내역 전체 조회 (관리자)
	public ArrayList<Point_PurchaseVO> getAllPurchaseList()throws SQLException;
	
	//한명의 구매내역 조회
	public ArrayList<Point_PurchaseVO> getOnePurchaseList(Integer user_no)throws SQLException;
	
	//한명의 가장최근 구매내역 조회
	public Point_PurchaseVO getOneRecent(Integer user_no) throws SQLException;
	
	//구매 완료 시 insert
	public void insertPointPurchase(Point_PurchaseVO pvo);
	
	//구매완료 시 포인트 추가
	public void addPoint(Point_PurchaseVO pvo);
	
}
