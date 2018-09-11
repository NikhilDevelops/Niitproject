package ecommerce.database.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ecommerce.database.dao.SubCategoryDaoService;
import ecommerce.database.model.SubCategory;


@Component
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDaoService{

	    @Autowired
		private SessionFactory sessionFactory;
	
	@Override
	public SubCategory getSubCategory(int subcategory_Id) {
		// TODO Auto-generated method stub
		try {
			
		return	sessionFactory.getCurrentSession().get(SubCategory.class,subcategory_Id);
			
			
		} catch (HibernateException e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public List<SubCategory> getAllSubcategories() {
		// TODO Auto-generated method stub
		try {
			
			return	sessionFactory.getCurrentSession().createCriteria(SubCategory.class).list();
				
				
			} catch (HibernateException e) {
				// TODO: handle exception
				return null;
			}

	}

}
