package com.it.wecodeyou.tag.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.tag.model.TagVO;
import com.it.wecodeyou.tag.repository.ITagMapper;

@Service
public class TagService implements ITagService{

	@Autowired
	ITagMapper dao;
	
	@Override
	public ArrayList<TagVO> getAllTag()  throws SQLException {
		return dao.getAllTag();
	}

	@Override
	public Integer checkTag(String tagName)  throws SQLException {
		return dao.checkTag(tagName);
	}
	
	@Override
	public ArrayList<TagVO> checkTagDetail(String q) throws SQLException {
		// TODO Auto-generated method stub
		return dao.checkTagDetail(q);
	}

	@Override
	public void insertTag(TagVO tvo)  throws SQLException {
		dao.insertTag(tvo);
	}



}
