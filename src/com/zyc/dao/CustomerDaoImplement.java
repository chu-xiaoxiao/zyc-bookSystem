package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.zyc.entity.Acthor;
import com.zyc.entity.Customer;
import com.zyc.util.DButil;

public class CustomerDaoImplement implements CustomerDao {
	private Connection connection;
	
	/**
	 * @param connection
	 */
	public CustomerDaoImplement(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 */
	public CustomerDaoImplement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCustomer(Customer customer) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "INSERT INTO customer (CUSTOMERID,CUSTOMERNAME,CUSTOMERPSSWORD,CUNSTOMERGROY) values(seqcustomer.nextval,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setString(2, customer.getCustomerPassword());
		preparedStatement.setString(3	, customer.getCustomerGroy());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("用户添加成功");
			DButil.commit(connection);
		}else{
			System.out.println("用户添加失败");
			DButil.rooback(connection);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		DButil.closeTranscation(connection);
	}

	@Override
	public void deleteCustomer(Integer customerId) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "DELETE customer WHERE customerid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, customerId);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("删除用户成功");
			DButil.commit(connection);
		}else{
			System.out.println("用户删除失败");
			DButil.rooback(connection);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		DButil.closeTranscation(connection);
	}

	@Override
	public List<Customer> findCustomer(Customer customer) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT CUSTOMERID,CUSTOMERNAME,CUSTOMERPSSWORD,CUNSTOMERGROY FROM customer WHERE 1=1  ");
		if(customer.getCustomerName()!=null){
			sql.append(" AND CUSTOMERNAME = '" + customer.getCustomerName()+"'");
		}
		if(customer.getCustomerPassword()!=null){
			sql.append(" AND CUSTOMERPSSWORD ='"+ customer.getCustomerPassword()+"'");
		}
		if(customer.getCustomerGroy()!=null){
			sql.append("AND CUNSTOMERGROY ='"+customer.getCustomerGroy()+"'");
		}
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Customer> customers = new ArrayList<Customer>();
		while(resultSet.next()){
			customers.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
		}
		return customers;
	}

	@Override
	public Customer findCustomerById(Integer customerId) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT CUSTOMERID,CUSTOMERNAME,CUSTOMERPSSWORD,CUNSTOMERGROY FROM customer WHERE  CUSTOMERID= ? ");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, customerId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			return new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
		}
		return null;
	}

	@Override
	public void modifyCustomer(Customer customer) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "UPDATE customer SET CUSTOMERNAME= ?,CUSTOMERPSSWORD =?, CUNSTOMERGROY=? WHERE CUSTOMERID =?";
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1, ""+customer.getCustomerName()+"");
		preparedStatement.setString(2, ""+customer.getCustomerPassword()+"");
		preparedStatement.setString(3, ""+customer.getCustomerGroy()+"");
		preparedStatement.setInt(4, customer.getCustomerId());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("修改成功");
			DButil.commit(connection);
		}else{
			System.out.println("修改失败");
			DButil.rooback(connection);
		}
	}

	@Override
	public void closeConnect() throws SQLException {
		DButil.closeConnection(connection);
	}

	@Override
	public Customer logIn(Customer customer) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT CUSTOMERID,CUSTOMERNAME,CUSTOMERPSSWORD,CUNSTOMERGROY FROM customer WHERE CUSTOMERNAME = ? AND CUSTOMERPSSWORD = ? ");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setString(1, customer.getCustomerName());
		preparedStatement.setString(2, customer.getCustomerPassword());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
		return new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
		}
		return null;
	}
}
