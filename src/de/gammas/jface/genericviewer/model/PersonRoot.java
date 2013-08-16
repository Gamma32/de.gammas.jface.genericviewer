package de.gammas.jface.genericviewer.model;

public class PersonRoot {
	private Person root;

	public PersonRoot() {
		Person peter = new Person("Mueller", "Peter");
		Person hans = new Person("Mueller", "Hans");
		Person lieschen = new Person("Mueller", "Lieschen");
		Person niena = new Person("Mueller", "Niena");
		peter.addChildren(hans);
		peter.addChildren(lieschen);
		lieschen.addChildren(niena);

		root = peter;
	}

	public Person getRootPerson(){
		return root;
	}
}
