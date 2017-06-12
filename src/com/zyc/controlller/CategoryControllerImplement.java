package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Category;
import com.zyc.service.CategoryService;
import com.zyc.service.CategoryServiceImplement;
import com.zyc.util.MyExcepton;

public class CategoryControllerImplement implements CategoryController {
	CategoryService categoryService = new CategoryServiceImplement();
	@Override
	public void addCategory(Category category) throws SQLException {
		categoryService.addCategory(category);
	}

	@Override
	public void modifyCategory(Category category) throws SQLException, MyExcepton {
		categoryService.modifyCategory(category);
	}

	@Override
	public void deleteCategory(Integer categoryId) throws SQLException {
		categoryService.deleteCategory(categoryId);
	}

	@Override
	public List<Category> findCategory(Category ctegory) throws SQLException {
		return categoryService.findCategory(ctegory);
	}

	@Override
	public Category findByCategoryId(Integer categoryid) throws SQLException, MyExcepton {
		return categoryService.findByCategoryId(categoryid);
	}
	
}
