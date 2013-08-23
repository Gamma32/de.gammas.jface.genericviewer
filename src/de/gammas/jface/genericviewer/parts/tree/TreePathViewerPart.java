
package de.gammas.jface.genericviewer.parts.tree;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;
import de.gammas.jface.genericviewer.model.PersonRoot;

public class TreePathViewerPart {


	@PostConstruct
	public void postConstruct(Composite parent) {
		TreeViewer<Person,PersonRoot> treeViewer = new TreeViewer<Person,PersonRoot>(parent);
		treeViewer.setContentProvider(new ITreePathContentProvider<Person,PersonRoot>(){

			@Override
			public void dispose() {
				// TODO Auto-generated method stub

			}

			@Override
			public void inputChanged(Viewer<PersonRoot> viewer,
					PersonRoot oldInput, PersonRoot newInput) {
				// TODO Auto-generated method stub

			}

			@Override
			public Person[] getElements(PersonRoot inputElement) {
				Person[] persons = new Person[]{inputElement.getRootPerson()};
				return persons;
			}

			@Override
			public Person[] getChildren(TreePath<Person> parentPath) {
				List<Person> childrenList = parentPath.getLastSegment().getChildren();
				Person[] persons = new Person[childrenList.size()];
				return childrenList.toArray(persons);
			}

			@Override
			public boolean hasChildren(TreePath<Person> path) {
				return (path.getLastSegment().getChildren() != null);
			}

			@Override
			public TreePath<Person>[] getParents(Person element) {
				// TODO Auto-generated method stub
				return null;
			}

		});
		treeViewer.setLabelProvider(new MyLableProvider());
		treeViewer.setInput(new PersonRoot());
	}


	class MyLableProvider extends LabelProvider<Person>{
		@Override
		public String getText(Person element) {
			// TODO Auto-generated method stub
			return element.getFirstName();
		}
	}

}