package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Product;

@Repository("productdao")
public class ProductDaoImpl implements ProductDao
{

@Autowired
 private SessionFactory sessionFactory;
	
public ProductDaoImpl(SessionFactory sessionFactory) 
{
	this.sessionFactory =sessionFactory;
}

public List<Product> list()
{
	@SuppressWarnings("unchecked")
	List<Product> listproduct = (List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return listproduct;
	
}
public void saveOrUpdate(Product product) {
	sessionFactory.getCurrentSession().saveOrUpdate(product);

}
public void delete(String id) {
	Product ProductToDelete = new Product();
	ProductToDelete.setPid(id);
	sessionFactory.getCurrentSession().delete(ProductToDelete);
}
	
public Product get(String id) {
	String hql = "from"+" Product"+" where id=" + "'"+id+"'";
	
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Product> listProduct = (List<Product>) query.list();
	
	if (listProduct != null && !listProduct.isEmpty()) {
		return listProduct.get(0);
	}
	
	return null;
}
	
	
}
