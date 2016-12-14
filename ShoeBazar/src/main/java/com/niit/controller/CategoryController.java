package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.dao.CategoryDao;
import com.niit.dao.CategoryDaoImpl;
import com.niit.model.Category;
import com.niit.model.Supplier;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDao catdao;

	
	@RequestMapping("/Admin")
	public ModelAndView AdminHomeData()
	{
		return new ModelAndView("AdminHomePage");
	}
	
	
	
	@RequestMapping(value="/category",method = RequestMethod.GET)
	public ModelAndView showCat()
	{  
		String catjsonlist=catdao.listCategory();
		ModelAndView mv = new ModelAndView("AdminCategory","category",new Category());
	//	int id=supDAO.SortId();
		mv.addObject("data",catjsonlist);
		mv.addObject("check", true);
		//mv.addObject("supid",id);
		return mv;
	}
	
	@RequestMapping(value="/category",method= RequestMethod.POST)
	public ModelAndView addCategory(Category cat)
	{
		catdao.saveorupdate(cat);
		String catjsonlist = catdao.listCategory();
		ModelAndView mv = new ModelAndView("AdminCategory","category",new Category());
		mv.addObject("data",catjsonlist);
		mv.addObject("check",true);
		return mv;
	}
	
	@RequestMapping(value="/delcategory", method= RequestMethod.GET)
	public ModelAndView delCategory(@RequestParam("id") String id)
	{
		catdao.delete(id);
		String catjsonlist=catdao.listCategory();
		ModelAndView mv = new ModelAndView("AdminCategory","category",new Category());
		mv.addObject("check",true);
		mv.addObject("data",catjsonlist);
		return mv;
		
	}
	
	
	@RequestMapping(value="/UpdateCategory", method=RequestMethod.GET)
	public ModelAndView updatecatt(@RequestParam("id") String id)
	{ 
		Category cat = catdao.DispRecord(id);
		ModelAndView mv = new ModelAndView("AdminCategory","category",new Category());
		mv.addObject("check",false);
		return mv;
	}
	
	@RequestMapping(value="/UpdateCategory", method=RequestMethod.POST)
	public ModelAndView updateCat(Category c)
	{
		catdao.updateRecord(c);
		String catjsonlist=catdao.listCategory();
		ModelAndView mv = new ModelAndView("AdminCategory","category",new Category());
		mv.addObject("check",true);
		mv.addObject("data",catjsonlist);
		return mv;
	}
	
	
}
