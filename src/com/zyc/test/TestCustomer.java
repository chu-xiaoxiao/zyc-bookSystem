package com.zyc.test;

import java.sql.SQLException;

import org.junit.Test;

import com.zyc.controlller.CustomerController;
import com.zyc.controlller.CustomerControllerImplement;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public class TestCustomer {
	private CustomerController customerController = new CustomerControllerImplement();
	@Test
	public void addCustomer(){
		try {
			customerController.addCustomer(new Customer(null,"ceshiyonghu","123456","1"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void findCustomer(){
		try {
			Customer customer = new Customer();
			customerController.findCustomer(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			e.printStackTrace();
		}
	}
	@Test
	public void logIn(){
		try {
			System.out.println(customerController.logIn(new Customer("123","123")));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			e.printStackTrace();
		}
	}
	@Test
	public void UP(){
		try {
			customerController.modifyCustomer(new Customer(2,"测试用户","1234567","2"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			e.printStackTrace();
		}
	}
	@Test
	public void findId(){
		try {
			customerController.findByCustomerId(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		try {
			customerController.deleteCustomer(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
