package org.softlang.megal.browsing.eval;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.softlang.megal.language.Megals;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.ModelExecutor;
import org.softlang.megal.mi2.api.Result;
import org.softlang.megal.mi2.api.resolution.ProjectResolution;

public class MegalEvaluator implements Runnable {

	private IFile file;
	private Result result;
	
	public MegalEvaluator(IFile file) {
		this.file = file;
	}
	
	public boolean hasResult() {
		return result != null;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void evaluate() {
		File megalFile = new File(file.getRawLocationURI());
		
		try {
			
			KB kb =  MegamodelKB.loadAll(Megals.load(megalFile, megalFile.getParentFile().listFiles()));
			ModelExecutor ex = new ModelExecutor();
			
			result = ex.evaluate(new ProjectResolution(){

				@Override
				protected IProject getProject() {
					return file.getProject();
				} 

			}, kb);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		evaluate();
		
	}

}
