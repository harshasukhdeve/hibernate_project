package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Report;
import utility.ConnectionManager;
import utility.HibernateConnectionManager;

public class ReportDao implements ReportDaoInterface
{
	private SessionFactory sessionFactory = HibernateConnectionManager.getSessionFactory();
	
	/*final String INSERT_REPORT = "INSERT INTO PATIENT_REPORT VALUES(seq_patient_report.nextval, ?, ?, ?, ?, ?, ?, ?)";
	final String SELECT_ALL_REPORT = "SELECT * FROM PATIENT_REPORT";
	final String DELETE_REPORT = "DELETE FROM PATIENT_REPORT WHERE ID = ?";*/

	@Override
	public void insertreport(Report report) 
	{
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(report);
		tx.commit();
		session.close();
		
		/*try
		{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_REPORT);
			ps.setString(1, report.getName());
			ps.setInt(2, report.getAge());
			ps.setString(3, report.getGender());
			ps.setString(4, report.getWeight());
			ps.setString(5, report.getHeight());
			ps.setString(6, report.getQuery());
			ps.setString(7, report.getMobile());
			
			ps.executeUpdate();
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}*/
		
	}

	@Override
	public List<Report> selectallreports() {
		
		
		Session session = this.sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Report> query = builder.createQuery(Report.class);
		Root<Report> root = query.from(Report.class);
		query.select(root);
		Query<Report> q = session.createQuery(query);
		List<Report> listreport = q.getResultList();
		return listreport;
		
		/*Report report = null;
		List<Report> reportlist = new ArrayList<Report>();
		
		Connection con = ConnectionManager.getConnection();
		try
		{
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_REPORT);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("patient_name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String weight = rs.getString("weight");
				String height = rs.getString("height");
				String query = rs.getString("patient_query");
				String mobile = rs.getString("mobile");
				
				report = new Report();
				
				report.setId(id);
				report.setName(name);
				report.setAge(age);
				report.setGender(gender);
				report.setWeight(weight);
				report.setHeight(height);
				report.setQuery(query);
				report.setMobile(mobile);
				
				reportlist.add(report);	
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}*/
	
	}

	@Override
	public void deletereport(int id) throws SQLException, Exception {
		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Report report = session.get(Report.class, id);
		session.delete(report);
		tx.commit();
		session.close();

		
		
		/*System.out.println(id);
		boolean deleted;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement(DELETE_REPORT);
		ps.setInt(1, id);
		deleted = ps.executeUpdate()>0;
		return deleted;*/
	}

}