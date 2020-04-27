package com.it.wecodeyou.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.off.model.OffVO;
import com.it.wecodeyou.product.model.ProductVO;
import com.it.wecodeyou.product.service.IProductService;

@RestController
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	IProductService productService;
	
	@GetMapping(value="")
	public ModelAndView list(ModelAndView mv) {
		List<ProductVO> pList = productService.list();
		for(ProductVO pvo: pList) {
			System.out.println(pvo);
		}
		mv.addObject("productList", pList);
		mv.setViewName("/product/list");
		return mv;
	}
	
	@GetMapping(value="/register")
	public ModelAndView register(ModelAndView mv){
		mv.setViewName("/product/register");
		return mv;
	}
	@PostMapping(value="/register")
	public String register(@RequestBody ProductVO pvo) {
		System.out.println("POST /product/register \r" + pvo.toString());
		
		productService.register(pvo);
		if(pvo.equals(productService.getOneInfo(pvo.getProductNo()))) {
			return "product_success";
		} else {
			return "product_fail";
		}
	}

	
	
}
