package org.softlang.megal.explorer;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.softlang.megal.MegalFile;
import org.softlang.megal.language.MegalReasoning;
import org.softlang.megal.mi2.api.Result;

public class ExplorerView extends ViewPart {

	private XtextEditor current = null;

	private Result result = null;

	Composite parent;
	private Tree tree;
	private TreeViewer treeViewer;

	private TreeColumn leftColumn;
	private TreeColumn rightColumn;

	@Override
	public void createPartControl(Composite parent) {
		this.parent = parent;

		tree = new Tree(parent, SWT.BORDER | SWT.V_SCROLL); // SWT.H_SCROLL
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		// Resize listener to change swt components width.
		parent.addListener(SWT.Resize, new Listener() {

			@Override
			public void handleEvent(Event event) {
				int width = parent.getBounds().width;
				leftColumn.setWidth(width / 2);
				rightColumn.setWidth(width / 2);
			}
		});

		treeViewer = new TreeViewer(tree);

		treeViewer.setContentProvider(new ExplorerContentProvider(this));
		treeViewer.setLabelProvider(new ExplorerLabelProvider(this));

		leftColumn = new TreeColumn(tree, SWT.CENTER);
		leftColumn.setAlignment(SWT.LEFT);
		leftColumn.setText("Domain");
		leftColumn.setResizable(false);
		leftColumn.setMoveable(false);

		rightColumn = new TreeColumn(tree, SWT.CENTER);
		rightColumn.setAlignment(SWT.LEFT);
		rightColumn.setText("Range");
		rightColumn.setResizable(false);
		rightColumn.setMoveable(false);

		// Register selection service listener.
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(new ISelectionListener() {

			@Override
			public void selectionChanged(IWorkbenchPart part, ISelection selection) {
				if (part instanceof XtextEditor && current != part) {
					current = ((XtextEditor) part);
					change();
				}
			}
		});

	}

	private void change() {
		Result result = current.getDocument().readOnly(new IUnitOfWork<Result, XtextResource>() {
			public Result exec(XtextResource state) throws Exception {
				if (state.getContents().size() != 0 && !(state.getContents().get(0) instanceof MegalFile))
					return null;
				MegalFile megamodel = (MegalFile) state.getContents().get(0);

				// Perform the evaluation
				return MegalReasoning.getLocalResult(megamodel);
			};
		});

		treeViewer.setInput(result);
	}

	@Override
	public void setFocus() {

	}
}
