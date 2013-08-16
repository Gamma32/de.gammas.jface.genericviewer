package de.gammas.jface.genericviewer.parts.table;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;

public class GenericTableViewerPart {

	@Inject
	public GenericTableViewerPart(Composite parent) {
		TableViewer<Person, List<Person>> tableViewer = new TableViewer<>(
				parent);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer
				.setContentProvider(new IStructuredContentProvider<Person, List<Person>>() {

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
						return inputElement.toArray(persons);
					}

				});

		TableViewerColumn<Person, List<Person>> column = new TableViewerColumn<>(
				tableViewer, SWT.NONE);
		column.getColumn().setText("Fist Name");
		column.getColumn().setWidth(200);
		column.setLabelProvider(new ColumnLabelProvider<Person, List<Person>>() {
			@Override
			public String getText(Person element) {
				return element.getFirstName();
			}
		});

		column = new TableViewerColumn<>(
				tableViewer, SWT.NONE);
		column.getColumn().setText("Name");
		column.getColumn().setWidth(200);
		column.setLabelProvider(new ColumnLabelProvider<Person, List<Person>>() {
			@Override
			public String getText(Person element) {
				return element.getName();
			}
		});

		tableViewer.setInput(generateInput());

	}

	private List<Person> generateInput() {
		List<Person> persons = new ArrayList<>();

		persons.add(new Person("Zufall", "Rainer"));
		persons.add(new Person("Muessener", "Clemens"));

		return persons;
	}

}