package com.it.wecodeyou.off.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.off.model.SeatVO;
import com.it.wecodeyou.off.repository.ISeatMapper;
import com.it.wecodeyou.review.model.ReviewVO;
import com.it.wecodeyou.review.repository.IReviewMapper;

@Service
public class SeatService implements ISeatService{

   @Autowired
   private ISeatMapper dao;
   
   @Override
   public void insertSeat2(SeatVO sv) {
      dao.insertSeat2(sv);
   }

   @Override
   public void updateSeat(ArrayList<Integer> al) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void deleteSeat(ArrayList<Integer> al) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public ArrayList<Integer> bookedList(Integer seat_off_no) {
      ArrayList<Integer> al = new ArrayList<>();
      ArrayList<SeatVO> seat_list = dao.bookedList(seat_off_no);
      
      /*
       * for (int i = 0; i < seat_list.size(); i++) {
       * al.add(seat_list.get(i).getSeatIndex());
       * System.out.println("service에서 찍음: "+seat_list.get(i)); }
       */
      return al;
   }
   @Override
   public ArrayList<Integer> bookedList2(Integer seat_off_no) {
      ArrayList<Integer> al = new ArrayList<>();
      ArrayList<SeatVO> seat_list = dao.bookedList(seat_off_no);
      
      for (int i = 0; i < seat_list.size(); i++) {
         al.add(seat_list.get(i).getSeatIndex());
         System.out.println("service에서 찍음: "+seat_list.get(i));
      }
      return al;
   }

   @Override
   public SeatVO mySeat(ArrayList<Integer> al) {
      // TODO Auto-generated method stub
      return null;
   }


}