package com.it.wecodeyou.schedule.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.it.wecodeyou.schedule.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	ScheduleService dao;
	
	@GetMapping("/calendar")
	public String schedule(Model model) throws SQLException {
		
		model.addAttribute("el",dao.getEvent());
		
		
		
		return "schedule/calendar";
	}
}
