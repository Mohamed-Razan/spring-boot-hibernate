package com.razan.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.razan.demo.entity.LeaveRequest;
import com.razan.demo.entity.Student;
import com.razan.demo.exception.FileStorageException;
import com.razan.demo.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {
	
	@Autowired
	private LeaveRequestRepository repository;
	
	@Autowired
	private StudentService stdSrvc;
	
	public LeaveRequest submitLeaveRequest(String sid, String leaveType, String purpose, Date from, Date to, int localWeeks, int localDays,
			int overseasWeeks, int overseasDays, int totalWeeks, int totalDays, int semesterWeeks, int semesterDays,
			int vacationWeeks, int vacationDays, String reason, MultipartFile annex) {
		
		String fileName = StringUtils.cleanPath(annex.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            
            File convertFile = new File("E:\\Spring Boot\\spring-boot-hibernate\\src\\main\\resources\\static\\Upload Annex\\"+annex.getOriginalFilename());
    		convertFile.createNewFile();
    		FileOutputStream fout = new FileOutputStream(convertFile);
    		fout.write(annex.getBytes());
    		fout.close();
    		
    		String filePath = "E:\\Spring Boot\\spring-boot-hibernate\\src\\main\\resources\\static\\Upload Annex\\"+annex.getOriginalFilename();
    		
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    		Date enteredDate = new Date();
    		
    		LeaveRequest req = new LeaveRequest(filePath, "", enteredDate, false, leaveType, purpose, from, to, localWeeks, localDays,
    				overseasWeeks, overseasDays, totalWeeks, totalDays, semesterWeeks, semesterDays,
    				vacationWeeks, vacationDays, reason, stdSrvc.getStudent(sid));
    		return repository.save(req);
    		
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	
	public LeaveRequest getRequest(int rid) {
		return repository.findById(rid).orElse(null);
	}
}

