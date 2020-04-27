package com.it.wecodeyou.off.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.product.model.ProductVO;
import com.it.wecodeyou.product.service.IProductService;


@Controller
@RequestMapping(value="/off")
public class OffController {
	
	/*
	 * @Autowired IOffService offService;
	 */
	@Autowired
	IProductService productService;
	@PostMapping(value="/register")
	public ModelAndView register(HttpServletRequest request, ModelAndView mv) {
		System.out.println("/register param received");
		ProductVO pvo = new ProductVO();
		pvo.setProductName(request.getParameter("productName"));
		pvo.setProductPrice(Integer.valueOf(request.getParameter("productPrice")));
		pvo.setProductType(request.getParameter("productType"));
		pvo.setProductThumb(request.getParameter("productThumb"));
		pvo.setProductDetail(request.getParameter("productDetail"));
		productService.register(pvo);
		
		
		mv.setViewName("/product");
		return mv;
	}
}
