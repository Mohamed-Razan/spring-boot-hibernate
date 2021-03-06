package com.razan.demo.compositekey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ModuleDiscontinueKey implements Serializable {
	
	@Column(name = "rid")
	private String RId;
	
	@Column(name = "mcode")
	private String mcode;
	
	public ModuleDiscontinueKey(String rId, String mcode) {
		super();
		RId = rId;
		this.mcode = mcode;
	}

	public ModuleDiscontinueKey() {
		super();
	}

	public String getRId() {
		return RId;
	}

	public void setRId(String rId) {
		RId = rId;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RId == null) ? 0 : RId.hashCode());
		result = prime * result + ((mcode == null) ? 0 : mcode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleDiscontinueKey other = (ModuleDiscontinueKey) obj;
		if (RId == null) {
			if (other.RId != null)
				return false;
		} else if (!RId.equals(other.RId))
			return false;
		if (mcode == null) {
			if (other.mcode != null)
				return false;
		} else if (!mcode.equals(other.mcode))
			return false;
		return true;
	}
	
	
	
	
}
