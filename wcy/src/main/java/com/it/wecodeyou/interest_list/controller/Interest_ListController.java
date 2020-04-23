package com.it.wecodeyou.interest_list.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.interest_list.model.Interest_ListVO;
import com.it.wecodeyou.interest_list.service.IInterest_ListService;

@Controller
@RequestMapping("/interest_list")
public class Interest_ListController {

	@Autowired
	private IInterest_ListService service;

	/*
	 * // RestController 에서 viewResolver로 보낼땐 ModelAndView 사용
	 * 
	 * @GetMapping("/interest") public ModelAndView interest() { ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("interest/interest-form"); return mv; }
	 */

	// interest 설문조사 페이지 열기
	
	  @GetMapping("/interest")
	  public String interest(Model model) throws SQLException { 
		  //가상의 회원번호 부여(test용) 
		  int userNo = 123;
	  
		  ArrayList<Interest_ListVO>typeList = service.getOneInterestType();
		  ArrayList<Interest_ListVO>allInterest = service.getAllInterestList();
	  
		  model.addAttribute("typeList",typeList); 
		  model.addAttribute("allInterest",allInterest); 
		  model.addAttribute("userNo", userNo); 
		  return "interest/interest-form"; 
		  
	  }
	  
	  @PostMapping("/insertInterest")
	  public String insertInterest() throws SQLException {
		  
		  System.out.println("insertInterest()");
		  return "interest/interest-result";
	  }
	 
}
