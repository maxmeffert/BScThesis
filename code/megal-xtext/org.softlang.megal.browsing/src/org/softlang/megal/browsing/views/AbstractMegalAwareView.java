package org.softlang.megal.browsing.views;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractMegalAwareView extends ViewPart {
	
	abstract void megalFileChanged(IFile file);
	
	private void registerMegalTextEditorSelectionListener() {
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(new ISelectionListener() {
			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				if (part instanceof TextEditor) {	
					TextEditor textEditor = (TextEditor) part;
					Object input = textEditor.getEditorInput().getAdapter(IFile.class);
					if (input instanceof IFile) {
						IFile file = (IFile) input;
						if (file.getName().toLowerCase().endsWith(".megal")) {
							megalFileChanged(file);
						}
					}
				}
			}
		});
	}
	
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		registerMegalTextEditorSelectionListener();
	}
	
	public void init(IViewSite site, IMemento memento) throws PartInitException {
		super.init(site, memento);
		registerMegalTextEditorSelectionListener();
	}
	
}
