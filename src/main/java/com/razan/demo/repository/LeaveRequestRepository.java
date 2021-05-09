package com.razan.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.razan.demo.entity.LeaveRequest;


public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
	
}

