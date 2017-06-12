package com.zyc.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Customer;


public interface CustomerDao {
	/**
	 * 添加用户
	 * @throws SQLException 
	 */
	void addCustomer(Customer Customer) throws SQLException;
	/**
	 * 删除用户
	 */
	void deleteCustomer(Integer CustomerId) throws SQLException;
	/**
	 * 查询用户
	 * @throws SQLException 
	 */
	List<Customer> findCustomer(Customer Customer ) throws SQLException;
	/**
	 * 精确查找
	 * @throws SQLException 
	 */
	Customer findCustomerById(Integer CustomerId) throws SQLException;
	/**
	 * 改变用户信息
	 * @throws SQLException 
	 */
	void modifyCustomer(Customer Customer) throws SQLException;
	/**
	 *关闭连接
	 * @throws SQLException 
	 */
	void closeConnect() throws SQLException; 
	/**
	 * 登陆
	 * @throws SQLException 
	 */
	Customer logIn(Customer customer) throws SQLException;
}
