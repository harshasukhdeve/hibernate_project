package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Doctor;
import model.User;
import utility.ConnectionManager;
import utility.HibernateConnectionManager;

public class DoctorDao implements DoctorDaoInterface {
	
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();

	@Override
	public boolean loginuser(Doctor doctor) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try
		{
		  tx=session.getTransaction();
		  tx.begin();
		  Query query = session.createQuery("from Doctor where email='"+doctor.getEmail()+"'"+"and pass='"+doctor.getPassword()+"'");
		  doctor = (Doctor)query.uniqueResult();
		  tx.commit();
		}
		catch(Exception e)
		{
			if(tx!=null)
				tx.rollback();
				e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return true;
	}

}