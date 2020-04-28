package com.it.wecodeyou.interest.model;

public class InterestVO {
	private Integer interestNo;
	private Integer interestUserNo;
	private String interestIndex0;
	private String interestIndex1;
	private String interestIndex2;
	private String interestIndex3;
	private String interestIndex4;
	private String interestIndex5;
	
	
	public InterestVO() {
		super();
	}


	public InterestVO(Integer interestNo, Integer interestUserNo, String interestIndex0, String interestIndex1,
			String interestIndex2, String interestIndex3, String interestIndex4, String interestIndex5) {
		super();
		this.interestNo = interestNo;
		this.interestUserNo = interestUserNo;
		this.interestIndex0 = interestIndex0;
		this.interestIndex1 = interestIndex1;
		this.interestIndex2 = interestIndex2;
		this.interestIndex3 = interestIndex3;
		this.interestIndex4 = interestIndex4;
		this.interestIndex5 = interestIndex5;
	}


	public Integer getInterestNo() {
		return interestNo;
	}


	public void setInterestNo(Integer interestNo) {
		this.interestNo = interestNo;
	}


	public Integer getInterestUserNo() {
		return interestUserNo;
	}


	public void setInterestUserNo(Integer interestUserNo) {
		this.interestUserNo = interestUserNo;
	}


	public String getInterestIndex0() {
		return interestIndex0;
	}


	public void setInterestIndex0(String interestIndex0) {
		this.interestIndex0 = interestIndex0;
	}


	public String getInterestIndex1() {
		return interestIndex1;
	}


	public void setInterestIndex1(String interestIndex1) {
		this.interestIndex1 = interestIndex1;
	}


	public String getInterestIndex2() {
		return interestIndex2;
	}


	public void setInterestIndex2(String interestIndex2) {
		this.interestIndex2 = interestIndex2;
	}


	public String getInterestIndex3() {
		return interestIndex3;
	}


	public void setInterestIndex3(String interestIndex3) {
		this.interestIndex3 = interestIndex3;
	}


	public String getInterestIndex4() {
		return interestIndex4;
	}


	public void setInterestIndex4(String interestIndex4) {
		this.interestIndex4 = interestIndex4;
	}


	public String getInterestIndex5() {
		return interestIndex5;
	}


	public void setInterestIndex5(String interestIndex5) {
		this.interestIndex5 = interestIndex5;
	}


	@Override
	public String toString() {
		return "InterestVO [interestNo=" + interestNo + ", interestUserNo=" + interestUserNo + ", interestIndex0="
				+ interestIndex0 + ", interestIndex1=" + interestIndex1 + ", interestIndex2=" + interestIndex2
				+ ", interestIndex3=" + interestIndex3 + ", interestIndex4=" + interestIndex4 + ", interestIndex5="
				+ interestIndex5 + "]";
	}


	
}
