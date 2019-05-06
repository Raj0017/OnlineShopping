package net.kzm.shopingBackend.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shopingBackend.dao.UserDAO;
import net.kzm.shopingBackend.dto.Address;
import net.kzm.shopingBackend.dto.Cart;
import net.kzm.shopingBackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {

           sessionFactory.getCurrentSession().persist(user);
		return true;
	}

	@Override
	public boolean addAddress(Address address) {
		
		sessionFactory.getCurrentSession().persist(address);
		return true;
	}

	@Override
	public boolean updateCart(Cart cart) {
		sessionFactory.getCurrentSession().update(cart);
		return true;
	}

	@Override
	public User getByEmail(String email) {
   
		  String selectQuery="from User where email =:email";
		  try {
			  
			 return sessionFactory.getCurrentSession().createQuery(selectQuery,User.class)
			  .setParameter("email",email).getSingleResult();
			  
		  }catch(Exception ex) {
			  ex.printStackTrace();
			  return null;
			  
		  }

		
		
		
	}

	@Override
	public Address getBilingAddress(User user) {
		String selectQ="from Address where user=:user and billing=:billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQ,Address.class)
					.setParameter("user",user).setParameter("biling",true).getSingleResult();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Address> listShipingAddress(User user) {
		String selectQ="from Address where user=:user and shipping=:shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQ,Address.class)
					.setParameter("user",user).setParameter("shipping",true).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
		
	}

}
