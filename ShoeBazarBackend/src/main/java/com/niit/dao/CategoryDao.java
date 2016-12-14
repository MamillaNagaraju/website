package com.niit.dao;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Supplier;

public interface CategoryDao 
{
	public void saveorupdate(Category cat);
	public Category DispRecord(String sid);
	public String listCategory();
	public void updateRecord(Category cat);
	public void delete(String cid);

}
