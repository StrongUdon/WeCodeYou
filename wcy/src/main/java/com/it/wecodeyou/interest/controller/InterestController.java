package com.it.wecodeyou.interest.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.it.wecodeyou.interest.model.InterestVO;
import com.it.wecodeyou.interest.sevice.IInterestService;
import com.it.wecodeyou.member.service.IMemberService;


@RestController
@RequestMapping("/interest")
public class InterestController {
	
	@Autowired
	private IInterestService service;
	
	@Autowired
	private IMemberService mService;
	
	@ResponseBody
	 @PostMapping("/insertInterest")
	 public String insertInterest(@RequestBody InterestVO ivo, HttpSession session) throws SQLException {
			System.out.println("/interest/insertInterest : 등록 POST 요청 발생!");
			System.out.println(ivo);
			String result = null;
			
			//중복검사
			Integer chk = service.checkUserNo(ivo.getInterestUserNo());
			if(chk == 0) { 
				service.insertInterest(ivo); // insert interest 
				//mService.changeInterest(ivo.getInterestUserNo(), 1); // change user_interest true
				result = "success";
			}else if(chk == 1) { //이미 등록된 user no라면
				result = "already exist";
			}
		 
		 return result;
	 }
}
