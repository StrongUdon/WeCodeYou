package com.it.wecodeyou.review.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.it.wecodeyou.review.model.ReviewVO;
import com.it.wecodeyou.review.service.IReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private IReviewService service;
	
	@PostMapping("/write")
	public String write(ReviewVO rvo, RedirectAttributes ra) {
		System.out.println("/review/write : POST 요청 발생!");
		
		service.insertReview(rvo);
		ra.addFlashAttribute("msg", "writeSuccess");
		
		return "redirect:/mypage/leclist";
	}

}
