package com.iantimothyjohnson.notes.week5.hellohibernate.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bears")
public class Bear {
	@Id
	@Column(name="b_id")
	@SequenceGenerator(name="seq_b_id", sequenceName="bear_seq")
	@GeneratedValue(generator="seq_b_id", strategy=GenerationType.SEQUENCE)
	private int bearId;
	@Column
	private String furColor;
	@Column
	private double height;
	@Column(nullable=false)
	private String breed;

	public Bear() {
	}

	public int getBearId() {
		return bearId;
	}

	public void setBearId(int bearId) {
		this.bearId = bearId;
	}

	public String getFurColor() {
		return furColor;
	}

	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bearId;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((furColor == null) ? 0 : furColor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Bear other = (Bear) obj;
		if (bearId != other.bearId) {
			return false;
		}
		if (breed == null) {
			if (other.breed != null) {
				return false;
			}
		} else if (!breed.equals(other.breed)) {
			return false;
		}
		if (furColor == null) {
			if (other.furColor != null) {
				return false;
			}
		} else if (!furColor.equals(other.furColor)) {
			return false;
		}
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bear [bearId=" + bearId + ", furColor=" + furColor + ", height=" + height + ", breed=" + breed + "]";
	}
}
