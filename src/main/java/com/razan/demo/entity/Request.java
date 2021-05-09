package com.razan.demo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.experimental.SuperBuilder;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public class Request {
	
	@Id
	@GeneratedValue
	private int RId;
	private String annexPath;
	private String decision;
	private Date enteredDate = new Date();
	private boolean isSendToFacBoard;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="sid", referencedColumnName = "sid")
	private Student std;
	
	public Request(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard, Student std) {
		super();
		this.annexPath = annexPath;
		this.decision = decision;
		this.enteredDate = enteredDate;
		this.isSendToFacBoard = isSendToFacBoard;
		this.std = std;
	}

	public Request() {
		super();
	}

	public String getAnnexPath() {
		return annexPath;
	}

	public void setAnnexPath(String annexPath) {
		this.annexPath = annexPath;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public boolean isSendToFacBoard() {
		return isSendToFacBoard;
	}

	public void setSendToFacBoard(boolean isSendToFacBoard) {
		this.isSendToFacBoard = isSendToFacBoard;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}
	
	
	
}
