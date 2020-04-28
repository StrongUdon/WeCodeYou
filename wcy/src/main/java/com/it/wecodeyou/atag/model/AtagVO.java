package com.it.wecodeyou.atag.model;

public class AtagVO {
	
	private Integer aTagNo;
	private Integer aArticleNo;
	
	public AtagVO() {
		super();
	}

	public AtagVO(Integer aTagNo, Integer aArticleNo) {
		super();
		this.aTagNo = aTagNo;
		this.aArticleNo = aArticleNo;
	}

	public Integer getaTagNo() {
		return aTagNo;
	}

	public void setaTagNo(Integer aTagNo) {
		this.aTagNo = aTagNo;
	}

	public Integer getaArticleNo() {
		return aArticleNo;
	}

	public void setaArticleNo(Integer aArticleNo) {
		this.aArticleNo = aArticleNo;
	}

	@Override
	public String toString() {
		return "AtagVO [aTagNo=" + aTagNo + ", aArticleNo=" + aArticleNo + "]";
	}

	
	
	
	
}
