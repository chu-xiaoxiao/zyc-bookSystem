package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Category;
import com.zyc.util.MyExcepton;

public interface CategoryController {
	/**
	 * 添加类别
	 * @throws SQLException 
	 */
	void addCategory(Category category) throws SQLException;
	/**
	 * 修改类别
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyCategory(Category category) throws SQLException, MyExcepton;
	/**
	 * 删除类别
	 * @throws SQLException 
	 */
	void deleteCategory(Integer categoryId) throws SQLException;
	/**
	 * 查询类别
	 * @throws SQLException 
	 */
	List<Category> findCategory(Category category) throws SQLException;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Category findByCategoryId(Integer categoryid) throws SQLException, MyExcepton;
}
