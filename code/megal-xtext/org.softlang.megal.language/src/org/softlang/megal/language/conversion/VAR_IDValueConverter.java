package org.softlang.megal.language.conversion;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

public class VAR_IDValueConverter implements IValueConverter<String> {
	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		if (!string.startsWith("?"))
			throw new ValueConverterException("Not a varying identifier", node, null);
		return string.substring(1);
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		return "?" + value;
	}

}
