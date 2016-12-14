package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("categoryDAOImpl")
public class CategoryDaoImpl implements CategoryDao 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionfactory)
	{
		this.sessionFactory= sessionfactory;
	}
	
 

	public void saveorupdate(Category cat) 
	{
		System.out.println("i am in supplier dao class");
		Session s = sessionFactory.openSession();
		System.out.println("sesssion="+s);
		s.beginTransaction();
		s.saveOrUpdate(cat);
		s.getTransaction().commit();
		System.out.println("supplier data successfully done"+s);
	
		
	}

		
	@SuppressWarnings("unchecked")
	public String listCategory()
	{
		System.out.println("I am in View Supplier Dao Function");
		Session s = sessionFactory.openSession();
		Transaction tx  = s.beginTransaction();
		//List<Supplier> slist = s.createCriteria(Supplier.class).list();
		//List li = s.createCriteria(Supplier.class).list();
		List li = s.createQuery("from Category").list();
		Gson gson = new Gson();
		String jsonlist = gson.toJson(li);
		s.getTransaction().commit();
		return jsonlist;
	}


	

	public void delete(String cid) {
		System.out.println(" delete called in supplier dao impl..");
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Category cattodelete = s.get(Category.class, cid);
				s.delete(cattodelete);
		
		t.commit();
		s.close();
		
		
	}
	
	public Category DispRecord(String cid)
	{
		Session se = sessionFactory.openSession();
		se.beginTransaction();
		Category cat = (Category)se.get(Category.class, cid);
		return cat;
	}
	

		public void updateRecord(Category cat)
		{
			Session se = sessionFactory.openSession();
			se.beginTransaction();
				String cid= cat.getId();
			Category catobj = (Category)se.get(Category.class,cid);
			catobj.setName(cat.getName());
			catobj.setDescription(cat.getDescription());
			
			se.update(catobj);
			se.getTransaction().commit();
		}



		



		
	

	
}