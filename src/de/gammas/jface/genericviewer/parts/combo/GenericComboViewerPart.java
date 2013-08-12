package de.gammas.jface.genericviewer.parts.combo;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;

public class GenericComboViewerPart {
	@Inject
	public GenericComboViewerPart(Composite parent) {
		parent.setLayout(new GridLayout());
		ComboViewer<Person, List<Person>> comboViewer = new ComboViewer<>(
				parent);

		comboViewer.setLabelProvider(new LabelProvider<Person>() {
			@Override
			public String getText(Person element) {
				return element.getFirstName()+" "+element.getName();
			}
		});

		comboViewer.setContentProvider(new IStructuredContentProvider<Person,List<Person>>() {

			@Override
			public void inputChanged(Viewer<List<Person>> viewer,
					List<Person> oldInput, List<Person> newInput) {

			}

			@Override
			public void dispose() {

			}

			@Override
			public Person[] getElements(List<Person> inputElement) {
				Person[] persons = {};
				return (Person[]) inputElement.toArray(persons);
			}


		});

		comboViewer.setInput(generateInput());
	}

	private List<Person> generateInput() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Zufall", "Rainer"));
		persons.add(new Person("Muessener", "Clemens"));

		return persons;
	}

}