package com.it.wecodeyou.article.service;

import java.util.List;

import com.it.wecodeyou.article.model.ArticleVO;

public interface IArticleService {

	
	public void insert(ArticleVO avo);
	
	public void update(ArticleVO avo);
	
	public void delete(ArticleVO avo);
	
	public List<ArticleVO> list(long boardNo);
}
