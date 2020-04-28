package com.it.wecodeyou.off.model;

public class SeatVO {
   
   private Integer seatNo;
   private Integer seatOffNo;
   private Integer seatUserNo;   
   private Integer seatIndex;
   
   public SeatVO() {
      // TODO Auto-generated constructor stub
   }

   public SeatVO(Integer seatNo, Integer seatOffNo, Integer seatUserNo, Integer seatIndex) {
      super();
      this.seatNo = seatNo;
      this.seatOffNo = seatOffNo;
      this.seatUserNo = seatUserNo;
      this.seatIndex = seatIndex;
   }

   public Integer getSeatNo() {
      return seatNo;
   }

   public void setSeatNo(Integer seatNo) {
      this.seatNo = seatNo;
   }

   public Integer getSeatOffNo() {
      return seatOffNo;
   }

   public void setSeatOffNo(Integer seatOffNo) {
      this.seatOffNo = seatOffNo;
   }

   public Integer getSeatUserNo() {
      return seatUserNo;
   }

   public void setSeatUserNo(Integer seatUserNo) {
      this.seatUserNo = seatUserNo;
   }

   public Integer getSeatIndex() {
      return seatIndex;
   }

   public void setSeatIndex(Integer seatIndex) {
      this.seatIndex = seatIndex;
   }

   @Override
   public String toString() {
      return "SeatVO [seatNo=" + seatNo + ", seatOffNo=" + seatOffNo + ", seatUserNo=" + seatUserNo + ", seatIndex="
            + seatIndex + "]";
   }

   
   
   
}