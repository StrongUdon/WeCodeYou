package com.it.wecodeyou.schedule.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import com.it.wecodeyou.schedule.model.ScheduleVO;

public interface IScheduleMapper {

	
	public ArrayList<ScheduleVO> getEvent() throws SQLException;
	
	
}
