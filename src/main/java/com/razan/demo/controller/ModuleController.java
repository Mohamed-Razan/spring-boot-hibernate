package com.razan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.razan.demo.entity.Module1;
import com.razan.demo.service.ModuleService;

@RestController
public class ModuleController {
	@Autowired
	private ModuleService service;
	
	@PostMapping("/addmodule")
	public Module1 addModule(@RequestBody Module1 module) {
		return service.postModule(module);
	}
}
