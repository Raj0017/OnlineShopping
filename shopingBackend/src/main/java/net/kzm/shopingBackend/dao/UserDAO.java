package net.kzm.shopingBackend.dao;


import java.util.List;

import net.kzm.shopingBackend.dto.Address;
import net.kzm.shopingBackend.dto.Cart;
import net.kzm.shopingBackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	boolean addAddress(Address address);
	
	Address getBilingAddress(User user);
	
	 List<Address> listShipingAddress(User user);	
	
	boolean updateCart(Cart cart);
	
	User getByEmail(String email);
	
	

}
