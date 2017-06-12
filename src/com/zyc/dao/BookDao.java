package com.zyc.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;


public interface BookDao {
	/**
	 * 添加图书
	 * 
	 * @param book
	 * @throws SQLException 
	 */
	void addBook(Book book) throws SQLException;

	/**
	 * 删除图书
	 * 
	 * @param book
	 * @throws SQLException 
	 */
	void deleteBook(Integer book) throws SQLException;

	/**
	 * 修改图书信息
	 * 
	 * @param book
	 * @throws SQLException 
	 */
	void modifyBook(Book book) throws SQLException;

	/**
	 * 查找图书信息
	 * 
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	List<Book> findBook(Book book) throws SQLException;

	/**
	 * 
	 * @param bookid
	 * @return
	 * @throws SQLException 
	 */
	Book findBookById(Integer bookid) throws SQLException;
	/**
	 * 翻页查找
	 * @param book
	 * @param page
	 * @return
	 * @throws SQLException
	 */
	List<Book> findBookPage(Book book,Integer page) throws SQLException;
	/**
	 * 借书
	 * @param book
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void rentbook(Book book) throws SQLException, MyExcepton;
	/**
	 * 写入借书表
	 * @param book
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void writeRentBook(Customer customer,Book book) throws SQLException, MyExcepton;
	/**
	 * 还书
	 * @param book
	 * @throws SQLException
	 * @throws MyExcepton
	 */
	void returnBook(Book book) throws SQLException, MyExcepton;
	/**
	 * 写入还书表
	 * @param customer
	 * @param book
	 * @throws SQLException
	 * @throws MyExcepton
	 */
	void writeReturnBook(Customer customer,Book book,Integer rentid) throws SQLException, MyExcepton;
	/**
	 * 删除借书记录
	 * @param rentId
	 * @throws SQLException
	 */
	void deleteRentBook(Integer rentId) throws SQLException;
	/**
	 * 查看已借的书
	 * @param customer
	 * @return
	 * @throws SQLException 
	 */
	Object[][] findRentBook(Customer customer) throws SQLException;
	/**
	 * 查看已还的书
	 * @param customer
	 * @return
	 * @throws SQLException 
	 */
	Object[][] findReturnBook(Customer customer) throws SQLException;
	/**
	 * 关闭连接
	 */
	void closeConnect();
}
