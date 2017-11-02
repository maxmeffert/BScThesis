package org.softlang.megal.language;

import org.eclipse.xtext.resource.XtextResource;
import org.softlang.megal.MegalDeclaration;
import org.softlang.megal.MegalFile;
import org.softlang.megal.MegalLink;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.api.ModelExecutor;
import org.softlang.megal.mi2.api.Result;
import org.softlang.megal.mi2.api.resolution.ContainingProjectResolution;

import com.google.inject.Provider;

public class MegalReasoning {
	public static final String KB_KEY = "org.softlang.megal.language.MegalReasoning.KB_KEY";

	public static final String RESULT_KEY = "org.softlang.megal.language.MegalReasoning.RESULT_KEY";

	/**
	 * <p>
	 * Gets the KB associated with the megamodel, may be cached in XText resources.
	 * </p>
	 * 
	 * @param megamodel
	 *            The megamodel to get the KB for
	 * @return Returns the KB for the megamodel
	 */
	public static KB getKB(final MegalFile megamodel) {
		if (megamodel.eResource() instanceof XtextResource)
			// If the megamodel resource has been loaded by XText, use the
			// resource scoped cache for KB evaluation
			return ((XtextResource) megamodel.eResource()).getCache().get(KB_KEY, megamodel.eResource(),
					new Provider<KB>() {
						@Override
						public KB get() {
							return prepareKB(megamodel);
						}
					});
		else
			// Else use reevaluation
			return prepareKB(megamodel);
	}

	public static KB getKB(MegalDeclaration declaration) {
		return getKB((MegalFile) declaration.eContainer());
	}

	public static KB getKB(MegalLink link) {
		return getKB((MegalFile) link.eContainer());
	}

	public static KB prepareKB(final MegalFile megamodel) {
		return MegamodelKB.loadAll(megamodel);
	}

	public static Result getLocalResult(final MegalFile megamodel) {
		if (megamodel.eResource() instanceof XtextResource)
			// If the megamodel resource has been loaded by XText, use the
			// resource scoped cache for model execution
			return ((XtextResource) megamodel.eResource()).getCache().get(RESULT_KEY, megamodel.eResource(),
					new Provider<Result>() {
						@Override
						public Result get() {
							return prepareLocalResult(megamodel);
						}
					});
		else
			// Else use reevaluation
			return prepareLocalResult(megamodel);
	}

	public static Result getLocalResult(MegalDeclaration declaration) {
		return getLocalResult((MegalFile) declaration.eContainer());
	}

	public static Result getLocalResult(MegalLink link) {
		return getLocalResult((MegalFile) link.eContainer());
	}

	public static Result prepareLocalResult(MegalFile megamodel) {
		// Make the default executor
		ModelExecutor executor = new ModelExecutor();

		// Perform the evaluation
		return executor.evaluate(new ContainingProjectResolution(megamodel), getKB(megamodel));
	}
}
