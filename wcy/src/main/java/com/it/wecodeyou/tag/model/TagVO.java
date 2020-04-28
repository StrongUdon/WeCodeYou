package com.it.wecodeyou.tag.model;

public class TagVO {
	
	private Integer tagNo;
	private String tagName;
	
	public TagVO() {
		super();
	}

	public TagVO(Integer tagNo, String tagName) {
		super();
		this.tagNo = tagNo;
		this.tagName = tagName;
	}

	public Integer getTagNo() {
		return tagNo;
	}

	public void setTagNo(Integer tagNo) {
		this.tagNo = tagNo;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "TagVO [tagNo=" + tagNo + ", tagName=" + tagName + "]";
	}
	
	
	

}
