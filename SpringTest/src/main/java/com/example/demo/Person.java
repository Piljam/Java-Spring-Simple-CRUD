package com.example.demo;

public class Person {
	private String id;
	private String name;
	private int age;
	private String roles;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(String id, String name, int age, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.roles = roles;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	

}
