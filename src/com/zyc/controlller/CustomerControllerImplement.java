package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Customer;
import com.zyc.service.CustomerService;
import com.zyc.service.CustomerServiceImplement;
import com.zyc.util.MyExcepton;

public class CustomerControllerImplement implements CustomerController{
	private CustomerService customerService = new CustomerServiceImplement();

	@Override
	public void addCustomer(Customer customer) throws SQLException {
		customerService.addCustomer(customer);
	}

	@Override
	public void modifyCustomer(Customer customer) throws SQLException, MyExcepton {
		customerService.modifyCustomer(customer);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws SQLException, MyExcepton {
		customerService.deleteCustomer(customerId);
	}

	@Override
	public List<Customer> findCustomer(Customer customer) throws SQLException, MyExcepton {
		System.out.println(customerService.findCustomer(customer));
		return null;
	}

	@Override
	public Customer findByCustomerId(Integer customerId) throws SQLException, MyExcepton {
		System.out.println(customerService.findByCustomerId(customerId));
		return null;
	}

	@Override
	public Customer logIn(Customer customer) throws SQLException, MyExcepton {
		return customerService.logIn(customer);
		
	}

}
