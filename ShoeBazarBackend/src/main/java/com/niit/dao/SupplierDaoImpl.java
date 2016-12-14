package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.niit.model.Supplier;

@Repository("suppDao")
public class SupplierDaoImpl implements SupplierDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveorupdate(Supplier supp) 
	{
		System.out.println("i am in supplier dao class");
		Session s = sessionFactory.openSession();
		System.out.println("sesssion="+s);
		s.beginTransaction();
		s.saveOrUpdate(supp);
		s.getTransaction().commit();
		System.out.println("supplier data successfully done"+s);
	
		
	}

		
	@SuppressWarnings("unchecked")
	public String listSupplier()
	{
		System.out.println("I am in View Supplier Dao Function");
		Session s = sessionFactory.openSession();
		Transaction tx  = s.beginTransaction();
		//List<Supplier> slist = s.createCriteria(Supplier.class).list();
		//List li = s.createCriteria(Supplier.class).list();
		List li = s.createQuery("from Supplier").list();
		Gson gson = new Gson();
		String jsonlist = gson.toJson(li);
		s.getTransaction().commit();
		return jsonlist;
	}


	/*public Supplier getByName(String name) {
		System.out.println(" supplier info with getByName");
		String hql ="from supplier where name="+"'"+name+"'";
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if(list!=null && !list.isEmpty())
		{
 			return list.get(0);
		}
		t.commit();
		return null;
	}
*/

	public void delete(int sid) {
		System.out.println(" delete called in supplier dao impl..");
		Session s = sessionFactory.openSession();
		Transaction t = s.beginTransaction();
		Supplier suppliertodelete = s.get(Supplier.class, sid);
		//suppliertodelete.setSid(sid);
		s.delete(suppliertodelete);
		//sessionFactory.getCurrentSession().delete(suppliertodelete);
		t.commit();
		s.close();
		
		
	}
	
	public Supplier DispRecord(int sid)
	{
		Session se = sessionFactory.openSession();
		se.beginTransaction();
		Supplier supp = (Supplier)se.get(Supplier.class, sid);
		return supp;
	}
	

		public void updateRecord(Supplier supp)
		{
			Session se = sessionFactory.openSession();
			se.beginTransaction();
			int sid = supp.getSid();
			Supplier supobj = (Supplier)se.get(Supplier.class,sid);
			supobj.setName(supp.getName());
			supobj.setAddress(supp.getAddress());
			se.update(supobj);
			se.getTransaction().commit();
		}
		
	public int SortId()
		{
			Session sess = sessionFactory.openSession();
			Query query = sess.createQuery("from Supplier order by sid desc");
			query.setMaxResults(1);
			Supplier sup =  (Supplier)query.uniqueResult();
			int id = sup.getSid();
			return id;
		}


		
}
