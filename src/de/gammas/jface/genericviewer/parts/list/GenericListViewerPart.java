
package de.gammas.jface.genericviewer.parts.list;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;

public class GenericListViewerPart {
	@Inject
	public GenericListViewerPart(Composite parent) {
		ListViewer<Person, List<Person>> listViewer = new ListViewer<>(parent);

		listViewer.setContentProvider(new IStructuredContentProvider<Person, List<Person>>() {

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public void inputChanged(Viewer<List<Person>> viewer,
					List<Person> oldInput, List<Person> newInput) {
				// TODO Auto-generated method stub

			}

			@Override
			public Person[] getElements(List<Person> inputElement) {
				Person[] persons = {};
				return (Person[]) inputElement.toArray(persons);
			}
		});

		listViewer.setLabelProvider(new LabelProvider<Person>(){
			@Override
			public String getText(Person element) {
				return element.getFirstName()+" "+element.getName();
			}
		});

		listViewer.setInput(generateInput());
	}

	private List<Person> generateInput() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Zufall", "Rainer"));
		persons.add(new Person("Muessener", "Clemens"));

		return persons;
	}



}