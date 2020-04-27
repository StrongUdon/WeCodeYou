package com.it.wecodeyou.product.repository;

import java.util.List;

import com.it.wecodeyou.product.model.ProductVO;

public interface IProductMapper {

	public void insertProduct(ProductVO pvo);
	
	public void updateProduct(ProductVO pvo);
	
	public void deleteProduct(Long productNo);
	
	public List<ProductVO> list();
	
	public ProductVO getOneInfo(Long productNo);
}
