package net.kzm.onlineShopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.kzm.onlineShopping.model.RegisterModel;
import net.kzm.shopingBackend.dao.UserDAO;
import net.kzm.shopingBackend.dto.Address;
import net.kzm.shopingBackend.dto.Cart;
import net.kzm.shopingBackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		
		
		return new RegisterModel();
	}

	
	public void addUser(RegisterModel registerModel, User user) {
		
		registerModel.setUser(user);
	}
	
	//checking password matching confirm
	public String validateUser(User user,MessageContext error) {
		
		String transitionValue="success";
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			
			error.addMessage(new MessageBuilder().error().source("confirmPassword")
			.defaultText("password does not match confirm password!!").build());
			transitionValue="failure";
		}
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("Email address is already taken!!").build());
			
			
			transitionValue="failure";
		}
		
		return transitionValue;
	}
	
	//checking uniqueness of email
	
	
	
	public void addBilling(RegisterModel registerModel, Address billing)
	{
		registerModel.setBilling(billing);
	}
	public String saveAll(RegisterModel model) {
		String transitionValue="success";
		User user=model.getUser();
		if(user.getRole().equals("USER"))
		{
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		//adding the user
		userDAO.addUser(user);
		
		//get the Address
		Address billing=model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		//save the address
		
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
}
