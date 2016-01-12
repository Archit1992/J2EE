package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.ValueObject;

public class DatabaseAccessObject {

	public void insert(ValueObject vo) {
		// TODO Auto-generated method stub
		Session session = null;
		List ls=null;

		try {
			// This step will read hibernate.cfg.xml and prepare Hibernate for use
			SessionFactory sessionFactory = new
			// read cgf file.and create an object.
			Configuration().configure().buildSessionFactory();

			session = sessionFactory.openSession();
			// for more then transaction.
			Transaction y = session.beginTransaction();
			// Create new instance of Contact and set
			// values in it by reading them from form object
			session.save(vo);// insert query
			y.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	}

	public List  search() {
		// TODO Auto-generated method stub
		Session session = null;
		List ls=null;

		try {

			SessionFactory sessionFactory = new

			Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Query q = session.createQuery("from ValueObject");
			ls=q.list();
			return ls;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return ls;
	}

	public List edit(ValueObject vo) {
		
		Session session = null;
		List ls=null;
		try {
			SessionFactory sessionFactory = new	Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Query q = session.createQuery("from ValueObject where personId="+vo.getPersonId());
			ls=q.list();
			return ls;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
		return null;
	}

	public void update(ValueObject vo) {
		Session session = null;
		List ls=null;

		try {
			SessionFactory sessionFactory = new
			Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction y = session.beginTransaction();// for more then trans.
			session.saveOrUpdate(vo);
			y.commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}		
	}

	public void delete(ValueObject vo) {
		
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			Transaction y = session.beginTransaction();
			session.delete(vo);
			y.commit();
			System.out.println("DONE Deletion... ... ... ... ");
			session.flush();
			session.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
