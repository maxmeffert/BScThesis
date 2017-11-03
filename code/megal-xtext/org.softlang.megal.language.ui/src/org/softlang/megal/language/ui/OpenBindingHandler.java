package org.softlang.megal.language.ui;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.softlang.megal.MegalEntity;
import org.softlang.megal.MegalLink;
import org.softlang.megal.MegalPlugin;
import org.softlang.megal.language.MegalReasoning;
import org.softlang.megal.mi2.Entity;

import com.google.inject.Inject;

public class OpenBindingHandler extends AbstractHandler {
	@Inject
	public GlobalURIEditorOpener uriEditorOpener;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor(event);
		IWorkbenchPage page = xtextEditor.getSite().getPage();

		if (xtextEditor != null) {
			ITextSelection selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();

			IParseResult parseResult = xtextEditor.getDocument().readOnly(XtextResource::getParseResult);
			ILeafNode selectedNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(),
					selection.getOffset());
			EObject eobject = NodeModelUtils.findActualSemanticObjectFor(selectedNode);

			String linkToVisit = null;

			if (eobject instanceof MegalLink) {
				MegalLink link = (MegalLink) eobject;
				linkToVisit = link.getTo();
			} else if (eobject instanceof MegalEntity) {
				MegalEntity entity = (MegalEntity) eobject;
				Entity kbEntity = MegalReasoning.getLocalResult(entity).getOutput().getEntity(entity.getName());

				if (kbEntity.hasBinding())
					linkToVisit = Objects.toString(kbEntity.getBinding());
			}

			if (linkToVisit != null)
				openLink(page, linkToVisit);

		}
		return null;
	}

	public void openLink(IWorkbenchPage page, String linkToVisit) {
		try {
			URI visitURI = new URI(linkToVisit);
			
			List<Object> resolved = MegalPlugin.getEvaluator().evaluate(visitURI);

			for (Object object : resolved) {
				if (object instanceof IMember && object instanceof IJavaElement) {
					IMember member = (IMember) object;
					IJavaElement javaelement = (IJavaElement) object;
					JavaUI.revealInEditor(JavaUI.openInEditor(member.getCompilationUnit()), javaelement);
				} else if (object instanceof IFile) {
					IFile resource = (IFile) object;
					IDE.openEditor(page, resource);
				} else if (object instanceof org.eclipse.emf.common.util.URI) {
					org.eclipse.emf.common.util.URI uri = (org.eclipse.emf.common.util.URI) object;
					uriEditorOpener.open(uri, true);
				}
			}

		} catch (URISyntaxException | PartInitException | JavaModelException e) {
		}
	}
}
