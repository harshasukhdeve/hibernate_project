package utility;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConnectionManager {
	
	public static SessionFactory sessionfactory = null;
	
	public static SessionFactory getSessionFactory() throws HibernateException
	{
		if(sessionfactory == null)
		{
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			sessionfactory = configuration.buildSessionFactory();
		}
		
		return sessionfactory;
		
	}

}