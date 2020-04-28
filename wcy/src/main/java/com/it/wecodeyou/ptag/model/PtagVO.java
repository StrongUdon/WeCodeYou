package com.it.wecodeyou.ptag.model;

public class PtagVO {
	
	private Integer pTagNo;
	private Integer pProductNo;


	public PtagVO() {
		super();
	}
	
	public PtagVO(Integer pTagNo, Integer pProductNo) {
		super();
		this.pTagNo = pTagNo;
		this.pProductNo = pProductNo;
	}

	public Integer getpTagNo() {
		return pTagNo;
	}

	public void setpTagNo(Integer pTagNo) {
		this.pTagNo = pTagNo;
	}

	public Integer getpProductNo() {
		return pProductNo;
	}

	public void setpProductNo(Integer pProductNo) {
		this.pProductNo = pProductNo;
	}

	@Override
	public String toString() {
		return "PtagVO [pTagNo=" + pTagNo + ", pProductNo=" + pProductNo + "]";
	}
	
	
	

}
