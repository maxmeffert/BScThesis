package org.softlang.megal;

import static com.google.common.base.Predicates.instanceOf;
import static com.google.common.base.Predicates.not;
import static com.google.common.collect.Iterables.any;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.transform;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.findActualNodeFor;
import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.getTokenText;

import java.util.List;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.util.Strings;
import org.softlang.megal.util.MegalSwitch;

import com.google.common.base.Joiner;

public class Annotations {

	public static String serializeSelection(Selection selection) {
		ICompositeNode node = findActualNodeFor(selection);
		if (node != null)
			return "query:" + getTokenText(node);

		MegalSwitch<String> convert = new MegalSwitch<String>() {
			@Override
			public String caseQueryEntity(QueryEntity object) {
				return object.getEntity().getName();
			}

			@Override
			public String caseQueryParam(QueryParam object) {
				String prefix = "?" + object.getName();
				if (object.getType() != null)
					return prefix + ":" + object.getType().getName();
				return prefix;
			}

			@Override
			public String caseQueryPos(QueryPos object) {
				return "(" + object.getValue() + ")";
			}

			@Override
			public String caseQueryReference(QueryReference object) {
				return "?" + object.getRef().getName();
			}

			@Override
			public String caseQueryString(QueryString object) {
				return "\'" + Strings.convertToJavaString(object.getValue()) + "\'";
			}

			@Override
			public String caseQueryStatement(QueryStatement object) {
				return doSwitch(object.getSubject()) + " " + object.getPredicate().getName() + " "
						+ doSwitch(object.getObject());
			}

			@Override
			public String caseSelection(Selection object) {
				String prefix = Joiner.on(", ").join(transform(object.getSelect(), this::doSwitch));
				if (object.getQuery().isEmpty())
					return prefix;
				return prefix + " from {" + Joiner.on(" ").join(transform(object.getQuery(), this::doSwitch)) + "}";
			}
		};

		return convert.doSwitch(selection);
	}

	public static List<String> getStrings(MegalAnnotation annotation) {
		if (!annotation.getSelection().getQuery().isEmpty())
			return null;

		if (any(annotation.getSelection().getSelect(), not(instanceOf(QueryString.class))))
			return null;

		return transform(annotation.getSelection().getSelect(), x -> ((QueryString) x).getValue());
	}

	public static String getString(MegalAnnotation annotation) {
		if (!annotation.getSelection().getQuery().isEmpty())
			return null;

		if (annotation.getSelection().getSelect().size() != 1)
			return null;

		if (annotation.getSelection().getSelect().get(0) instanceof QueryString)
			return null;

		return ((QueryString) annotation.getSelection().getSelect().get(0)).getValue();
	}
}
