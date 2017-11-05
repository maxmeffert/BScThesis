package org.softlang.megal.plugins.old;

import static org.softlang.megal.plugins.util.Prelude.isElementOfLanguage;

import java.io.IOException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;
import org.softlang.megal.plugins.api.GuidedEvaluatorPlugin;
import org.xml.sax.SAXException;


import com.google.common.base.Throwables;

public class XSDConformanceEvaluatorPlugin extends GuidedEvaluatorPlugin {

	@Override
	public void guidedEvaluate(Relationship relationship) throws IOException,
			SAXException {
		// Responsible when left is an XML and right is an XSD
		when(isElementOfLanguage(relationship.getLeft(), "XML"));
		when(isElementOfLanguage(relationship.getRight(), "XSD"));

		// Get the XML and the XSD artifact
		Artifact left = artifactOf(relationship.getLeft());
		Artifact right = artifactOf(relationship.getRight());

		// Obtain a schema factory
		SchemaFactory factory = SchemaFactory
				.newInstance("http://www.w3.org/2001/XMLSchema");

		// Obtain the schema and the validator
		Schema schema = factory.newSchema(new StreamSource(bytesFor(right)));
		Validator validator = schema.newValidator();

		try {
			// Validate XML and mark relation as valid if no error occurred
			validator.validate(new StreamSource(bytesFor(left)));
			valid();
		} catch (SAXException e) {
			error("Instance does not conform to schema, reason: "
					+ Throwables.getStackTraceAsString(e));
		}
	}
}
