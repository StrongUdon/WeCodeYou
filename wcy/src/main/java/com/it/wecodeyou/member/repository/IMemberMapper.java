package com.it.wecodeyou.member.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.it.wecodeyou.member.model.MemberVO;

public interface IMemberMapper {
   
   // 회원가입
   public void insertMember(MemberVO mvo);
   
   // 정보 수정 (userNo 받아서 생일, 휴대폰번호, 프로필 이미지, 주소 수정)
   public void changeInfo(Integer userNo, Date userBirthday, String userTel, String userProfileImg, String userAddress);
   
   // 비밀번호 변경
   public void changePw(MemberVO mvo);
   
   // 회원탈퇴
   public void deleteMember(Integer userNo);

   // 한 사람 정보 전체 출력 (마이페이지)
   public MemberVO getOneInfo(Integer userNo) throws SQLException;
   
   // 로그인을 위한 정보출력 (로그인)
   public MemberVO checkLogin(String userEmail);
   
   // 회원 전체 정보 출력 (관리자페이지)
   public ArrayList<MemberVO> getAllInfo() throws SQLException ;
   
   // 이메일 찾기
   public MemberVO findEmail(MemberVO mvo);
   
   // 이메일 중복체크
   Integer checkEmail(String userEmail);
   
   // 전화번호 중복체크
   Integer checkTel(String userTel);

}