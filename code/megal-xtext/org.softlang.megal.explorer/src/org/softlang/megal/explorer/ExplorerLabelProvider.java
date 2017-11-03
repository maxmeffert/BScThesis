package org.softlang.megal.explorer;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.Relationship;

public class ExplorerLabelProvider implements ITableLabelProvider, ITableColorProvider {

	private final ExplorerView explorerView;

	public ExplorerLabelProvider(ExplorerView explorerView) {
		this.explorerView = explorerView;
	}

	@Override
	public void addListener(ILabelProviderListener listener) {

	}

	@Override
	public void dispose() {

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

	}

	@Override
	public Color getForeground(Object element, int columnIndex) {
		return null;
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {
		if (!(element instanceof Relationship))
			return null;

		Relationship relationship = (Relationship) element;
		if (columnIndex == 0)
			return getColor(relationship.getLeft());

		if (columnIndex == 1)
			return getColor(relationship.getRight());

		return null;
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (!(element instanceof Relationship))
			return "missing label";

		Relationship relationship = (Relationship) element;
		if (columnIndex == 0)
			return relationship.getLeft().getName();

		if (columnIndex == 1)
			return relationship.getRight().getName();

		return "missing lable for column";
	}

	private Color getColor(Entity entity) {
		String string = entity.getAnnotation("Color");

		if (string == null)
			return getColor(entity.getType());

		String[] components = string.split(",");

		if (components.length != 3)
			return getColor(entity.getType());

		return new Color(explorerView.parent.getDisplay(), Integer.valueOf(components[0]),
				Integer.valueOf(components[1]), Integer.valueOf(components[2]));
	}

	private Color getColor(EntityType entitytype) {
		String string = entitytype.getAnnotation("Color");

		if (string == null)
			return null;

		String[] components = string.split(",");

		if (components.length != 3)
			return null;

		return new Color(explorerView.parent.getDisplay(), Integer.valueOf(components[0]),
				Integer.valueOf(components[1]), Integer.valueOf(components[2]));
	}

}
