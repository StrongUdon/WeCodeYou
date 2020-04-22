package com.it.wecodeyou.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.article.model.ArticleVO;
import com.it.wecodeyou.article.repository.IArticleMapper;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	private IArticleMapper dao;
	
	@Override
	public void insert(ArticleVO avo) {
		dao.insert(avo);
		
	}

	@Override
	public void update(ArticleVO avo) {
		dao.update(avo);
		
	}

	@Override
	public void delete(ArticleVO avo) {
		dao.delete(avo);
		
	}

	@Override
	public List<ArticleVO> list(long boardNo) {
		return dao.list(boardNo);
	}


}
