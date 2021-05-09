package com.razan.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.razan.demo.entity.AlternativeModuleRequest;
import com.razan.demo.entity.LeaveRequest;
import com.razan.demo.entity.Module1;
import com.razan.demo.exception.FileStorageException;
import com.razan.demo.repository.AlternativeModuleRequestRepository;

@Service
public class AlternativeModuleRequestService {
	
	@Autowired
	private AlternativeModuleRequestRepository repository;
	
	@Autowired
	private StudentService stdService;
	
	@Autowired
	private ModuleService moduleService;
	
	public AlternativeModuleRequest submitAlternativeModuleRequest(String sid, MultipartFile annex, String mcodes[]) {
		
		String fileName = StringUtils.cleanPath(annex.getOriginalFilename());
		
		List<Module1> modules = new ArrayList<>(); 

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
    		
    		for(int i = 0; i < mcodes.length; i++) {
    			modules.add(moduleService.getModuleById(mcodes[i]));
    		}
    		
    		
    		AlternativeModuleRequest req = new AlternativeModuleRequest(filePath, "", enteredDate, false, stdService.getStudent(sid), "");
    		return repository.save(req);
    		
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
	}
	
	
	public AlternativeModuleRequest getRequest(int rid) {
		return repository.findById(rid).orElse(null);
	}
}
