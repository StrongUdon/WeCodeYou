package com.it.wecodeyou.point_purchase.model;

import java.sql.Timestamp;

public class Point_PurchaseVO {

	
	private Integer pointPurchaseNo;
	private Integer pointPurchaseUserNo;
	private String pointPurchaseId;
	private Timestamp pointPurchasePurchasedAt;
	private Integer pointPurchaseAmount;
	
	
	
	public Point_PurchaseVO() {}
	
	public Point_PurchaseVO(Integer pointPurchaseNo, Integer pointPurchaseUserNo, String pointPurchaseId,
			Timestamp pointPurchasePurchasedAt, Integer pointPurchaseAmount) {
		super();
		this.pointPurchaseNo = pointPurchaseNo;
		this.pointPurchaseUserNo = pointPurchaseUserNo;
		this.pointPurchaseId = pointPurchaseId;
		this.pointPurchasePurchasedAt = pointPurchasePurchasedAt;
		this.pointPurchaseAmount = pointPurchaseAmount;
	}
	public Integer getPointPurchaseNo() {
		return pointPurchaseNo;
	}
	public void setPointPurchaseNo(Integer pointPurchaseNo) {
		this.pointPurchaseNo = pointPurchaseNo;
	}
	public Integer getPointPurchaseUserNo() {
		return pointPurchaseUserNo;
	}
	public void setPointPurchaseUserNo(Integer pointPurchaseUserNo) {
		this.pointPurchaseUserNo = pointPurchaseUserNo;
	}
	public String getPointPurchaseId() {
		return pointPurchaseId;
	}
	public void setPointPurchaseId(String pointPurchaseId) {
		this.pointPurchaseId = pointPurchaseId;
	}
	public Timestamp getPointPurchasePurchasedAt() {
		return pointPurchasePurchasedAt;
	}
	public void setPointPurchasePurchasedAt(Timestamp pointPurchasePurchasedAt) {
		this.pointPurchasePurchasedAt = pointPurchasePurchasedAt;
	}
	public Integer getPointPurchaseAmount() {
		return pointPurchaseAmount;
	}
	public void setPointPurchaseAmount(Integer pointPurchaseAmount) {
		this.pointPurchaseAmount = pointPurchaseAmount;
	}
	
	
	

	
	
	
}
