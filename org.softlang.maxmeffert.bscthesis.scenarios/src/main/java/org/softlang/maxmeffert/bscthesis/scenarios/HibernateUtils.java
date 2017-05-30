package org.softlang.maxmeffert.bscthesis.scenarios;

import java.io.File;
import java.util.EnumSet;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.softlang.maxmeffert.bscthesis.scenarios.model.*;

public class HibernateUtils {

	private static final File hibernateCfg = new File("./src/main/resources/META-INF/hibernate.cfg.xml");
	private static final Configuration cfg = new Configuration().configure(hibernateCfg);
	private static final MetadataSources metadata = new MetadataSources(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
	
	public static void generateDDL(File file) {
		metadata.addAnnotatedClass(Company.class);
		metadata.addAnnotatedClass(Department.class);
		metadata.addAnnotatedClass(Employee.class);
		SchemaExport export = new SchemaExport();
		export.setOutputFile(file.getAbsolutePath());
		export.create(EnumSet.of(TargetType.SCRIPT), metadata.buildMetadata());
	}
	
}
