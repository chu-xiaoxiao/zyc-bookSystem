package com.zyc.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Category;

public interface CategoryDao {
	/**
	 * 添加类别
	 * @throws SQLException 
	 */
	void addCategroy(Category category) throws SQLException;
	/**
	 * 删除类别
	 * @throws SQLException 
	 */
	void deleteCategroy(Integer categoryId) throws SQLException;
	/**
	 * 查询类别
	 * @throws SQLException 
	 */
	List<Category> findCategory(Category category ) throws SQLException;
	/**
	 * 精确查找
	 * @throws SQLException 
	 */
	Category findCategoryById(Integer categoryid) throws SQLException;
	/**
	 * 改变类别信息
	 * @throws SQLException 
	 */
	void modifyCategory(Category category) throws SQLException;
	/**
	 *关闭连接
	 * @throws SQLException 
	 */
	void closeConnect() throws SQLException; 
}
