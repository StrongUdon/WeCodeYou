package com.it.wecodeyou.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.member.model.MemberVO;
import com.it.wecodeyou.member.repository.IMemberMapper;

@Service
public class MemberService implements IMemberService {

   @Autowired
   private IMemberMapper dao;

   @Override
   public void insertMember(MemberVO mvo) {

      // 비밀번호 암호화 인코딩
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      System.out.println("암호화 전 패스워드:  " + mvo.getUserPw());

      // 패스워드를 암호화하여 mvo 객체에 저장하기
      String securePw = encoder.encode(mvo.getUserPw()); // 원래 패스워드를 암호화함
      mvo.setUserPw(securePw); // 암호화 한 패스워드를 user 객체 비밀번호에 set

      System.out.println("암호화 후 패스워드:  " + securePw);

      mvo.setUserPoint(500);
      mvo.setUserType(0);
      mvo.setUserInterest(false);

      dao.insertMember(mvo);
   }

   @Override
   public void changeInfo(Integer userNo, Date userBirthday, String userTel, String userProfileImg,
         String userAddress) {
      dao.changeInfo(userNo, userBirthday, userTel, userProfileImg, userAddress);
   }

   @Override
   public void changePw(MemberVO mvo) {

      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

      // 패스워드를 암호화하여 mvo 객체에 저장하기
      String securePw = encoder.encode(mvo.getUserPw()); // 원래 패스워드를 암호화함
      mvo.setUserPw(securePw); // 암호화 한 패스워드를 user 객체 비밀번호에 set

      dao.changePw(mvo);
   }

   @Override
   public void deleteMember(Integer userNo) {
      dao.deleteMember(userNo);
   }

   @Override
   public MemberVO findEmail(MemberVO mvo) {
      return dao.findEmail(mvo);
   }

   @Override
   public MemberVO getOneInfo(Integer userNo) throws SQLException {
      return dao.getOneInfo(userNo);
   }

   @Override
   public ArrayList<MemberVO> getAllInfo() throws SQLException {
      return dao.getAllInfo();
   }

   @Override
   public Integer checkEmail(String userEmail) {
      return dao.checkEmail(userEmail);
   }

   @Override
   public Integer checkTel(String userTel) {
      return dao.checkTel(userTel);
   }

   @Override
   public MemberVO checkLogin(String userEmail) {
      return dao.checkLogin(userEmail);
   }

}