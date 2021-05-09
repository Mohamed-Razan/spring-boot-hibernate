package com.razan.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Module1 {
	
	@Id
	private String mcode;
	private String mtitle;
	private String dep;
	private int credit;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns = @JoinColumn,
			inverseJoinColumns = @JoinColumn
	)
	private List<Student> students;
	
	@OneToMany(mappedBy = "module")
	private List<ModuleDiscontinue> moduleDiscontinue;

	public Module1(String mcode, String mtitle, String dep, int credit) {
		super();
		this.mcode = mcode;
		this.mtitle = mtitle;
		this.dep = dep;
		this.credit = credit;
	}

	public Module1() {
		super();
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	
}
