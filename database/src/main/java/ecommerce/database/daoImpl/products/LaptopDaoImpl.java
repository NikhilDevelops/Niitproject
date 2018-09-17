package ecommerce.database.daoImpl.products;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.products.LaptopDaoService;
import ecommerce.database.model.products.Laptop;

@Component
@Transactional
public class LaptopDaoImpl implements LaptopDaoService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean deleteLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(laptop);
			return true;			
		} catch (HibernateException e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Laptop retrieveLaptopById(long productId) {
		// TODO Auto-generated method stub
		
		try {
			
		return	(Laptop)sessionFactory.getCurrentSession().createQuery("from Laptop where productId=:id").setParameter("id", productId).getSingleResult();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
		
				
	}

	@Override
	public List<Laptop> getAllLaptops() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createCriteria(Laptop.class).list();
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}
	}

}
