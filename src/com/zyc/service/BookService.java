package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public interface BookService {
	/**
	 * 添加图书
	 * @throws SQLException 
	 */
	void addBook(Book book) throws SQLException;
	/**
	 * 删除图书
	 * @throws SQLException 
	 */
	void deleteBook(Integer bookid) throws SQLException;
	/**
	 * 修改图书
	 * @throws SQLException 
	 */
	void modifyBook(Book book) throws SQLException;
	/**
	 * 查找图书
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Book> findBook(Book book) throws SQLException, MyExcepton;
	/**
	 * 精确查找book
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Book findBookById(Integer bookid) throws SQLException, MyExcepton;
	/**
	 * 借书
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void rentBook(Customer customer,Book book) throws SQLException, MyExcepton;
	/**
	 * 还书
	 * @param customer
	 * @param book
	 * @throws MyExcepton 
	 * @throws SQLException 
	 */
	void returnBook(Customer customer,Book book,Integer rentid) throws SQLException, MyExcepton;
	/**
	 * 查看已借书
	 * @param customer
	 * @return
	 * @throws SQLException 
	 */
	Object[][]  findRentBook(Customer customer) throws SQLException;
	/**
	 * 查看已还书
	 * @param customer
	 * @return
	 * @throws SQLException 
	 */
	Object[][] findReturnBook(Customer customer) throws SQLException;
}
