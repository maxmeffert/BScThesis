package plugins.jaxb;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Collections.singleton;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Set;

import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.api.Artifact;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.google.common.base.Joiner;

import plugins.prelude.GuidedEvaluatorPlugin;

public class JavaRefersToJava extends GuidedEvaluatorPlugin {

	private Iterable<Artifact> filesOf(Iterable<Artifact> as) {
		return from(as).transformAndConcat(a -> a.hasContent() ? singleton(a) : a.getChildren());
	}

	@Override
	public void guidedEvaluate(Relationship relationship) throws IOException {
		// Get all bindings
		List<Artifact> leftArtifacts = artifactsOf(relationship.getLeft());
		List<Artifact> rightArtifacts = artifactsOf(relationship.getRight());

		// Make a set of defined packages and classes
		Set<String> packages = newHashSet();
		Set<String> classes = newHashSet();

		// Iterate all the referred files
		for (Artifact rightArtifact : filesOf(rightArtifacts))
			try (Reader s = rightArtifact.getChars().openStream()) {
				// Parse the compilation unit
				CompilationUnit unit = JavaParser.parse(s, false);

				// Add the package
				String packageName = unit.getPackage().getName().toString();
				packages.add(packageName);

				// If there is types, add them to the classes
				if (unit.getTypes() != null)
					for (TypeDeclaration type : unit.getTypes()) {
						String typeName = type.getNameExpr().toString();
						classes.add(packageName.isEmpty() ? typeName : packageName + "." + typeName);
					}
			} catch (ParseException e) {
				// Not responsible for not an element of
			}

		Set<String> evidenceMessages = newHashSet();
		for (Artifact leftArtifact : filesOf(leftArtifacts))
			try (Reader s = leftArtifact.getChars().openStream()) {
				CompilationUnit unit = JavaParser.parse(s, false);

				String packageName = unit.getPackage().getName().toString();
				if (packages.contains(packageName)) {
					evidenceMessages.add("The artifact " + leftArtifact.getName()
							+ " is in the same package as a referred artifact, namely " + packageName + ".");
				}

				for (ImportDeclaration imp : unit.getImports()) {
					if (imp.isStatic()) {
						if (classes.contains(imp.getName().toString())) {
							evidenceMessages.add("The artifact " + leftArtifact.getName()
									+ " statically imports the members of the referred artifact "
									+ imp.getName().toString() + ".");
						}
					} else if (imp.isAsterisk()) {
						if (packages.contains(imp.getName().toString())) {
							evidenceMessages
									.add("The artifact " + leftArtifact.getName() + " imports the package elements of "
											+ imp.getName().toString() + " containing a referred artifact.");
						}
					} else {
						if (classes.contains(imp.getName().toString())) {
							evidenceMessages.add("The artifact " + leftArtifact.getName()
									+ " imports a referred artifact " + imp.getName().toString() + ".");
						}
					}
				}

			} catch (ParseException e) {
				// Not responsible for not an element of
			}

		if (evidenceMessages.isEmpty())
			error("No referral evidence found for the given bindings.");
		else {
			valid();
			info(Joiner.on("\r\n").join(evidenceMessages));
		}

	}
}
