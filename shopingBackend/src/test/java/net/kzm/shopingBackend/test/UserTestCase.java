/*package net.kzm.shopingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shopingBackend.dao.UserDAO;
import net.kzm.shopingBackend.dto.Address;
import net.kzm.shopingBackend.dto.Cart;
import net.kzm.shopingBackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;

	 
	private static UserDAO userDAO;

	private User user=null;
	private Address address=null;
	private Cart cart=null;

	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shopingBackend");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	
	   
		
	}
	
	@Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("Raj Mohan");
		user.setLastName("Pandey");
		user.setEmail("rajpandey0017@gmail.com");
		user.setContactNumber("9005495984");
		user.setRole("Admin");
		user.setPassword("pandey");
		
		assertEquals("failed to add user",true,userDAO.addUser(user));
	
		address=new Address();
		address.setAddressLineOne("101/B near chipiyana phatak colony");
		address.setAddressLineTwo("near Lal kuan");
		address.setCity("Ghazibad");
		address.setState("Uttar Pradesh");
		address.setCountry("India");
		address.setPostalCode("221503");
		address.setBilling(true);
		
		address.setUserId(user.getId());
		
		assertEquals("failed to add Address",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("Admin")) {
			
			cart=new Cart();
			cart.setUser(user);
			
			assertEquals("failedto add cart",true,userDAO.addCart(cart));
			
			
		}
		 
		
	}
	
    @Test
	public void testAdd()
	{
		user=new User();
		user.setFirstName("Raj Mohan");
		user.setLastName("Pandey");
		user.setEmail("rajpandey0017@gmail.com");
		user.setContactNumber("9005495984");
		user.setRole("Admin");
		user.setPassword("pandey");
		
		
	
		if(user.getRole().equals("Admin")) {
			
			cart=new Cart();
			cart.setUser(user);
			
			user.setCart(cart);
			
			
		}
		assertEquals("failed to add user",true,userDAO.addUser(user));
	}
   
	@Test
    public void testUpdateCart()
    {
    	user=userDAO.getByEmail("rajpandey0017@gmail.com");
    	
    	
    	 cart=user.getCart();
    	cart.setCartLine(2);
    	cart.setGrandTotal(879878);
    	assertEquals("failed to add cart",true, userDAO.updateCart(cart));
    	
    }
	
	
	@Test 
	public void testAddAddress()
	{
		//add user
		user=new User();
		user.setFirstName("Raj Mohan");
		user.setLastName("Pandey");
		user.setEmail("rajpandey0017@gmail.com");
		user.setContactNumber("9005495984");
		user.setRole("Admin");
		user.setPassword("pandey");
		
		assertEquals("failed to add user",true,userDAO.addUser(user));
		
		//add address for billing
		
		address=new Address();
		address.setAddressLineOne("101/B near chipiyana phatak colony");
		address.setAddressLineTwo("near Lal kuan");
		address.setCity("Ghazibad");
		address.setState("Uttar Pradesh");
		address.setCountry("India");
		address.setPostalCode("221503");
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("failed to add Address",true,userDAO.addAddress(address));
		
	//add address for shipping
		
		address=new Address();
		address.setAddressLineOne("allahabad 56 new yy oy");
		address.setAddressLineTwo("near allahabad");
		address.setCity("Allahabad");
		address.setState("Prayagraj");
		address.setCountry("India");
		address.setPostalCode("228879");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("failed to add Address",true,userDAO.addAddress(address));
		
	}
	
	@Test 
	public void testAddAddress()
	{
		//add user
		
		//add address for shipping
		user=userDAO.getByEmail("rajpandey0017@gmail.com");
		
		address=new Address();
		address.setAddressLineOne("barot");
		address.setAddressLineTwo("Tela");
		address.setCity("Handia");
		address.setState("Prayagraj");
		address.setCountry("India");
		address.setPostalCode("228879");
		address.setShipping(true);
		
		address.setUser(user);
		
		assertEquals("failed to add Address",true,userDAO.addAddress(address));
		
	}

@Test
	public void testGetAddress()
	{
		user=userDAO.getByEmail("rajpandey0017@gmail.com");
		assertEquals("failed to add Address",2,userDAO.listShipingAddress(user).size());
		
		assertEquals("failed to add Address",1,userDAO.getBilingAddress(user));
		
		
	}
	

	
	
	
	
	
	
}
*/