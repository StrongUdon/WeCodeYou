package com.it.wecodeyou.point_purchase.controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.wecodeyou.member.repository.IMemberMapper;
import com.it.wecodeyou.point_purchase.model.Point_PurchaseVO;
import com.it.wecodeyou.point_purchase.repository.IPoint_PurchaseMapper;

@Controller
@RequestMapping("/pay")
public class Point_PurchaseController {

	
	@Autowired
	IMemberMapper mdao;
	@Autowired
	IPoint_PurchaseMapper pdao;
	
	@GetMapping("/pay")
	public String pay(Model model) throws SQLException {
		
		
		
		
		return "pay/paymain";
	}
	@GetMapping("/")
	public String login(Model model, HttpServletRequest request) throws SQLException {
		
		
		
		request.getSession().setAttribute("login", mdao.getOneInfo(1));
		
		
		
		return "point_purchase/point_purchase-main";
	}
	
	@PostMapping("/gopay")
	public String gopay(Model model, HttpServletRequest request) throws SQLException {
		
		
		int point = Integer.parseInt(request.getParameter("point"));
		model.addAttribute("point",point);
		model.addAttribute("amount",point);
		
		
		
		
		return "point_purchase/inicis";
	}
	

	@PostMapping("/paying")
	public void paying(Model model, HttpServletRequest req) throws SQLException {
		
		String id = req.getParameter("imp_uid");
		Integer amount = Integer.parseInt(req.getParameter("amount"));
		Integer user_no = Integer.parseInt(req.getParameter("user_no"));	
		Point_PurchaseVO pvo = new Point_PurchaseVO(0,user_no,id,new Timestamp(0),amount);

		
		pdao.insertPointPurchase(pvo);
		pdao.addPoint(pvo);
		
		req.getSession().setAttribute("recent",pdao.getOneRecent(user_no));
				
	}
	
	@GetMapping("/paycomplete")
	public String paycomplete(Model model, HttpServletRequest req) throws SQLException {
		

		
		return "point_purchase/result";
	}
	
	@GetMapping("/fail")
	public String payfail(Model model) throws SQLException {
		
		
		System.out.println("결제 실패");
		
		return "point_purchase/point_purchase-main";
	}	
	
	
}
