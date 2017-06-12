package com.zyc.test;


import java.sql.SQLException;

import org.junit.Test;

import com.zyc.controlller.CategoryController;
import com.zyc.controlller.CategoryControllerImplement;
import com.zyc.entity.Category;
import com.zyc.util.MyExcepton;

public class TestCategory {
	private CategoryController categoryController = new CategoryControllerImplement();
	@Test
	public void add(){
		try {
			categoryController.addCategory(new Category(null,"test"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void find(){
		try {
			System.out.println(categoryController.findCategory(new Category()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void delete(){
		try {
			categoryController.deleteCategory(4);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void up(){
		try {
			categoryController.modifyCategory(new Category(6, "更改"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MyExcepton e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
