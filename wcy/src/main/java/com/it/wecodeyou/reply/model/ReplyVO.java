package com.it.wecodeyou.reply.model;

import java.sql.Timestamp;


/*parent: 부모 댓글
depth: 댓글 순위
order: 같은 댓글을 가진 답글들의 순위*/
public class ReplyVO {
	private long replyNo;
	private String replyWriter;
	private String replyContent;
	private String replyTitle;
	private Timestamp replyCreatedAt;
	private Timestamp replyModifiedAt;
	private boolean replyIsRemoved;
	private Integer replyOrder;
	private long replyParent;
	private Integer replyDepth;
	private Integer replyLikes;
	private long replyArticleNo;
	
	public ReplyVO(long replyNo, String replyWriter, String replyContent, String replyTitle, Timestamp replyCreatedAt,
			Timestamp replyModifiedAt, boolean replyIsRemoved, Integer replyOrder, long replyParent, Integer replyDepth,
			Integer replyLikes, long replyArticleNo) {
		super();
		this.replyNo = replyNo;
		this.replyWriter = replyWriter;
		this.replyContent = replyContent;
		this.replyTitle = replyTitle;
		this.replyCreatedAt = replyCreatedAt;
		this.replyModifiedAt = replyModifiedAt;
		this.replyIsRemoved = replyIsRemoved;
		this.replyOrder = replyOrder;
		this.replyParent = replyParent;
		this.replyDepth = replyDepth;
		this.replyLikes = replyLikes;
		this.replyArticleNo = replyArticleNo;
	}

	public ReplyVO(String replyWriter, String replyContent, String replyTitle, Integer replyOrder, long replyParent,
			Integer replyDepth, long replyArticleNo) {
		super();
		this.replyWriter = replyWriter;
		this.replyContent = replyContent;
		this.replyTitle = replyTitle;
		this.replyOrder = replyOrder;
		this.replyParent = replyParent;
		this.replyDepth = replyDepth;
		this.replyArticleNo = replyArticleNo;
	}

	public long getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(long replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyTitle() {
		return replyTitle;
	}

	public void setReplyTitle(String replyTitle) {
		this.replyTitle = replyTitle;
	}

	public Timestamp getReplyCreatedAt() {
		return replyCreatedAt;
	}

	public void setReplyCreatedAt(Timestamp replyCreatedAt) {
		this.replyCreatedAt = replyCreatedAt;
	}

	public Timestamp getReplyModifiedAt() {
		return replyModifiedAt;
	}

	public void setReplyModifiedAt(Timestamp replyModifiedAt) {
		this.replyModifiedAt = replyModifiedAt;
	}

	public boolean isReplyIsRemoved() {
		return replyIsRemoved;
	}

	public void setReplyIsRemoved(boolean replyIsRemoved) {
		this.replyIsRemoved = replyIsRemoved;
	}

	public Integer getReplyOrder() {
		return replyOrder;
	}

	public void setReplyOrder(Integer replyOrder) {
		this.replyOrder = replyOrder;
	}

	public long getReplyParent() {
		return replyParent;
	}

	public void setReplyParent(long replyParent) {
		this.replyParent = replyParent;
	}

	public Integer getReplyDepth() {
		return replyDepth;
	}

	public void setReplyDepth(Integer replyDepth) {
		this.replyDepth = replyDepth;
	}

	public Integer getReplyLikes() {
		return replyLikes;
	}

	public void setReplyLikes(Integer replyLikes) {
		this.replyLikes = replyLikes;
	}

	public long getReplyArticleNo() {
		return replyArticleNo;
	}

	public void setReplyArticleNo(long replyArticleNo) {
		this.replyArticleNo = replyArticleNo;
	}
	
	
}
