package com.ex.pojos;

public class Genre {
	private int id;
	private String name;
	
	public Genre() {}
	
	public Genre(String name) {
		super();
		this.name = name;
	}

	public Genre(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}
	
}
