package com.razan.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.razan.demo.entity.Module1;
import com.razan.demo.repository.ModuleRepository;

@Service
public class ModuleService {
	@Autowired
	private ModuleRepository repo;
	
	public Module1 postModule(Module1 module) {
		return repo.save(module);
	}
	
	public Module1 getModuleById(String id) {
		return repo.findById(id).orElse(null);
	}
}
