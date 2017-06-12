package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public interface CustomerController {
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	void addCustomer(Customer customer) throws SQLException;
	/**
	 * 修改用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyCustomer(Customer customer) throws SQLException, MyExcepton;
	/**
	 * 删除用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void deleteCustomer(Integer customerId) throws SQLException, MyExcepton;
	/**
	 * 查询用户
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Customer> findCustomer(Customer customer) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Customer findByCustomerId(Integer customerId) throws SQLException, MyExcepton;
	/**
	 * 登陆
	 * @param customer
	 * @return
	 * @throws MyExcepton 
	 * @throws SQLException 
	 */
	Customer logIn(Customer customer) throws SQLException, MyExcepton;
}
