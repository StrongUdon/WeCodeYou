package com.it.wecodeyou.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.product.model.ProductVO;
import com.it.wecodeyou.product.repository.IProductMapper;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	IProductMapper pdao;
	
	@Override
	public void register(ProductVO pvo) {
		pdao.insertProduct(pvo);

	}

	@Override
	public void update(ProductVO pvo) {
		pdao.updateProduct(pvo);
	}

	@Override
	public void remove(Long productNo) {
			pdao.deleteProduct(productNo);
	}

	@Override
	public List<ProductVO> list() {
		
		return pdao.list();
	}

	@Override
	public ProductVO getOneInfo(Long productNo) {
		return pdao.getOneInfo(productNo);
	}

}
