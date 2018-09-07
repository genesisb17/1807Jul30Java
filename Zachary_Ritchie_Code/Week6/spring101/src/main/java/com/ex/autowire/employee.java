package com.ex.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class employee 
{
	private String name;
	private double salary;
	
	@Autowired 
	private department depart;
	
	public employee() {}
	
	public employee(String name)
	{
		this.name = name;
	}

	public employee(String name, double salary, department depart) {
		super();
		this.name = name;
		this.salary = salary;
		this.depart = depart;
	}

	@Override
	public String toString() {
		return "employee [name=" + name + ", salary=" + salary + ", depart=" + depart + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public department getDepart() {
		return depart;
	}

	public void setDepart(department depart) {
		this.depart = depart;
	}
	
	
}
