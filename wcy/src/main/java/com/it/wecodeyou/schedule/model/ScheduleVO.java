package com.it.wecodeyou.schedule.model;

import java.sql.Timestamp;

public class ScheduleVO {

	private Integer scheduleNo;
	private Integer scheduleOffNo;
	private String scheduleBgColor;
	private String scheduleDetail;
	private Timestamp scheduleStartDate;
	private Timestamp scheduleEndDate;
	
	
	public ScheduleVO() {}
	
	public ScheduleVO(Integer scheduleNo, Integer scheduleOffNo, String scheduleBgColor, String scheduleDetail,
			Timestamp scheduleStartDate, Timestamp scheduleEndDate) {
		super();
		this.scheduleNo = scheduleNo;
		this.scheduleOffNo = scheduleOffNo;
		this.scheduleBgColor = scheduleBgColor;
		this.scheduleDetail = scheduleDetail;
		this.scheduleStartDate = scheduleStartDate;
		this.scheduleEndDate = scheduleEndDate;
	}
	public Integer getScheduleNo() {
		return scheduleNo;
	}
	public void setScheduleNo(Integer scheduleNo) {
		this.scheduleNo = scheduleNo;
	}
	public Integer getScheduleOffNo() {
		return scheduleOffNo;
	}
	public void setScheduleOffNo(Integer scheduleOffNo) {
		this.scheduleOffNo = scheduleOffNo;
	}
	public String getScheduleBgColor() {
		return scheduleBgColor;
	}
	public void setScheduleBgColor(String scheduleBgColor) {
		this.scheduleBgColor = scheduleBgColor;
	}
	public String getScheduleDetail() {
		return scheduleDetail;
	}
	public void setScheduleDetail(String scheduleDetail) {
		this.scheduleDetail = scheduleDetail;
	}
	public Timestamp getScheduleStartDate() {
		return scheduleStartDate;
	}
	public void setScheduleStartDate(Timestamp scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}
	public Timestamp getScheduleEndDate() {
		return scheduleEndDate;
	}
	public void setScheduleEndDate(Timestamp scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}
	
	
	
}
