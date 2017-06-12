package com.zyc.test;


import java.sql.SQLException;

import org.junit.Test;

import com.zyc.controlller.ActhorControllerImplememt;
import com.zyc.controlller.ActhorController;
import com.zyc.controlller.BookController;
import com.zyc.controlller.BookControllerImplement;
import com.zyc.controlller.CategoryController;
import com.zyc.controlller.CategoryControllerImplement;
import com.zyc.controlller.CustomerControllerImplement;
import com.zyc.controlller.PublishControllerImplement;
import com.zyc.controlller.PublishControlller;
import com.zyc.entity.Book;
import com.zyc.entity.Customer;
import com.zyc.util.MyExcepton;

public class TestBook {
	private BookController bookController = new BookControllerImplement();
	ActhorController acthorController = new ActhorControllerImplememt();
	CategoryController categoryController = new CategoryControllerImplement();
	PublishControlller publishController= new PublishControllerImplement();
	@Test
	public void add(){
		try {
			bookController.addBook(new Book(null, "最后测试", acthorController.findByActhorId(3), categoryController.findByCategoryId(5), publishController.findByPublishId(4), null, null));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void find(){
		try {
			System.out.println(bookController.findBook(new Book()));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		try {
			bookController.deleteBook(6);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void up(){
		try {
			Book book = bookController.findByBookId(4);
			book.setBookName("修改之后");
			bookController.modifyBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void rent(){
		try {
			new BookControllerImplement().returnbook(new CustomerControllerImplement().logIn(new Customer("123","123")), bookController.findByBookId(34) ,18);
		} catch (SQLException | MyExcepton e) {
			e.printStackTrace();
		}
	}
}
