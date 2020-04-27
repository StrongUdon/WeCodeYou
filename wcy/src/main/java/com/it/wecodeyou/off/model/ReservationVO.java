package com.it.wecodeyou.off.model;

public class ReservationVO {
	private long reservationNo;
	private long reservationScheduleNo;
	private String reservationRow;
	private String reservationCol;
	private long reservationOffNo;
	private long reservationUserNo;
	public ReservationVO(long reservationNo, long reservationScheduleNo, String reservationRow, String reservationCol,
			long reservationOffNo, long reservationUserNo) {
		super();
		this.reservationNo = reservationNo;
		this.reservationScheduleNo = reservationScheduleNo;
		this.reservationRow = reservationRow;
		this.reservationCol = reservationCol;
		this.reservationOffNo = reservationOffNo;
		this.reservationUserNo = reservationUserNo;
	}
	public ReservationVO(long reservationScheduleNo, String reservationRow, String reservationCol,
			long reservationOffNo, long reservationUserNo) {
		super();
		this.reservationScheduleNo = reservationScheduleNo;
		this.reservationRow = reservationRow;
		this.reservationCol = reservationCol;
		this.reservationOffNo = reservationOffNo;
		this.reservationUserNo = reservationUserNo;
	}
	public long getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(long reservationNo) {
		this.reservationNo = reservationNo;
	}
	public long getReservationScheduleNo() {
		return reservationScheduleNo;
	}
	public void setReservationScheduleNo(long reservationScheduleNo) {
		this.reservationScheduleNo = reservationScheduleNo;
	}
	public String getReservationRow() {
		return reservationRow;
	}
	public void setReservationRow(String reservationRow) {
		this.reservationRow = reservationRow;
	}
	public String getReservationCol() {
		return reservationCol;
	}
	public void setReservationCol(String reservationCol) {
		this.reservationCol = reservationCol;
	}
	public long getReservationOffNo() {
		return reservationOffNo;
	}
	public void setReservationOffNo(long reservationOffNo) {
		this.reservationOffNo = reservationOffNo;
	}
	public long getReservationUserNo() {
		return reservationUserNo;
	}
	public void setReservationUserNo(long reservationUserNo) {
		this.reservationUserNo = reservationUserNo;
	}
	@Override
	public String toString() {
		return "ReservationVO [reservationNo=" + reservationNo + ", reservationScheduleNo=" + reservationScheduleNo
				+ ", reservationRow=" + reservationRow + ", reservationCol=" + reservationCol + ", reservationOffNo="
				+ reservationOffNo + ", reservationUserNo=" + reservationUserNo + "]";
	}
	
	
}
