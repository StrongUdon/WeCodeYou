package com.it.wecodeyou.reply.service;

import com.it.wecodeyou.article.model.ArticleVO;
import com.it.wecodeyou.member.model.MemberVO;
import com.it.wecodeyou.reply.model.ReplyVO;

public interface IReplyService {

	//댓글 삽입문
	public void insert(ReplyVO rvo);
	
	//댓글을 DB에서 삭제하지는 않고 is_removed를 true로만 바꿈
	public void remove(ReplyVO rvo);
	
	//댓글 삭제
	public void delete(ReplyVO rvo);
	
	//댓글 수정
	public void update(ReplyVO rvo);
	
	//한 게시물의 댓글 목록 출력
	public void listByArticle(ArticleVO bvo);
	
	public void listByMember(MemberVO mvo);
}
