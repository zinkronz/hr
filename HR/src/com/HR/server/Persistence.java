package com.HR.server;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class Persistence {
	


	  private static final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");

      protected static PersistenceManagerFactory persistenceManagerFactory;
      
      
      public static PersistenceManagerFactory getPersistenceManagerFactory() {
        return persistenceManagerFactory;
      }
      
      public static void setPersistenceManagerFactory(PersistenceManagerFactory pmf) {
        persistenceManagerFactory = pmf;
      }
      public static PersistenceManager getPersistenceManager() {
        return PMF.getPersistenceManager();
      }

}
