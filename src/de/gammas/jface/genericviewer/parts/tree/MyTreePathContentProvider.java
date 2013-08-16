package de.gammas.jface.genericviewer.parts.tree;

import org.eclipse.jface.viewers.ITreePathContentProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.Viewer;

import de.gammas.jface.genericviewer.model.Person;
import de.gammas.jface.genericviewer.model.PersonRoot;

public class MyTreePathContentProvider implements ITreePathContentProvider {
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return new Object[]{((PersonRoot)inputElement).getRootPerson()};
	}

	@Override
	public Object[] getChildren(TreePath parentPath) {
		Person person = (Person) parentPath.getLastSegment();
		return person.getChildren().toArray();
	}

	@Override
	public boolean hasChildren(TreePath path) {
		Person person = (Person) path.getLastSegment();

		return (person.getChildren() != null);
	}

	@Override
	public TreePath[] getParents(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
}
