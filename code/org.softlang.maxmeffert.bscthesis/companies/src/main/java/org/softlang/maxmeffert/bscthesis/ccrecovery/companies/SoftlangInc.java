package org.softlang.maxmeffert.bscthesis.ccrecovery.companies;


import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Company;
import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Department;
import org.softlang.maxmeffert.bscthesis.ccrecovery.companies.model.Employee;

public class SoftlangInc {

	private static final Employee AdaLovelace = new Employee("Ada Lovelace", 40, 55000);
	private static final Employee AlanTuring = new Employee("Alan Turing", 40, 55000);
	private static final Employee AlonzoChurch = new Employee("Alonzo Church", 40, 55000);
	private static final Employee NiklausWirth = new Employee("Niklaus Wirth", 40, 55000);
	private static final Employee JohnBackus = new Employee("John Backus", 40, 55000);
	private static final Employee PeterNaur = new Employee("Peter Naur", 40, 55000);
	private static final Department GrammarEngineering = new Department("Grammar Engineering");
	private static final Department LanguageEngineering = new Department("Language Engineering");
	private static final Department ResearchAndDevelopment = new Department("Research & Development");
	private static final Department Programming = new Department("Programming");
	private static final Company SoftlangInc = new Company("Softlang Inc.");
	
	static {
		GrammarEngineering.getEmployees().add(JohnBackus);
		GrammarEngineering.getEmployees().add(PeterNaur);
		GrammarEngineering.setManager(PeterNaur);
		GrammarEngineering.setCompany(SoftlangInc);
		GrammarEngineering.setSuperDepartment(LanguageEngineering);
		
		LanguageEngineering.getEmployees().add(NiklausWirth);
		LanguageEngineering.getSubDepartments().add(GrammarEngineering);
		LanguageEngineering.setManager(NiklausWirth);
		LanguageEngineering.setCompany(SoftlangInc);
		
		ResearchAndDevelopment.getEmployees().add(AlonzoChurch);
		ResearchAndDevelopment.getEmployees().add(AlanTuring);
		ResearchAndDevelopment.setManager(AlanTuring);
		ResearchAndDevelopment.setCompany(SoftlangInc);
		
		Programming.getEmployees().add(AdaLovelace);
		Programming.setManager(AdaLovelace);
		Programming.setCompany(SoftlangInc);
		
		SoftlangInc.getDepartments().add(GrammarEngineering);
		SoftlangInc.getDepartments().add(ResearchAndDevelopment);
		SoftlangInc.getDepartments().add(LanguageEngineering);
		SoftlangInc.getDepartments().add(Programming);
	}
	
	public static Company getCompany() {
		return SoftlangInc;
	}
	
}
