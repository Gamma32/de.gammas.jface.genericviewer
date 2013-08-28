package de.gammas.jface.genericviewer.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private String firstName;
	private List<Person> children;
	private Person parent;

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

	public List<Person> getChildren() {
		return this.children;
	}

	public void addChildren(Person children) {
		if (this.children == null) {
			this.children = new ArrayList<>();
		}
		children.setParent(this);
		this.children.add(children);
	}

	public void setParent(Person parent){
		this.parent = parent;
	}

	public Person getParent(){
		return this.parent;
	}

}
