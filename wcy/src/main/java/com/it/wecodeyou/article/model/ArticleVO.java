package com.it.wecodeyou.article.model;

import java.sql.Timestamp;

public class ArticleVO {
	private long articleNo;
	private String articleTitle;
	private String articleContent;
	private String articleBoardTitle;
	private Integer articleClicks;
	private Integer articleLikes;
	private long articleEditorNo;
	private Timestamp articleCreatedAt;
	private Timestamp articleModifiedAt;
	
	public ArticleVO(long articleNo, String articleTitle, String articleContent, String articleBoardTitle,
			Integer articleClicks, Integer articleLikes, long articleEditorNo, Timestamp articleCreatedAt,
			Timestamp articleModifiedAt) {
		super();
		this.articleNo = articleNo;
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleBoardTitle = articleBoardTitle;
		this.articleClicks = articleClicks;
		this.articleLikes = articleLikes;
		this.articleEditorNo = articleEditorNo;
		this.articleCreatedAt = articleCreatedAt;
		this.articleModifiedAt = articleModifiedAt;
	}

	public ArticleVO(String articleTitle, String articleContent, String articleBoardTitle, long articleEditorNo) {
		super();
		this.articleTitle = articleTitle;
		this.articleContent = articleContent;
		this.articleBoardTitle = articleBoardTitle;
		this.articleEditorNo = articleEditorNo;
	}

	public long getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(long articleNo) {
		this.articleNo = articleNo;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleBoardTitle() {
		return articleBoardTitle;
	}

	public void setArticleBoardTitle(String articleBoardTitle) {
		this.articleBoardTitle = articleBoardTitle;
	}

	public Integer getArticleClicks() {
		return articleClicks;
	}

	public void setArticleClicks(Integer articleClicks) {
		this.articleClicks = articleClicks;
	}

	public Integer getArticleLikes() {
		return articleLikes;
	}

	public void setArticleLikes(Integer articleLikes) {
		this.articleLikes = articleLikes;
	}

	public long getArticleEditorNo() {
		return articleEditorNo;
	}

	public void setArticleEditorNo(long articleEditorNo) {
		this.articleEditorNo = articleEditorNo;
	}

	public Timestamp getArticleCreatedAt() {
		return articleCreatedAt;
	}

	public void setArticleCreatedAt(Timestamp articleCreatedAt) {
		this.articleCreatedAt = articleCreatedAt;
	}

	public Timestamp getArticleModifiedAt() {
		return articleModifiedAt;
	}

	public void setArticleModifiedAt(Timestamp articleModifiedAt) {
		this.articleModifiedAt = articleModifiedAt;
	}
	
	
}
