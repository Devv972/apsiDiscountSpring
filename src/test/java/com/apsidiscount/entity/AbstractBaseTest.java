package com.apsidiscount.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractBaseTest {

   private static Map<String, String> persistenceMap;
   private EntityManagerFactory emf;
   protected EntityManager em;

   @BeforeClass
   public static void loadProperties() throws IOException {
       Properties properties = new Properties();
       properties.load(Properties.class.getResourceAsStream("/apsidiscount.properties"));
       properties = new Properties(properties);
       properties.load(new FileInputStream("apsidiscount.properties"));

       persistenceMap = new HashMap<String, String>();
       persistenceMap.put("javax.persistence.jdbc.url", properties.getProperty("db.url"));
       persistenceMap.put("javax.persistence.jdbc.driver", properties.getProperty("db.driver.classname"));
       persistenceMap.put("javax.persistence.jdbc.user", properties.getProperty("db.user.login"));
       persistenceMap.put("javax.persistence.jdbc.password", properties.getProperty("db.user.password"));
   }

   @Before
   public void createEntityManager() throws IOException {
       emf = Persistence.createEntityManagerFactory("apsidiscount", persistenceMap);
       em = emf.createEntityManager();
   }

   @After
   public void closeEntityManager() {
       if (em.getTransaction().isActive()) {
           em.getTransaction().rollback();
       }
       em.close();
       emf.close();
   }
}
