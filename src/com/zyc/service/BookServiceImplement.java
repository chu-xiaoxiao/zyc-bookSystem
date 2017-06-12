package com.zyc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.dao.BookDao;
import com.zyc.dao.BookDaoImplelemt;
import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;

public class BookServiceImplement implements BookService{
	private BookDao bookDao = new BookDaoImplelemt(DButil.getConnect());
	@Override
	public void addBook(Book book) throws SQLException {
		bookDao.addBook(book);
		bookDao.closeConnect();
	}

	@Override
	public void deleteBook(Integer bookid) throws SQLException {
		bookDao.deleteBook(bookid);
		bookDao.closeConnect();
	}

	@Override
	public void modifyBook(Book book) throws SQLException {
		bookDao.findBook(book);
		bookDao.modifyBook(book);
		bookDao.closeConnect();
	}

	@Override
	public List<Book> findBook(Book book) throws SQLException, MyExcepton {
		List<Book> lists = bookDao.findBook(book);
		if(lists==null||lists.isEmpty()){
			throw new MyExcepton("未找找到相关书籍资料");
 		}
		bookDao.closeConnect();
		return lists;
	}

	@Override
	public Book findBookById(Integer bookid) throws SQLException, MyExcepton {
		Book book = bookDao.findBookById(bookid);
		if(book==null){
			throw new MyExcepton("未找到书籍信息");
		}
		bookDao.closeConnect();
		return book;
	}

	@Override
	public void rentBook(Customer customer,Book book) throws SQLException, MyExcepton {
		bookDao.findBookById(book.getBookid());
		bookDao.rentbook(book);
		bookDao.writeRentBook(customer, book);
		bookDao.closeConnect();
	}

	@Override
	public void returnBook(Customer customer, Book book,Integer rentid) throws SQLException, MyExcepton {
		bookDao.returnBook(book);
		bookDao.writeReturnBook(customer, book,rentid);
		bookDao.deleteRentBook(rentid);
		bookDao.closeConnect();
	}

	@Override
	public Object[][] findRentBook(Customer customer) throws SQLException {
		Object[][] objects = bookDao.findRentBook(customer);
		bookDao.closeConnect();
		return objects;
	}

	@Override
	public Object[][] findReturnBook(Customer customer) throws SQLException {
		Object[][] books = bookDao.findReturnBook(customer);
		bookDao.closeConnect();
		return books;
	}
	
}
