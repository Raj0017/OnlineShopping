package net.kzm.shopingBackend.daoimpl;

//import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shopingBackend.dao.CategoryDAO;
import net.kzm.shopingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
/*	private static List<Category> categories=new ArrayList<>();
	
	static {
		Category category=new Category();
		First Category of Product
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is new Televison of India");
		category.setImageUrl("im.png");
		
		categories.add(category);
		
		Second Category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is new MObile of India");
		category.setImageUrl("im_1.png");
		categories.add(category);
		
		Third Product
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is new Laptop of India");
		category.setImageUrl("im_2.png");
		categories.add(category);
		
		fourth Product
		category=new Category();
		category.setId(4);
		category.setName("Radio");
		category.setDescription("This is new Radio of India");
		category.setImageUrl("im_4.png");
		categories.add(category);
	}*/


	
	

	/*@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		
		return null;
	}*/
	
	@Override
	public List<Category> list() {

           String selectActive="from Category where active= :active";
           Query query=sessionFactory.getCurrentSession().createQuery(selectActive);
           query.setParameter("active",true);
		return query.getResultList();
	}
	
	
	/*Getting single category based on ID*/
	@Override
	public Category get(int id) {
		
		
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	//@Transactional(noRollbackFor = Exception.class)
	public boolean add(Category category) {
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
		
		}
	
		
		
		

	

	@Override
	public boolean update(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
	
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			
			return false;
		}
	}


	
  
  
}
