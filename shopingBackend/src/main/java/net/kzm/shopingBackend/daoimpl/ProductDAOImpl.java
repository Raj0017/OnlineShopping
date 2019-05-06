package net.kzm.shopingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shopingBackend.dao.ProductDAO;
import net.kzm.shopingBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		// TODO Auto-generated method stub
		try {
		
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId))  ;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
		 sessionFactory.getCurrentSession().persist(product); 
		 return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Product product) {
            try
            {
            	product.setActive(false);
            	return this.update(product);
            	
            }catch(Exception ex)
            {
            	ex.printStackTrace();
            }
    	return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		try {
		String selectActiveProducts="from Product where active=:active";
         return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class)
        		 .setParameter("active", true)
        		 .getResultList();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
		
	
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory="from Product where active=:active and categoryId=:categoryId";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory,Product.class)
				.setParameter("active",true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession().createQuery("from Product where active=:active order by Id",Product.class)
				.setParameter("active",true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
