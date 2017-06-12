package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.dao.CategoryDao;
import com.zyc.dao.CategoryDaoImplement;
import com.zyc.entity.Category;
import com.zyc.util.DButil;
import com.zyc.util.MyExcepton;

public class CategoryServiceImplement implements CategoryService {
	private CategoryDao categoryDao = new CategoryDaoImplement(DButil.getConnect());
	
	@Override
	public void addCategory(Category category) throws SQLException {
		categoryDao.addCategroy(category);
		categoryDao.closeConnect();
	}

	@Override
	public List<Category> findCategory(Category category) throws SQLException {
		List<Category> lists = categoryDao.findCategory(category);
		if(lists==null||lists.isEmpty()){
			System.out.println("未找到相关类别资料");
		}
		categoryDao.closeConnect();
		return lists;
	}

	@Override
	public void deleteCategory(Integer categoryid) throws SQLException {
		categoryDao.deleteCategroy(categoryid);
		categoryDao.closeConnect();
	}

	@Override
	public void modifyCategory(Category category) throws SQLException, MyExcepton {
		if(categoryDao.findCategoryById(category.getCategoryId())==null)
		categoryDao.modifyCategory(category);
		categoryDao.closeConnect();
	}

	@Override
	public Category findByCategoryId(Integer categoryid) throws SQLException, MyExcepton {
		Category category = categoryDao.findCategoryById(categoryid);
		if(category==null){
			throw new MyExcepton("未找到相关类别资料");
		}
		return category;
	}

}
