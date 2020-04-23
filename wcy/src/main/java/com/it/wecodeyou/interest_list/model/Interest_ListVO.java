package com.it.wecodeyou.interest_list.model;

public class Interest_ListVO {
	
	private String interestListId;
	private String interestListType;
	private String interestListAnswer;
	private String interestListQuestion;
	private Integer interestListOption;
	
	public Interest_ListVO() {}

	public Interest_ListVO(String interestListId, String interestListType, String interestListAnswer,
			String interestListQuestion, Integer interestListOption) {
		super();
		this.interestListId = interestListId;
		this.interestListType = interestListType;
		this.interestListAnswer = interestListAnswer;
		this.interestListQuestion = interestListQuestion;
		this.interestListOption = interestListOption;
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

	public String getInterestListAnswer() {
		return interestListAnswer;
	}

	public void setInterestListAnswer(String interestListAnswer) {
		this.interestListAnswer = interestListAnswer;
	}

	public String getInterestListQuestion() {
		return interestListQuestion;
	}

	public void setInterestListQuestion(String interestListQuestion) {
		this.interestListQuestion = interestListQuestion;
	}

	public int getInterestListOption() {
		return interestListOption;
	}

	public void setInterestListOption(int interestListOption) {
		this.interestListOption = interestListOption;
	}

	@Override
	public String toString() {
		return "Interest_ListVO [interestListId=" + interestListId + ", interestListType=" + interestListType
				+ ", interestListAnswer=" + interestListAnswer + ", interestListQuestion=" + interestListQuestion
				+ ", interestListOption=" + interestListOption + "]";
	}

	

	
}
