package com.it.wecodeyou.interest_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.wecodeyou.interest_list.service.IInterest_ListService;

@Controller
@RequestMapping("/interest_list")
public class Interest_ListController {
	
	@Autowired
	private IInterest_ListService service;
	
	// interest 설문조사 페이지 열기
	@GetMapping("/interest")
	public String interest(Model model) {
		//가상의 회원번호 부여(test용)
		int userNo = 123;
		model.addAttribute("userNo", userNo);
		return "interest/interest-form";
	}
}
