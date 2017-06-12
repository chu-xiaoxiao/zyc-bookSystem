package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Category;
import com.zyc.util.MyExcepton;

public interface CategoryService {
	/**
	 * 添加类别
	 * @throws SQLException 
	 */
	void addCategory(Category category) throws SQLException;
	/**
	 * 查询类别
	 * @throws SQLException 
	 */
	List<Category> findCategory(Category category) throws SQLException;
	/**
	 * 删除类别
	 * @throws SQLException 
	 */
	void deleteCategory(Integer categoryid) throws SQLException;
	/**
	 * 修改类别
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyCategory(Category categoryid) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Category findByCategoryId(Integer categoryid) throws SQLException, MyExcepton;
}
