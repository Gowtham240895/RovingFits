package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.RovingFits.Model.Category;
import com.niit.RovingFits.Model.Product;

@Repository("productdao")
@Transactional
public class ProductDAOImpl implements IProductDAO {

	@Autowired

	SessionFactory sessionfactory;

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionfactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Product> allProduct() {
		try {
			ArrayList<Product> productlist = (ArrayList<Product>) sessionfactory.getCurrentSession()
					.createQuery("" + "from Product").list();
			return productlist;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Product oneProduct(int product_Id) {
		try {
			Product product = (Product) sessionfactory.getCurrentSession().createCriteria(Product.class)
					.add(Restrictions.eq("Product", product_Id)).uniqueResult();
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<Product> allProductByCategory(Category category) {
		try {

			ArrayList<Product> productlist = (ArrayList<Product>) sessionfactory.getCurrentSession()
					.createCriteria(Product.class).add(Restrictions.eq("product_Category", category)).uniqueResult();
			return productlist;
		} catch (Exception e) {
			return null;
		}
	}
}
