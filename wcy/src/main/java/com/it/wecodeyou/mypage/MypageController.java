package com.it.wecodeyou.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.wecodeyou.member.service.IMemberService;
import com.it.wecodeyou.review.model.ReviewVO;
import com.it.wecodeyou.review.service.IReviewService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	private IMemberService mservice;
	@Autowired
	private IReviewService rservice;
	
	
	@GetMapping("/")
	public String mypageMain() {
		System.out.println("/mypage/ : GET 요청 발생!");
		
		return "/mypage/mypage-main";
	}
	
	@GetMapping("/leclist")
	public String lectureList(Model model, ReviewVO rvo) {
		System.out.println("/mypage/leclist : GET 요청 발생!");

		
		return "/mypage/mypage-lecList";
	}

}
