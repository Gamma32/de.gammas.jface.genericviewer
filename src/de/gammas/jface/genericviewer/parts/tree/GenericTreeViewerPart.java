
package de.gammas.jface.genericviewer.parts.tree;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;
import de.gammas.jface.genericviewer.model.PersonRoot;

public class GenericTreeViewerPart {
	@PostConstruct
	public void postConstruct(Composite parent) {
		TreeViewer<Person,PersonRoot> treeViewer = new TreeViewer<Person,PersonRoot>(parent);
		treeViewer.setContentProvider(new MyTreeContentProvider());
		treeViewer.setLabelProvider(new MyLabelProvider());
		treeViewer.setInput(new PersonRoot());
		treeViewer.addFilter(new ViewerFilter<Person, PersonRoot>() {

			@Override
			public boolean select(Viewer<PersonRoot> viewer, Object parentElement,
					Person element) {

				return element.getName().contains("e");
			}
		});

	}

	class MyTreeContentProvider implements ITreeContentProvider<Person,PersonRoot>{

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, PersonRoot oldInput, PersonRoot newInput) {

		}

		@Override
		public Person[] getElements(PersonRoot inputElement) {
			Person[] personArray = new Person[0];
			List<Person> persons = new ArrayList<>();
			persons.add(inputElement.getRootPerson());
			return persons.toArray(personArray);
		}

		@Override
		public Person[] getChildren(Person parentElement) {
			Person[] personArray = new Person[0];
			List<Person> persons = new ArrayList<>();
			persons.addAll(parentElement.getChildren());
			return persons.toArray(personArray);
		}

		@Override
		public Person getParent(Person element) {
			return null;
		}

		@Override
		public boolean hasChildren(Person element) {
			return (((Person)element).getChildren() != null);
		}

	}

	class MyLabelProvider extends LabelProvider<Person>{
		@Override
		public String getText(Person element) {
			return element.getFirstName();
		}
	}


}