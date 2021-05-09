package com.razan.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Table
@PrimaryKeyJoinColumn
@SuperBuilder
public class AlternativeModuleRequest extends Request {
	
	private String offeringSem;
	
	@OneToMany(mappedBy = "alterModuleRequest")
	private List<ModuleDiscontinue> moduleDiscontinue;

	public AlternativeModuleRequest(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard,									
			Student std, String offeringSem) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std);
		this.offeringSem = offeringSem;
	}

	public AlternativeModuleRequest(String annexPath, String decision, Date enteredDate, boolean isSendToFacBoard,
			Student std) {
		super(annexPath, decision, enteredDate, isSendToFacBoard, std);
	}

	public String getOfferingSem() {
		return offeringSem;
	}

	public void setOfferingSem(String offeringSem) {
		this.offeringSem = offeringSem;
	}
	
}
