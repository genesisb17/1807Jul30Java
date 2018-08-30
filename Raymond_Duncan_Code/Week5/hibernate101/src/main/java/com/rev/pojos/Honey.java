package com.rev.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HONEYPOTS")
public class Honey {

	
	@Id
	@Column
	@SequenceGenerator(name="HP_ID_SEQ", sequenceName="HP_ID_SEQ")
	@GeneratedValue(generator="HP_ID_SEQ", strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private double volume;
	
	@Column
	private String honeyType;
	
	public Honey() {}

	public Honey(int id, double volume, String honeyType) {
		super();
		this.id = id;
		this.volume = volume;
		this.honeyType = honeyType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String getHoneyType() {
		return honeyType;
	}

	public void setHoneyType(String honeyType) {
		this.honeyType = honeyType;
	}

	@Override
	public String toString() {
		return "Honey [id=" + id + ", volume=" + volume + ", honeyType=" + honeyType + "]";
	}
	
}
