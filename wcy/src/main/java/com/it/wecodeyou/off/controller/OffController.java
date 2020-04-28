package com.it.wecodeyou.off.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.it.wecodeyou.member.model.MemberVO;
import com.it.wecodeyou.off.model.SeatVO;
import com.it.wecodeyou.off.service.ISeatService;
import com.it.wecodeyou.product.model.ProductVO;
import com.it.wecodeyou.product.service.IProductService;

@RestController
@RequestMapping("/off")
public class OffController {
   
   @Autowired
   private ISeatService service;

   @Autowired
   IProductService productService;
   
   //강의실 체크 페이지 요청
   @GetMapping("/seat_main")
   public ModelAndView selectSeat(ModelAndView mv) {
      
      mv.setViewName("off/seat_main");
      return mv;
      
   }
   //강의실 페이지 요청
   @GetMapping("/seat")
   public ModelAndView viewSeat(ModelAndView mv, HttpServletRequest req) {
      
      mv.setViewName("off/seat");
      mv.addObject("seat", req.getParameter("seat"));
      return mv;
      
   }
   
   @PostMapping(value="/register")
      public ModelAndView register(HttpServletRequest request, ModelAndView mv) {
         System.out.println("/register param received");
         ProductVO pvo = new ProductVO();
         pvo.setProductName(request.getParameter("productName"));
         pvo.setProductPrice(Integer.valueOf(request.getParameter("productPrice")));
         pvo.setProductType(request.getParameter("productType"));
         pvo.setProductThumb(request.getParameter("productThumb"));
         pvo.setProductDetail(request.getParameter("productDetail"));
         productService.register(pvo);
         
         
         mv.setViewName("/product");
         return mv;
      }
   
   
   @GetMapping("/test")
   public ModelAndView test(ModelAndView mv, HttpServletRequest req) {
      if(req.getParameter("seat") != null) {
         service.bookedList2(Integer.parseInt(req.getParameter("seat")));
      }
      mv.setViewName("off/test");
      mv.addObject("data",req.getParameter("seat"));
      
      return mv;
      
   }
   
   @PostMapping("/chooseSeat")
   public ModelAndView chooseSeat(SeatVO sv, ModelAndView mv, HttpServletRequest req, HttpSession session) {
      // 좌석 value가 넘어옴 ex) 12 => 첫번째줄 두번째 자리
      req.getParameter("Chk_name");      
      sv.setSeatUserNo(((MemberVO)session.getAttribute("login")).getUserNo());
      sv.setSeatOffNo(Integer.parseInt(req.getParameter("off")));
      sv.setSeatIndex(Integer.parseInt(req.getParameter("Chk_name")));
      service.insertSeat2(sv);
      mv.setViewName("off/result");
      
      return mv;
   }
   
   @PostMapping("/selectChecked")
   public Map<String, ArrayList<Integer>> bookedList(@RequestBody Integer seat_off_no) {
      
      Map<String, ArrayList<Integer>> retVal = new HashMap<String, ArrayList<Integer>>();
      ArrayList<Integer> booked_list = service.bookedList(seat_off_no);
      retVal.put("list", service.bookedList(seat_off_no)); //list란 키로 bookedList의 값을 넣어줍니다.

      if(booked_list==null) {
         System.out.println("비어있음");
      }else {
         System.out.println("정보있음" );   
      }
      return retVal;  
           
   }
   
   
   
}