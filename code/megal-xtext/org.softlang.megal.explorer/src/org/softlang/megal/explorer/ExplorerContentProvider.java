package org.softlang.megal.explorer;

import java.util.Arrays;
import java.util.Comparator;

import org.eclipse.emf.ecore.xml.type.internal.RegEx.REUtil;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Result;

import com.google.common.collect.FluentIterable;

public class ExplorerContentProvider implements ITreeContentProvider {
	private static final Object[] EMPTY = new Object[] {};

	private final ExplorerView explorerView;

	public ExplorerContentProvider(ExplorerView explorerView) {
		this.explorerView = explorerView;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (!(inputElement instanceof Result))
			return EMPTY;
		Result result = (Result) inputElement;

		FluentIterable<Relationship> correspondance = FluentIterable.from(result.getOutput().getRelationships())
				.filter(x -> x.getType() != null).filter(x -> x.getType().getName().equals("correspondsTo"));

		return correspondance.filter(x -> x.getLeft().outgoing("partOf").isEmpty()).toArray(Relationship.class);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (!(parentElement instanceof Relationship))
			return EMPTY;

		Relationship relationship = (Relationship) parentElement;

		Relationship[] relationships = FluentIterable.from(relationship.getLeft().incoming("partOf"))
				.transform(x -> x.getLeft()).transformAndConcat(x -> x.outgoing("correspondsTo"))
				.toArray(Relationship.class);

		Arrays.sort(relationships, new Comparator<Relationship>() {
			@Override
			public int compare(Relationship o1, Relationship o2) {
				return o1.getLeft().getName().compareTo(o2.getLeft().getName());
			}
		});

		return relationships;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		Object[] children = getChildren(element);

		return children != null && children.length > 0;
	}

}
