package org.softlang.megal.language.conversion;

import org.eclipse.xtext.common.services.Ecore2XtextTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

import com.google.inject.Inject;

public class MegalValueConverters extends Ecore2XtextTerminalConverters {

	@Inject
	private ANN_IDValueConverter annIDValueConverter;

	@ValueConverter(rule = "ANN_ID")
	public IValueConverter<String> ANN_ID() {
		return annIDValueConverter;
	}

	@Inject
	private VAR_IDValueConverter varIDValueConverter;

	@ValueConverter(rule = "VAR_ID")
	public IValueConverter<String> VAR_ID() {
		return varIDValueConverter;
	}
}
