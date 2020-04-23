package com.it.wecodeyou.point_purchase.controller;

import java.sql.SQLException;

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
	@PostMapping("/")
	public String login(Model model, HttpServletRequest request) throws SQLException {
		
		
		
		request.getSession().setAttribute("login", mdao.getOneInfo(1));
		
		
		
		return "pay/paymain";
	}
	
	@PostMapping("/gopay")
	public String gopay(Model model, HttpServletRequest request) throws SQLException {
		
		
		int point = Integer.parseInt(request.getParameter("point"));
		model.addAttribute("amount",point);
		
		
		
		
		return "pay/pay";
	}
	

	@PostMapping("/paying")
	public String paying(Model model, HttpServletRequest req) throws SQLException {
		
		String id = req.getParameter("imp_uid");
		String gname = req.getParameter("gname");
		String bname = req.getParameter("bname");
		Integer amount = Integer.parseInt(req.getParameter("gname"));
		
//		Point_PurchaseVO pvo = 
		
//		pdao.insertPointPurchase(pvo);
		
		
		
		
		return "pay/paymain";  // ?
	}
	
	@GetMapping("/main")
	public String paycomplete(Model model) throws SQLException {
		

		
		
		return "pay/paycomplete";
	}
	
	@GetMapping("/fail")
	public String payfail(Model model) throws SQLException {
		
		
		System.out.println("결제 실패");
		
		return "point_purchase/point_purchase-main";
	}	
	
	
}
