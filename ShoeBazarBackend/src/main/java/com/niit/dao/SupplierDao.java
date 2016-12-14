package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao
{
	public void saveorupdate(Supplier supplier);
	public Supplier DispRecord(int sid);
	public String listSupplier();
	public void updateRecord(Supplier supp);
	public void delete(int sid);
	public int SortId();
}