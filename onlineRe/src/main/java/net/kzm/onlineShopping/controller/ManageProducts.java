package net.kzm.onlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.kzm.onlineShopping.util.FileUploadUtility;
import net.kzm.onlineShopping.validator.ProductValidator;
import net.kzm.shopingBackend.dao.CategoryDAO;
import net.kzm.shopingBackend.dao.ProductDAO;
import net.kzm.shopingBackend.dto.Category;
import net.kzm.shopingBackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManageProducts {
	
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name="operation",required=false)String operation)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message","Product Submitted Successfully!!!!");
				
			}
			else if(operation.equals("category")) {
				mv.addObject("message","Category Submitted Successfully!!!!");
			}
				
		}
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		//fetch the product from database
		Product nProduct=productDAO.get(id);
		
		
		mv.addObject("product",nProduct);
		
		
		return mv;
	}
	
	
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategory()
	{
	
		
		return categoryDAO.list();
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product")Product mProduct,BindingResult result,Model model,
			HttpServletRequest request)//HttpServlet for uploading image
	{
		//for checking uploadin image for validation purpose
		if(mProduct.getId()==0)
		{
		new ProductValidator().validate(mProduct,result);
		}
		else {
			if(mProduct.getFile().getOriginalFilename().equals("")) {
					new ProductValidator().validate(mProduct, result);
			}
		}
		//check if there is any Error
		if(result.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message", "validation failed for product submission");
			return "page";
		}
		
		if(mProduct.getId()==0) {
			//create a new Product if id==0
		productDAO.add(mProduct);
		}
		else {
			//update product if id is not equal to 0;
			productDAO.update(mProduct);
		}
		
		
		
		
		//for uploading image
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		
		product.setActive(!product.isActive());
		
		productDAO.update(product);
	
	return (isActive)? "you have succssfuly deactivated the Product with id"+product.getId():
		               "You have succssfuly activated the PRODUCT WITH ID"+product.getId();
	}
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		
		categoryDAO.add(category);
		
		
		return "redirect:/manage/products/?operation=category";
	} 
	
	 @ModelAttribute("category")
	 public Category getCategoryProd() {
		return new Category();
	 }


}
