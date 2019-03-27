package net.kzm.shopingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shopingBackend.dao.ProductDAO;
import net.kzm.shopingBackend.dto.Product;

public class ProductTestCase {
	private Product product;
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shopingBackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct()
	{
		product=new Product();
		product.setName("oppo A3s");
		product.setBrand("oppo");
		product.setDescription("this is new for oppo");
		product.setUnitPrice(2500);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		assertEquals("Something wrong when inserting a new Product",true,productDAO.add(product));
		
		//reading and upadating the category
		
		productDAO.get(1);
		product.setName("Lenovo");
		assertEquals("Something went wrong while updating the existing record",true,productDAO.update(product));
        
		assertEquals("Something went wrong while deleting the exitsting record",true,productDAO.delete(product));
	
		assertEquals("Something went worn while fetching  the list of product",15,productDAO.list().size());
	}
	
*/	
	@Test
	public void testListActiveProducts()
	{
		assertEquals("Something went worn while fetching  the list of product",9,productDAO.listActiveProducts().size());	
		
	}
	@Test
	public void testListActiveproductsByCategory()
	{
		assertEquals("Something went worn while fetching  the list of product",6,productDAO.listActiveProductsByCategory(3).size());	
		
	}
	@Test
	public void testgetLatestActiveProducts()
	{
		assertEquals("Something went worn while fetching  the list of product",9,productDAO.getLatestActiveProducts(9).size());	
		
	}

}
