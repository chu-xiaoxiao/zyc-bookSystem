package com.zyc.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Acthor;

public interface ActhorDao {
		/**
		 * 添加作者
		 * @throws SQLException 
		 */
		void addCategroy(Acthor acthor) throws SQLException;
		/**
		 * 删除作者
		 * @throws SQLException 
		 */
		void deleteCategroy(Integer categoryId) throws SQLException;
		/**
		 * 查询作者
		 * @throws SQLException 
		 */
		List<Acthor> findCategory(Acthor acthor ) throws SQLException;
		/**
		 * 精确查找
		 * @throws SQLException 
		 */
		Acthor findCategoryById(Integer acthorId) throws SQLException;
		/**
		 * 改变作者信息
		 * @throws SQLException 
		 */
		void modifyCategory(Acthor acthor) throws SQLException;
		/**
		 *关闭连接
		 * @throws SQLException 
		 */
		void closeConnect() throws SQLException; 

}
