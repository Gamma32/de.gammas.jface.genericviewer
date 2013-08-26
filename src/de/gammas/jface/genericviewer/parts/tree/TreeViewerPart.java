
package de.gammas.jface.genericviewer.parts.tree;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;
import de.gammas.jface.genericviewer.model.PersonRoot;

public class TreeViewerPart {
	@PostConstruct
	public void postConstruct(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new MyTreeContentProvider());
		treeViewer.setLabelProvider(new MyLabelProvider());
		treeViewer.setInput(new PersonRoot());

	}

	class MyTreeContentProvider implements ITreeContentProvider{

		@Override
		public void dispose() {
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		@Override
		public Object[] getElements(Object inputElement) {
			return new Object[]{((PersonRoot)inputElement).getRootPerson()};
		}

		@Override
		public Object[] getChildren(Object parentElement) {
			return ((Person)parentElement).getChildren().toArray();
		}

		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public boolean hasChildren(Object element) {
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