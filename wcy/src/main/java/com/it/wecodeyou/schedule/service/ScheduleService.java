package com.it.wecodeyou.schedule.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.wecodeyou.schedule.model.ScheduleVO;
import com.it.wecodeyou.schedule.repository.IScheduleMapper;

@Service
public class ScheduleService implements IScheduleService{

	@Autowired
	private IScheduleMapper dao;
	
	public ArrayList<ScheduleVO> getEvent() throws SQLException{
		
		return dao.getEvent();	
		
	}

	
	
}
