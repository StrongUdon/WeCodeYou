package com.it.wecodeyou.interest_list.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.interest_list.model.Interest_ListVO;
import com.it.wecodeyou.interest_list.service.IInterest_ListService;

@RestController
@RequestMapping("/interest_list")
public class Interest_ListController {

	@Autowired
	private IInterest_ListService service;

	
	  // RestController 에서 viewResolver로 보낼땐 ModelAndView 사용
	  
		@GetMapping("")
		public ModelAndView interest() throws SQLException {
			ModelAndView mv = new ModelAndView();
			
			//가상의 회원번호 부여(test용) 
			int userNo = 15;
			 
			ArrayList<Interest_ListVO>typeList = service.getOneInterestType();
			ArrayList<Interest_ListVO>allInterest = service.getAllInterestList();
			  
			mv.setViewName("interest/interest-form");
			mv.addObject("typeList", typeList);
			mv.addObject("allInterest", allInterest);
			mv.addObject("userNo", userNo);
			
			return mv;
		}
	 

		/*
		 * // interest 설문조사 페이지 열기
		 * 
		 * @GetMapping("/interest") public String interest(ModelAndView mv, Model model)
		 * throws SQLException { //가상의 회원번호 부여(test용) int userNo = 15;
		 * 
		 * ArrayList<Interest_ListVO>typeList = service.getOneInterestType();
		 * ArrayList<Interest_ListVO>allInterest = service.getAllInterestList();
		 * 
		 * model.addAttribute("typeList",typeList);
		 * model.addAttribute("allInterest",allInterest); model.addAttribute("userNo",
		 * userNo); return "interest/interest-form";
		 * 
		 * }
		 */
	  
	 
}
