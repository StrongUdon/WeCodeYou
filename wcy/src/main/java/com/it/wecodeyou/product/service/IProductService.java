package com.it.wecodeyou.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.it.wecodeyou.product.model.ProductVO;

@Service
public interface IProductService {
	
	public void register(ProductVO pvo);
	
	public void update(ProductVO pvo);
	
	public void remove(Long productNo);
	
	public List<ProductVO> list();
	
	public ProductVO getOneInfo(Long productNo);
}
