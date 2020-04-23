package com.niit.RovingFits.DAO;

import java.util.ArrayList;

import com.niit.RovingFits.Model.Customer;
import com.niit.RovingFits.Model.Order;

public interface IOrderDAO {

	public boolean addOrder(Order Order);

	public boolean updateOrder(Order Order);

	public boolean deleteOrder(Order Order);

	public ArrayList<Order> allOrder(Customer customer_crt_Email);

	public Order oneOrder(String order_Id);

}
