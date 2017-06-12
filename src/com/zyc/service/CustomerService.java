package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public interface CustomerService {
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	void addCustomer(Customer customer) throws SQLException;
	/**
	 * 查询用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Customer> findCustomer(Customer customer) throws SQLException, MyExcepton;
	/**
	 * 删除用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void deleteCustomer(Integer customerid) throws SQLException, MyExcepton;
	/**
	 * 修改用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyCustomer(Customer customerid) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Customer findByCustomerId(Integer customerid) throws SQLException, MyExcepton;
	/**
	 * 登陆
	 * @param customer
	 * @return
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Customer logIn(Customer customer) throws SQLException, MyExcepton;
}
