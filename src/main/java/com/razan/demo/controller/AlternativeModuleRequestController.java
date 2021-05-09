package com.razan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.razan.demo.entity.AlternativeModuleRequest;
import com.razan.demo.service.AlternativeModuleRequestService;

@RestController
public class AlternativeModuleRequestController {

	@Autowired
	private AlternativeModuleRequestService service;
	
	@PostMapping("/request/alternativemodulerequest")
	public AlternativeModuleRequest submitAlternativeModuleRequest(String sid, MultipartFile annex, String mcodes[]) {
		return service.submitAlternativeModuleRequest(sid, annex, mcodes);
	}
}
