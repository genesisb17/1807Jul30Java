package com.iantimothyjohnson.notes.week7.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IceCream {
	@Id
	private String flavor;
	private String description;
	private boolean servedWithHotFudge;

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

	public boolean isServedWithHotFudge() {
		return servedWithHotFudge;
	}

	public void setServedWithHotFudge(boolean servedWithHotFudge) {
		this.servedWithHotFudge = servedWithHotFudge;
	}
}
