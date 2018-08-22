package com.ex.pojo;

public class Genre 
{
	private int id;
	private String name;
	
	public Genre() {}
	
	public Genre(String name, int id)
	{
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
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
	
}
