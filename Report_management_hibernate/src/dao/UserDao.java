package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;

import model.User;
import utility.ConnectionManager;
import utility.HibernateConnectionManager;

public class UserDao implements UserDaoInterface {

	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	//you made obj of UserDAO but thi is UserDao
	public int signup(User user)  {
		
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		if(session.save(user)!=null)
		{
			transaction.commit();
			session.close();
			return 1;
		}
		else
		{
			return 0;
		}
		
	}


	@Override
	public boolean loginuser(User user) {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try
		{
		  tx=session.getTransaction();
		  tx.begin();
		  Query query = session.createQuery("from User where username='"+user.getUsername()+"'"+"and pass='"+user.getPassword()+"'");
		  user = (User)query.uniqueResult();
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