
package de.gammas.jface.genericviewer.parts.tree;

import javax.annotation.PostConstruct;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import de.gammas.jface.genericviewer.model.Person;
import de.gammas.jface.genericviewer.model.PersonRoot;

public class TreePathViewerPart {


	@PostConstruct
	public void postConstruct(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent);
		treeViewer.setContentProvider(new MyTreePathContentProvider());
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