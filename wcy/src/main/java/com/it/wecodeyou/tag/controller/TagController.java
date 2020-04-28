package com.it.wecodeyou.tag.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.tag.model.TagVO;
import com.it.wecodeyou.tag.service.ITagService;

@RestController
@RequestMapping("/tag")
public class TagController {
	
	@Autowired
	private ITagService service;
	
	@GetMapping("")
	public ModelAndView interest() throws SQLException {
		ModelAndView mv = new ModelAndView();
		 
		ArrayList<TagVO>tagList = service.getAllTag();
		  
		mv.setViewName("tag/getAllTag");
		mv.addObject("tagList", tagList);
		
		return mv;
	}
	
	@ResponseBody
	 @PostMapping("/insertTag")
	 public String insertInterest(@RequestBody TagVO tvo, HttpSession session) throws SQLException {
			System.out.println("/tag/insertTag : 등록 POST 요청 발생!");
			System.out.println(tvo);
			String result = null;
			
			//중복검사
			Integer chk = service.checkTag(tvo.getTagName());
			if(chk == 0) { 
				service.insertTag(tvo); // insert tag 
				result = "success";
			}else if(chk == 1) { //이미 등록된 tag name라면
				result = "already exist";
			}
		 
		 return result;
	 }
	
	//@ResponseBody
	 @PostMapping("/checkTagDetail")
	 public Map<String, ArrayList<String>> checkTagDetail(@RequestBody String q) throws SQLException {
			System.out.println("/tag/checkTagDetail : 등록 POST 요청 발생!");
			System.out.println(q);
			
		 
			Map<String, ArrayList<String>> retVal = new HashMap<String, ArrayList<String>>();
		    ArrayList<String> tagList = new ArrayList<>();
		    for (int i = 0; i < service.checkTagDetail(q).size(); i++) {
				tagList.add(service.checkTagDetail(q).get(i).getTagName());
				System.out.println(tagList.get(i));
			}
		    
		     if(tagList.size() == 0) {
		         System.out.println("비어있음");
		         tagList.add("no result");
		         retVal.put("list", tagList);
		      }else {
		         System.out.println("정보있음" );
		         retVal.put("list", tagList); //list란 키로 tagList의 값을 넣어줍니다.
				 
		      }
			
		 return retVal;
	 }

}
