package org.softlang.megal.plugins;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.softlang.megal.language.*;
import org.softlang.megal.mi2.Entity;
import org.softlang.megal.mi2.EntityType;
import org.softlang.megal.mi2.KB;
import org.softlang.megal.mi2.MegamodelKB;
import org.softlang.megal.mi2.Relationship;
import org.softlang.megal.mi2.RelationshipType;
import org.softlang.megal.mi2.api.ModelExecutor;
import org.softlang.megal.mi2.api.resolution.LocalResolution;
import org.softlang.megal.mi2.api.resolution.Resolution;
import org.softlang.megal.plugins.util.Prelude;

@SuppressWarnings("unused")
public class Main {
	
	static final private boolean showMetrics = true;
	static final private boolean showTypes = false;
	static final private boolean showInstances = false;
	
	static final private File root = new File("..");
	static final private Resolution rootResolution = new LocalResolution(){ 

		@Override
		protected File getRoot() {
			try {
				return root.getCanonicalFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return root;
		}
		
	};
		
	static private String input = "megal/main.megal";
	static private String output = "output/out.megal";
	
	static public KB load (File f) throws IOException {
		
		if (f.isDirectory()) {
		
			throw new IllegalStateException("File is a directory!");
			
		}
		
		System.out.println("Loading KB...");
		
		KB kb =  MegamodelKB.loadAll(Megals.load(f, f.getParentFile().listFiles()));
		
		System.out.println("KB loaded.");
		
		return kb;
		
	}
	
	static public KB evaluate (KB kb) throws IOException {
		
		System.out.println("Evaluating KB...");
		
		ModelExecutor ex = new ModelExecutor();
		kb = ex.evaluate(rootResolution, kb).getOutput();
		
		System.out.println("KB evalutated.");
		
		return kb;
		
	}
	
	static private void printMetrics(KB kb, PrintStream out) {
		
		out.println();
		out.println("/*");
		out.println("============================================");
		out.println("                  Metrics                   ");
		out.println("============================================");
		out.println("#(Element)          : " + Metrics.getElementCount(kb));
		out.println("#(EntityType)       : " + Metrics.getEntityTypeCount(kb));
		out.println("#(Entitie)          : " + Metrics.getEntityCount(kb));
		out.println("#(Relationship)     : " + Metrics.getRelationshipCount(kb));
		out.println("#(RelationshipType) : " + Metrics.getRelationshipTypeCount(kb));
		out.println();
		out.println("#(_ instanceOf Artifact)         : " + Metrics.getEntityCount(kb, "Artifact"));
		out.println("#(_ instanceOf File)             : " + Metrics.getEntityCount(kb, "File"));
		out.println("#(_ instanceOf Fragment)         : " + Metrics.getEntityCount(kb, "Fragment"));
		out.println();
		out.println("#(partOf)            : " + Metrics.getRelationshipCount(kb, "partOf"));
		out.println("#(fragmentOf)        : " + Metrics.getRelationshipCount(kb, "fragmentOf"));
		out.println("#(correspondsTo)     : " + Metrics.getRelationshipCount(kb, "correspondsTo"));
		out.println("#(conformsTo)        : " + Metrics.getRelationshipCount(kb, "conformsTo"));
		out.println();
		out.println("#(_ partOf companyJavaFile)          : " + Metrics.getRelationshipLeftCount(kb, "partOf", "companyJavaFile"));
		out.println("#(_ fragmentOf companyJavaFile)      : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "companyJavaFile"));
		out.println("#(_ correspondsTo companyJavaFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "companyJavaFile"));
		out.println("#(_ conformsTo companyJavaFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "companyJavaFile"));
		out.println();
		out.println("#(_ partOf companyHbmFile)           : " + Metrics.getRelationshipLeftCount(kb, "partOf", "companyHbmFile"));
		out.println("#(_ fragmentOf companyHbmFile)       : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "companyHbmFile"));
		out.println("#(_ correspondsTo companyHbmFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "companyHbmFile"));
		out.println("#(_ conformsTo companyHbmFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "companyHbmFile"));
		out.println();
		out.println("#(_ partOf departmentJavaFile)       : " + Metrics.getRelationshipLeftCount(kb, "partOf", "departmentJavaFile"));
		out.println("#(_ fragmentOf departmentJavaFile)   : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "departmentJavaFile"));
		out.println("#(_ correspondsTo departmentJavaFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "departmentJavaFile"));
		out.println("#(_ conformsTo departmentJavaFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "departmentJavaFile"));
		out.println();
		out.println("#(_ partOf departmentHbmFile)        : " + Metrics.getRelationshipLeftCount(kb, "partOf", "departmentHbmFile"));
		out.println("#(_ fragmentOf departmentHbmFile)    : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "departmentHbmFile"));
		out.println("#(_ correspondsTo departmentHbmFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "departmentHbmFile"));
		out.println("#(_ conformsTo departmentHbmFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "departmentHbmFile"));
		out.println();
		out.println("#(_ partOf employeeJavaFile)         : " + Metrics.getRelationshipLeftCount(kb, "partOf", "employeeJavaFile"));
		out.println("#(_ fragmentOf employeeJavaFile)     : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "employeeJavaFile"));
		out.println("#(_ correspondsTo employeeJavaFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "employeeJavaFile"));
		out.println("#(_ conformsTo employeeJavaFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "employeeJavaFile"));
		out.println();
		out.println("#(_ partOf employeeHbmFile)          : " + Metrics.getRelationshipLeftCount(kb, "partOf", "employeeHbmFile"));
		out.println("#(_ fragmentOf employeeHbmFile)      : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "employeeHbmFile"));
		out.println("#(_ correspondsTo employeeHbmFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "employeeHbmFile"));
		out.println("#(_ conformsTo employeeHbmFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "employeeHbmFile"));
		out.println();
		out.println("#(_ partOf companiesXmlFile)         : " + Metrics.getRelationshipLeftCount(kb, "partOf", "companiesXmlFile"));
		out.println("#(_ fragmentOf companiesXmlFile)     : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "companiesXmlFile"));
		out.println("#(_ correspondsTo companiesXmlFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "companiesXmlFile"));
		out.println("#(_ conformsTo companiesXmlFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "companiesXmlFile"));
		out.println();
		out.println("#(_ partOf companiesXsdFile)         : " + Metrics.getRelationshipLeftCount(kb, "partOf", "companiesXsdFile"));
		out.println("#(_ fragmentOf companiesXsdFile)     : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "companiesXsdFile"));
		out.println("#(_ correspondsTo companiesXsdFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "companiesXsdFile"));
		out.println("#(_ conformsTo companiesXsdFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "companiesXsdFile"));
		out.println();
		out.println("#(_ partOf comaniesSqlFile)          : " + Metrics.getRelationshipLeftCount(kb, "partOf", "comaniesSqlFile"));
		out.println("#(_ fragmentOf comaniesSqlFile)      : " + Metrics.getRelationshipLeftCount(kb, "fragmentOf", "comaniesSqlFile"));
		out.println("#(_ correspondsTo comaniesSqlFile._) : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "comaniesSqlFile"));
		out.println("#(_ conformsTo comaniesSqlFile._)    : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "comaniesSqlFile"));
		out.println();
		out.println("#(companyJavaFile._ correspondsTo companiesXsdFile._)      : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "companyJavaFile", "companiesXsdFile"));
		out.println("#(companyJavaFile._ correspondsTo comaniesSqlFile._)       : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "companyJavaFile", "comaniesSqlFile"));
		out.println("#(companyJavaFile._ correspondsTo companyHbmFile._)        : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "companyJavaFile", "companyHbmFile"));
		out.println();
		out.println("#(departmentJavaFile._ correspondsTo companiesXsdFile._)   : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "departmentJavaFile", "companiesXsdFile"));
		out.println("#(departmentJavaFile._ correspondsTo comaniesSqlFile._)    : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "departmentJavaFile", "comaniesSqlFile"));
		out.println("#(departmentJavaFile._ correspondsTo departmentHbmFile._)  : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "departmentJavaFile", "departmentHbmFile"));
		out.println();
		out.println("#(employeeJavaFile._ correspondsTo companiesXsdFile._)     : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "employeeJavaFile", "companiesXsdFile"));
		out.println("#(employeeJavaFile._ correspondsTo comaniesSqlFile._)      : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "employeeJavaFile", "comaniesSqlFile"));
		out.println("#(employeeJavaFile._ correspondsTo employeeHbmFile._)      : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "employeeJavaFile", "employeeHbmFile"));
		out.println();
		out.println("#(companiesXmlFile._ conformsTo companiesXsdFile._)        : " + Metrics.getRelationshipFragmentCount(kb, "conformsTo", "companiesXmlFile", "companiesXsdFile"));
		out.println("#(_ conformsTo companiesXsdFile._)                         : " + Metrics.getRelationshipFragmentLeftCount(kb, "conformsTo", "companiesXsdFile"));
		out.println("#(companiesXmlFile._ conformsTo _)                         : " + Metrics.getRelationshipFragmentRightCount(kb, "conformsTo", "companiesXmlFile"));
		out.println();
		out.println("#(companyJavaFile._ correspondsTo companiesXsdFile._)      : " + Metrics.getRelationshipFragmentCount(kb, "correspondsTo", "companyJavaFile", "companiesXsdFile"));
		out.println("#(_ correspondsTo companiesXsdFile._)                      : " + Metrics.getRelationshipFragmentLeftCount(kb, "correspondsTo", "companiesXsdFile"));
		out.println("#(companyJavaFile._ correspondsTo _)                       : " + Metrics.getRelationshipFragmentRightCount(kb, "correspondsTo", "companyJavaFile"));
		out.println("*/");
		out.println();
		
	}
	
	static private void printTypes (KB kb, PrintStream out) {
		
		out.println();
		out.println("/*");
		out.println("============================================");
		out.println("     Entity Types in Alphabetic Order.      ");
		out.println("============================================");
		out.println("*/");
		out.println();
		
		List<EntityType> sortedEntityTypes = kb.getEntityTypes().stream()
				.filter( et -> !et.equals(kb.getTheEntityType()) )
				.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
				.collect(Collectors.toList());
		
		out.println(kb.getTheEntityType());
		
		for (EntityType et : sortedEntityTypes) {
			
			out.println(et);
			
		}
		
		out.println();
		out.println("/*");
		out.println("============================================");
		out.println("  Relationship Types in Alphabetic Order.   ");
		out.println("============================================");
		out.println("*/");
		out.println();		

		List<RelationshipType> sortedRelationshipTypes = kb.getRelationshipTypes().stream()
				.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
				.collect(Collectors.toList());
		
		for (RelationshipType rt : sortedRelationshipTypes) {
			
			out.println(rt);	
			
		}
		
	}
	
	static private void printInstances (KB kb, PrintStream out) {
		
		out.println();
		out.println("/*");
		out.println("============================================");
		out.println("       Instances in Alphabetic Order.       ");
		out.println("============================================");
		out.println("*/");
		out.println();
		
		List<Entity> es = kb.getEntities().stream()
				.filter( e -> e.getType() != null && !e.getType().getName().equals("Plugin")  )
				.sorted( (a,b) -> a.getName().compareToIgnoreCase(b.getName()) )
				.collect(Collectors.toList());
		
		for (Entity e : es) {
			
			for (String name : e.getAnnotations().keys()) {
				
				String value = e.getAnnotation(name);
				
				if (name.equals("FragmentText")) {

					value = value.length() < 50 ? value : value.substring(0, 50) + " ...";
					value = value.replace(System.lineSeparator(), "");
					value = value.trim();
					
				}
				
				
				out.println("@" + name + " '" + value + "'");
				
			}
				
			out.println(e);
			
			List<Relationship> rs = kb.getRelationships().stream()
					.filter( r -> r.getLeft().equals(e))
					.sorted( (a,b) -> (a.getTypeName() + a.getRight().getName()).compareToIgnoreCase(b.getTypeName() + b.getRight().getName()) )
					.collect(Collectors.toList());
			
			for (Relationship rel : rs) {
				
				out.println(rel);
				
			}
			
			
			
			
			
			if (e.getBinding() != null) {
				out.println(e.getName() + " = '" + e.getBinding() + "'");
			}
			
			
			
			
			out.println();
			
		}
		
//		List<Relationship> rels = kb.getRelationships().stream()
//				.filter( r -> !r.getLeft().getType().getName().equals("Plugin")  )
//				.sorted( (a,b) -> a.getLeft().getName().compareToIgnoreCase(b.getLeft().getName()) )
//				.collect(Collectors.toList());
//		
//		for (Relationship rel : rels) {
//			
//			out.println(rel);
//			
//		}
		
	}
		
	public static void main(String[] args) throws IOException {
		
		System.out.println("Start.");
		
		KB kb = evaluate(load(new File(input)));
		
		
		if (showMetrics) {
			printMetrics(kb,System.out);
		}
		
		if (showTypes) {
			printTypes(kb,System.out);
		}
		
		if (showInstances) {
			printInstances(kb,System.out);
		}
		
		System.out.println();
		System.out.println("Done!");
		
		System.out.println();
		System.out.println("Start Writing to " + output);
		
		PrintStream out = new PrintStream(new FileOutputStream(output));

		
		printMetrics(kb,out);
		printTypes(kb,out);
		printInstances(kb,out);
		out.close();
		
		System.out.println();
		System.out.println("Done writing to " + output);
		
	}

}
