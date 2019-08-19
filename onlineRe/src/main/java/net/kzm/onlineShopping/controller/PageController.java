package net.kzm.onlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.onlineShopping.exception.ProductNotFoundException;
import net.kzm.shopingBackend.dao.CategoryDAO;
import net.kzm.shopingBackend.dao.ProductDAO;
import net.kzm.shopingBackend.dto.Category;
import net.kzm.shopingBackend.dto.Product;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private ProductDAO productDAO;
	
	//login 
	
	@RequestMapping(value= {"/login"})
	public ModelAndView login(@RequestParam(name="error", required=false)String error)
	{
		ModelAndView mv=new ModelAndView("login");
		
		if(error!=null) {
			mv.addObject("message","invalid username and password");
		}
		//mv.addObject("greeting","Welcome to spring MVC RajMohan");
		mv.addObject("title","Login");
		
		
		
		return mv;
		
		
	}
	
	
	
	
	
	
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
		mv.addObject("title","AboutUs");
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
	@ResponseBody
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
	
	
	//Single product viewing
	@RequestMapping(value= {"/show/{id}/product"})
	public ModelAndView singleProduct(@PathVariable("id") int id)throws ProductNotFoundException{
		ModelAndView mv=new ModelAndView("page");
		Product product=productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		mv.addObject("userClickShowProduct",true);
		return mv;
	}
	
	
	@RequestMapping(value= {"/register"})
	public ModelAndView register() {
		ModelAndView mv=new ModelAndView("page");
	
		mv.addObject("title","Register User");


		return mv;
	}
	

	}
