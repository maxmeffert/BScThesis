package org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.softlanginc;

import java.io.File;
import java.util.EnumSet;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.softlanginc.model.Company;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.softlanginc.model.Department;
import org.softlang.maxmeffert.bscthesis.ccrecovery.scenarios.softlanginc.model.Employee;

public class HibernateUtils {

	private static final File hibernateCfgFile = new File("./src/main/resources/META-INF/hibernate.cfg.xml");
	private static final Configuration configuration = new Configuration().configure(hibernateCfgFile);
	private static final MetadataSources metadataSources = new MetadataSources(new StandardServiceRegistryBuilder().enableAutoClose().applySettings(configuration.getProperties()).build());
	
	static {
		metadataSources.addAnnotatedClass(Company.class);
		metadataSources.addAnnotatedClass(Department.class);
		metadataSources.addAnnotatedClass(Employee.class);
	}
	
	public static void generateDDL(File file) {
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setOutputFile(file.getAbsolutePath());
		schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadataSources.buildMetadata());
	}
	
}
