package net.kzm.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.shopingBackend.dao.CategoryDAO;
import net.kzm.shopingBackend.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDao;
	
	
	
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		//mv.addObject("greeting","Welcome to spring MVC RajMohan");
		mv.addObject("title","Home");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickHome",true);
		
		return mv;
		
		
	}
	@RequestMapping(value= {"/about"})
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		//mv.addObject("greeting","Welcome to spring MVC RajMohan");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
		
		
	}
	@RequestMapping(value= {"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDao.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		//categoryDao to fetch   a single category
		Category category=null;
		category=categoryDao.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of category
		mv.addObject("categories",categoryDao.list());
		
		//passing the Single category object
		mv.addObject("category",category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
	}
}
