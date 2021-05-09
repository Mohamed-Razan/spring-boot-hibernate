package com.razan.demo.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.razan.demo.compositekey.ModuleDiscontinueKey;

@Entity
@Table
public class ModuleDiscontinue {

	@EmbeddedId
	private ModuleDiscontinueKey id;
	
	@ManyToOne
	@MapsId("mcode")
    @JoinColumn(name = "mcode")
	private Module1 module;
	
	@ManyToOne
	@MapsId("RId")
    @JoinColumn(name = "rid")
	private AlternativeModuleRequest alterModuleRequest;
	
	private String alterMcode;

	public ModuleDiscontinue(ModuleDiscontinueKey id, Module1 module, AlternativeModuleRequest alterModuleRequest,
			String alterMcode) {
		super();
		this.id = id;
		this.module = module;
		this.alterModuleRequest = alterModuleRequest;
		this.alterMcode = alterMcode;
	}

	public ModuleDiscontinue() {
		super();
	}

	public ModuleDiscontinueKey getId() {
		return id;
	}

	public void setId(ModuleDiscontinueKey id) {
		this.id = id;
	}

	public Module1 getModule() {
		return module;
	}

	public void setModule(Module1 module) {
		this.module = module;
	}

	public AlternativeModuleRequest getAlterModuleRequest() {
		return alterModuleRequest;
	}

	public void setAlterModuleRequest(AlternativeModuleRequest alterModuleRequest) {
		this.alterModuleRequest = alterModuleRequest;
	}

	public String getAlterMcode() {
		return alterMcode;
	}

	public void setAlterMcode(String alterMcode) {
		this.alterMcode = alterMcode;
	}

	
}
