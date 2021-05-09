package com.razan.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.razan.demo.entity.LeaveRequest;
import com.razan.demo.entity.Student;
import com.razan.demo.service.LeaveRequestService;

@RestController
public class LeaveRequestController {

	@Autowired
	private LeaveRequestService service;
	
	@PostMapping("/request/leaverequest")
	public LeaveRequest submitLeaveRequest(@RequestParam String sid, @RequestParam String leaveType, @RequestParam String on, @RequestParam Date from, @RequestParam Date to, 
			@RequestParam int localWeeks, @RequestParam int localDays, @RequestParam int overseasWeeks, @RequestParam int overseasDays, 
			@RequestParam int totalWeeks, @RequestParam int totalDays, @RequestParam int semesterWeeks, @RequestParam int semesterDays,
			@RequestParam int vacationWeeks, @RequestParam int vacationDays, @RequestParam String reason, @RequestParam MultipartFile annex) {
		return service.submitLeaveRequest(sid, leaveType, on, from, to, localWeeks, localDays,
				 overseasWeeks, overseasDays, totalWeeks, totalDays, semesterWeeks, semesterDays,
				 vacationWeeks, vacationDays, reason, annex);
	}
	
	@GetMapping("/pastrequest/{rid}")
	public LeaveRequest pastRequest(@PathVariable int rid) {
		return service.getRequest(rid);
	}
}

