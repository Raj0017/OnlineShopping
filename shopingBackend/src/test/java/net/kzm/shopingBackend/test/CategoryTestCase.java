package net.kzm.shopingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shopingBackend.dao.CategoryDAO;
import net.kzm.shopingBackend.dto.Category;


public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;

	 
	private static CategoryDAO categoryDAO;

	private Category category;

	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shopingBackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	
	   
		
	}
	
	/*@Test
	public void testAddCategory()
	{
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is new Laptop of India");
		category.setImageUrl("im_7.png");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		 
	}*/
	/*@Test
	public void testGetCategory()
	{
		category=categoryDAO.get(2);
		assertEquals("Successfully fatched a category from  the table","Laptop",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory()
	{
		category=categoryDAO.get(2);
		category.setName("Lape");
		assertEquals("Successfully update a category from the table",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(2);
		assertEquals("Successfully deleted a category from the table",true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void testListCategory()
	{
		
		assertEquals("Successfully fetched a category from the table",1,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUDCategory()
	{
		 //add operation of categories
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is new Laptop of India");
		category.setImageUrl("im_7.png");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	  
		category=new Category();
		category.setName("Telivision");
		category.setDescription("This is new Telivision of India");
		category.setImageUrl("im_8.png");
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
	
		//fetching and update category
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Successfully update a category from the table",true,categoryDAO.update(category));
		
		//deleting category
		
		assertEquals("Successfully deleted a category from the table",true,categoryDAO.delete(category));
		//return a LIST
		
		assertEquals("Successfully fetched a category from the table",1,categoryDAO.list().size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
