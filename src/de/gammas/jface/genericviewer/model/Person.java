package de.gammas.jface.genericviewer.model;

public class Person {
	private String name;
	private String firstName;

	public Person(String name, String firstName) {
		super();
		this.name = name;
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}