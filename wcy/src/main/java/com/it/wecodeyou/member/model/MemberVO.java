package com.it.wecodeyou.member.model;


import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MemberVO {

   private Integer userNo;
   private String userEmail;
   private String userPw;
   private String userName;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   private Date userBirthday;
   private String userTel;
   private String userProfileImg;
   private Timestamp userCreatedAt;
   private Timestamp userModifiedAt;
   private Timestamp userLoginAt;
   private String userZipcode;   
   private String userAddress;
   private String userDetailAddress;
   private Integer userType;
   private Integer userPoint;
   private Boolean userInterest;
   
   public MemberVO() {}

   public MemberVO(Integer userNo, String userEmail, String userPw, String userName, Date userBirthday, String userTel,
         String userProfileImg, Timestamp userCreatedAt, Timestamp userModifiedAt, Timestamp userLoginAt,
         String userZipcode, String userAddress, String userDetailAddress, Integer userType, Integer userPoint,
         Boolean userInterest) {
      super();
      this.userNo = userNo;
      this.userEmail = userEmail;
      this.userPw = userPw;
      this.userName = userName;
      this.userBirthday = userBirthday;
      this.userTel = userTel;
      this.userProfileImg = userProfileImg;
      this.userCreatedAt = userCreatedAt;
      this.userModifiedAt = userModifiedAt;
      this.userLoginAt = userLoginAt;
      this.userZipcode = userZipcode;
      this.userAddress = userAddress;
      this.userDetailAddress = userDetailAddress;
      this.userType = userType;
      this.userPoint = userPoint;
      this.userInterest = userInterest;
   }

   public Integer getUserNo() {
      return userNo;
   }

   public void setUserNo(Integer userNo) {
      this.userNo = userNo;
   }

   public String getUserEmail() {
      return userEmail;
   }

   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }

   public String getUserPw() {
      return userPw;
   }

   public void setUserPw(String userPw) {
      this.userPw = userPw;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public Date getUserBirthday() {
      return userBirthday;
   }

   public void setUserBirthday(Date userBirthday) {
      this.userBirthday = userBirthday;
   }

   public String getUserTel() {
      return userTel;
   }

   public void setUserTel(String userTel) {
      this.userTel = userTel;
   }

   public String getUserProfileImg() {
      return userProfileImg;
   }

   public void setUserProfileImg(String userProfileImg) {
      this.userProfileImg = userProfileImg;
   }

   public Timestamp getUserCreatedAt() {
      return userCreatedAt;
   }

   public void setUserCreatedAt(Timestamp userCreatedAt) {
      this.userCreatedAt = userCreatedAt;
   }

   public Timestamp getUserModifiedAt() {
      return userModifiedAt;
   }

   public void setUserModifiedAt(Timestamp userModifiedAt) {
      this.userModifiedAt = userModifiedAt;
   }

   public Timestamp getUserLoginAt() {
      return userLoginAt;
   }

   public void setUserLoginAt(Timestamp userLoginAt) {
      this.userLoginAt = userLoginAt;
   }

   public String getUserZipcode() {
      return userZipcode;
   }

   public void setUserZipcode(String userZipcode) {
      this.userZipcode = userZipcode;
   }

   public String getUserAddress() {
      return userAddress;
   }

   public void setUserAddress(String userAddress) {
      this.userAddress = userAddress;
   }

   public String getUserDetailAddress() {
      return userDetailAddress;
   }

   public void setUserDetailAddress(String userDetailAddress) {
      this.userDetailAddress = userDetailAddress;
   }

   public Integer getUserType() {
      return userType;
   }

   public void setUserType(Integer userType) {
      this.userType = userType;
   }

   public Integer getUserPoint() {
      return userPoint;
   }

   public void setUserPoint(Integer userPoint) {
      this.userPoint = userPoint;
   }

   public Boolean getUserInterest() {
      return userInterest;
   }

   public void setUserInterest(Boolean userInterest) {
      this.userInterest = userInterest;
   }

   @Override
   public String toString() {
      return "MemberVO [userNo=" + userNo + ", userEmail=" + userEmail + ", userPw=" + userPw + ", userName="
            + userName + ", userBirthday=" + userBirthday + ", userTel=" + userTel + ", userProfileImg="
            + userProfileImg + ", userCreatedAt=" + userCreatedAt + ", userModifiedAt=" + userModifiedAt
            + ", userLoginAt=" + userLoginAt + ", userZipcode=" + userZipcode + ", userAddress=" + userAddress
            + ", userDetailAddress=" + userDetailAddress + ", userType=" + userType + ", userPoint=" + userPoint
            + ", userInterest=" + userInterest + "]";
   }
   
   
   
   

}


