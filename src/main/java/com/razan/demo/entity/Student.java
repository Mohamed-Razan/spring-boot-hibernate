package com.razan.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Student {
	
	@Id
	private String sid;
	private String name;
	private String contact;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "std")
	private List<Request> requests;
	
	@ManyToMany(cascade =  CascadeType.ALL, mappedBy = "students")
	private List<Module1> modules;

	public Student(String sid, String name, String contact, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

	public Student() {
		super();
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	
}
