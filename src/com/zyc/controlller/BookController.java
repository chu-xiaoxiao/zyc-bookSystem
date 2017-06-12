package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public interface BookController {
	/**
	 * 添加图书
	 * @throws SQLException 
	 */
	void addBook(Book book) throws SQLException;
	/**
	 * 修改图书
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyBook(Book book) throws SQLException, MyExcepton;
	/**
	 * 删除图书
	 * @throws SQLException 
	 */
	void deleteBook(Integer bookId) throws SQLException;
	/**
	 * 查询图书
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Book> findBook(Book book) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Book findByBookId(Integer bookid) throws SQLException, MyExcepton;
	/**
	 * 借书
	 * @param book
	 * @throws MyExcepton 
	 * @throws SQLException 
	 */
	void rentBook(Customer customer,Book book) throws SQLException, MyExcepton;
	/**
	 * 还书
	 * @param customer
	 * @param book
	 * @param rentid
	 * @throws MyExcepton 
	 * @throws SQLException 
	 */
	void returnbook(Customer customer,Book book,Integer rentid) throws SQLException, MyExcepton;
	/**
	 * 查看已借书
	 * @param customer
	 * @throws SQLException 
	 */
	Object[][] findRentBook(Customer customer) throws SQLException;
	/**
	 * 查看已还书
	 * @param customer
	 */
	Object[][]  findReturnBook(Customer customer)throws SQLException;
}
