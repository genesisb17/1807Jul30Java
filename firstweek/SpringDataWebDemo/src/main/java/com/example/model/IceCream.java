package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ICE_CREAM")
public class IceCream {
	
	@Id
	@Column(name="ICE_CREAM_FLAVOR")
	private String flavor;
	
	@Column(name="ICE_CREAM_DESCRIPTION")
	private String description;
	
	@Column(name="SERVED_WITH_HOT_FUDGE")
	private boolean servedWithoutFudge;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + (servedWithoutFudge ? 1231 : 1237);
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
		IceCream other = (IceCream) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (servedWithoutFudge != other.servedWithoutFudge)
			return false;
		return true;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isServedWithoutFudge() {
		return servedWithoutFudge;
	}

	public void setServedWithoutFudge(boolean servedWithoutFudge) {
		this.servedWithoutFudge = servedWithoutFudge;
	}

	
}
