package com.rev.pojos;

public class Genre {
	
	private int id;
	private String name;
	
	public Genre() {}
	
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
<<<<<<< HEAD
}
=======
	
	
	

}
>>>>>>> 832b3e4fc4cf405de2df146fa3e42788f2589489
