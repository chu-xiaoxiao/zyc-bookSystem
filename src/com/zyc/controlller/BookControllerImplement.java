package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.service.BookService;
import com.zyc.service.BookServiceImplement;
import com.zyc.util.MyExcepton;

public class BookControllerImplement implements BookController{
	BookService BookService = new BookServiceImplement();
	@Override
	public void addBook(Book book) throws SQLException {
		BookService.addBook(book);
	}

	@Override
	public void modifyBook(Book book) throws SQLException, MyExcepton {
		BookService.modifyBook(book);
	}

	@Override
	public void deleteBook(Integer bookId) throws SQLException {
		BookService.deleteBook(bookId);
	}

	@Override
	public List<Book> findBook(Book book) throws SQLException, MyExcepton {
		return BookService.findBook(book);
	}

	@Override
	public Book findByBookId(Integer bookid) throws SQLException, MyExcepton {
		return BookService.findBookById(bookid);
	}

	@Override
	public void rentBook(Customer customer,Book book) throws SQLException, MyExcepton {
		BookService.rentBook(customer, book);
	}

	@Override
	public void returnbook(Customer customer, Book book, Integer rentid) throws SQLException, MyExcepton {
		BookService.returnBook(customer, book, rentid);
	}

	@Override
	public Object[][] findRentBook(Customer customer) throws SQLException {
		return BookService.findRentBook(customer);
	}

	@Override
	public Object[][] findReturnBook(Customer customer) throws SQLException {
		return BookService.findReturnBook(customer);
	}

}
