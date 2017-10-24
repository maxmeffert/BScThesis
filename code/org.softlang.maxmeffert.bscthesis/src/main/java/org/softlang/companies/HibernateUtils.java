package org.softlang.companies;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.softlang.companies.model.Company;
import org.softlang.companies.model.Department;
import org.softlang.companies.model.Employee;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumSet;

public class HibernateUtils {

	private static final File hibernateCfgFile = new File("./src/main/resources/META-INF/hibernate.cfg.xml");
	private static final Configuration configuration = new Configuration().configure(hibernateCfgFile);
	private static final ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().enableAutoClose().applySettings(configuration.getProperties()).build();
	private static final MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	
	static {
		metadataSources.addAnnotatedClass(Company.class);
		metadataSources.addAnnotatedClass(Department.class);
		metadataSources.addAnnotatedClass(Employee.class);
	}

	private static void clearFile(File file) {
        try {
            new FileWriter(file).write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void generateDDL(File file) {

	    clearFile(file);

		SchemaExport schemaExport = new SchemaExport();
		schemaExport.setOutputFile(file.getAbsolutePath());
		schemaExport.createOnly(EnumSet.of(TargetType.SCRIPT), metadataSources.buildMetadata());

        StandardServiceRegistryBuilder.destroy(serviceRegistry);

	}
	
}
