package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.dao.CustomerDao;
import com.zyc.dao.CustomerDaoImplement;
import com.zyc.entity.Customer;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;

public class CustomerServiceImplement implements CustomerService{
	private CustomerDao customerDao = new CustomerDaoImplement(DButil.getConnect());
	
	@Override
	public void addCustomer(Customer customer) throws SQLException {
		customerDao.addCustomer(customer);
		customerDao.closeConnect();
	}
	

	@Override
	public List<Customer> findCustomer(Customer customer) throws SQLException, MyExcepton {
		List<Customer> customers = customerDao.findCustomer(customer);
		if(customers==null||customers.isEmpty()){
			System.out.println("找不到用户");
			throw new MyExcepton("找不到用户");
		}
		customerDao.closeConnect();
		return customers;
	}

	@Override
	public void deleteCustomer(Integer customerid) throws SQLException, MyExcepton {
		Customer temp = customerDao.findCustomerById(customerid);
		if(temp == null){
			System.out.println("找不到要删除的用户");
			throw new MyExcepton("找不到要删除的用户");
		}else{
			customerDao.deleteCustomer(customerid);
		}
		customerDao.closeConnect();
	}

	@Override
	public void modifyCustomer(Customer customer) throws SQLException, MyExcepton {
		Customer temp = customerDao.findCustomerById(customer.getCustomerId());
		if(temp == null){
			System.out.println("找不到要修改的用户");
			throw new MyExcepton("找不到要修改的用户");
		}else{
			customerDao.modifyCustomer(customer);
		} 
		customerDao.closeConnect();
		
	}

	@Override
	public Customer findByCustomerId(Integer categoryid) throws SQLException, MyExcepton {
		Customer temp = customerDao.findCustomerById(categoryid);
		if(temp == null){
			System.out.println("找不到对应用户");
			throw new MyExcepton("找不到对应用户");
		}
		return temp;
	}

	@Override
	public Customer logIn(Customer customer) throws SQLException, MyExcepton {
		Customer temp = customerDao.logIn(customer);
		if(temp == null){
			System.out.println("用户名或密码错误");
			throw new MyExcepton("用户名或密码错误");
		}
		return temp;
	}
	
}
