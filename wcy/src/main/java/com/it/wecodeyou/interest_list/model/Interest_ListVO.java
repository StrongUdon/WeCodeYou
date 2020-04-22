package com.it.wecodeyou.interest_list.model;

public class Interest_ListVO {
	
	private String interestListId;
	private String interestListType;
	private String interestListName;
	
	public Interest_ListVO() {}

	public Interest_ListVO(String interestListId, String interestListType, String interestListName) {
		super();
		this.interestListId = interestListId;
		this.interestListType = interestListType;
		this.interestListName = interestListName;
	}

	public String getInterestListId() {
		return interestListId;
	}

	public void setInterestListId(String interestListId) {
		this.interestListId = interestListId;
	}

	public String getInterestListType() {
		return interestListType;
	}

	public void setInterestListType(String interestListType) {
		this.interestListType = interestListType;
	}

	public String getInterestListName() {
		return interestListName;
	}

	public void setInterestListName(String interestListName) {
		this.interestListName = interestListName;
	}

	@Override
	public String toString() {
		return "Interest_ListVO [interestListId=" + interestListId + ", interestListType=" + interestListType
				+ ", interestListName=" + interestListName + "]";
	}
	
	
}
