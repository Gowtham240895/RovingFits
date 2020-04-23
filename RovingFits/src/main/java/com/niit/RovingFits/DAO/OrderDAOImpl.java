package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.Order;

@Repository("orderdao")
@Transactional
public class OrderDAOImpl implements IOrderDAO {

	@Autowired

	SessionFactory sessionfactory;

	@Override
	public boolean addOrder(Order Order) {
		try {
			sessionfactory.getCurrentSession().save(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateOrder(Order Order) {
		try {
			sessionfactory.getCurrentSession().update(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteOrder(Order Order) {
		try {
			sessionfactory.getCurrentSession().delete(Order);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Order> allOrder(Customer customer) {
		try {
			ArrayList<Order> orderlist = (ArrayList<Order>) sessionfactory.getCurrentSession()
					.createCriteria(Order.class).add(Restrictions.eq("cust_Details", customer)).list();
			return orderlist;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Order oneOrder(String order_Id) {
		try {
			Order order = (Order) sessionfactory.getCurrentSession().createCriteria(Order.class)
					.add(Restrictions.eq("order_Id", order_Id)).uniqueResult();
			return order;
		} catch (Exception e) {
			return null;
		}
	}

}
