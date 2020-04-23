package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.RovingFits.Model.Category;

@Repository("categorydao")
@Transactional
public class CategoryDAOImpl implements ICategoryDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addCategory(Category category) {

		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {

		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public ArrayList<Category> allCategory() {
		try {
			ArrayList<Category> categorylist = (ArrayList<Category>) sessionfactory.getCurrentSession()
					.createQuery("from category").list();// select * from category
			return categorylist;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Category oneCategory(String category_Name) {
		try {
			Category category = (Category) sessionfactory.getCurrentSession().createCriteria(Category.class)
					.add(Restrictions.eq("category_Name", category_Name)).uniqueResult();// select * from category where
																							// category_name=category_name;
			return category;
		} catch (Exception e) {
			return null;
		}

	}

}
