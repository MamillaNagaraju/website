package com.niit.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.model.Product;

@Controller
public class ProductController
{
	

	@Autowired
	ProductDao productdao;
	
	@Autowired
	CategoryDao categorydao;
	
	@Autowired
	SupplierDao supplierdao;
	
	private Path path;
	
	
	@RequestMapping(value="/productgson")
	@ResponseBody
	public String ProductGson()
	{
		List<Product> list=productdao.list();
		Gson gson=new Gson();
		String data=gson.toJson(list);
		return data;
	}
	
	
	 

}
