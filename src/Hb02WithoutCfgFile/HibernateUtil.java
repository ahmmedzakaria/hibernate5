/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hb02WithoutCfgFile;

 import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

/**
 * @author kishan Kumar
 */
public class HibernateUtil {
 private static StandardServiceRegistry standardServiceRegistry;
 private static SessionFactory sessionFactory;

 static {
  // Creating StandardServiceRegistryBuilder 
  StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
 
  // Hibernate settings which is equivalent to hibernate.cfg.xml's properties
  Map<String, String> dbSettings = new HashMap<>();
  dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/db_hibernate5");
  dbSettings.put(Environment.USER, "root");
  dbSettings.put(Environment.PASS, "123");
  dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
  dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
  dbSettings.put(Environment.FORMAT_SQL, "true");

  // Apply database settings
  registryBuilder.applySettings(dbSettings);

  // Creating registry
  standardServiceRegistry = registryBuilder.build();

  // Creating MetadataSources
  MetadataSources sources = new MetadataSources(standardServiceRegistry);

  // Creating Metadata
  Metadata metadata = sources.getMetadataBuilder().build();

  // Creating SessionFactory
  sessionFactory = metadata.getSessionFactoryBuilder().build();
 }

 //Utility method to return SessionFactory
 public static SessionFactory getSessionFactory() {
  return sessionFactory;
 }
}