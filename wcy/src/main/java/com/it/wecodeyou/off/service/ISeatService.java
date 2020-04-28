package com.it.wecodeyou.off.service;

import java.util.ArrayList;

import com.it.wecodeyou.off.model.SeatVO;

public interface ISeatService {

   // 오프라인 강의 결제 시 자리를 정하는것 -> insert
   public void insertSeat2(SeatVO sv);
   
   // off_no와 user_no를 받아서 seat_no를 검색하여 수정
   public void updateSeat(ArrayList<Integer> al);   
   
   // 오프라인 구매 취소 (환불) -> delete 이거 문제 
   // off_no와 user_no를 받아서 seat_no를 검색하여 삭제
   public void deleteSeat(ArrayList<Integer> al);
   
   // 해당 강의의 현재 예매 정보 확인 (강의 번호를 입력해서 리스트로 SeatVO를 받고 seatIndex 사용)
   public ArrayList<Integer> bookedList(Integer seat_off_no);
   public ArrayList<Integer> bookedList2(Integer seat_off_no);
   
   // 마이페이지 들어가서 내가 해당 과목에 무슨 자리인지 확인하는것
   // off_no와 user_no를 받아서 seat_no를 검색
   public SeatVO mySeat(ArrayList<Integer> al);
   
   
}