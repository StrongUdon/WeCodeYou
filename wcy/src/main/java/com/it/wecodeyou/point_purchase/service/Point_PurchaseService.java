package com.it.wecodeyou.point_purchase.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.point_purchase.model.Point_PurchaseVO;
import com.it.wecodeyou.point_purchase.repository.IPoint_PurchaseMapper;

@Service
public class Point_PurchaseService implements IPoint_PurchaseService{

	
	@Autowired
	private IPoint_PurchaseMapper dao;

	@Override
	public ArrayList<Point_PurchaseVO> getAllPurchaseList() throws SQLException {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseList();
	}

	@Override
	public ArrayList<Point_PurchaseVO> getOnePurchaseList(Integer user_no) throws SQLException {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseList(user_no);
	}

	@Override
	public void insertPointPurchase(Point_PurchaseVO pvo) {
		// TODO Auto-generated method stub
		dao.insertPointPurchase(pvo);
		
	}


	
	
}
