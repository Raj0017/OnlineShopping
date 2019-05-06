package net.kzm.onlineShopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobabDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","The Page is not Constructed!!!!!");
		mv.addObject("errorDescription","The Page you are looking for is not available now! ");
		mv.addObject("title","404 Error page");
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product not avialabe right now!!!!!");
		mv.addObject("errorDescription","Product................ for is not available now! ");
		mv.addObject("title","product not unavilabe");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","contact your Administration !!!!!");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","Error");
		return mv;
	}
	
	

}
