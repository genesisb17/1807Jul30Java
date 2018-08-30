package com.iantimothyjohnson.notes.week5.hellohibernate.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "honeypots")
public class Honey {
	@Id
	@Column
	@SequenceGenerator(name = "seq_honeypot_id", sequenceName = "seq_honeypot_id")
	@GeneratedValue(generator = "seq_honeypot_id", strategy = GenerationType.SEQUENCE)
	private int id;
	// We actually don't need @Column here.
	private double amount;
	private String flavor;

	public Honey() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Honey other = (Honey) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount)) {
			return false;
		}
		if (flavor == null) {
			if (other.flavor != null) {
				return false;
			}
		} else if (!flavor.equals(other.flavor)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Honey [id=" + id + ", amount=" + amount + ", flavor=" + flavor + "]";
	}
}
