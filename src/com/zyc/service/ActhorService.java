package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Acthor;
import com.zyc.util.MyExcepton;

public interface ActhorService {
		/**
		 * 添加类别
		 * @throws SQLException 
		 */
		void addActhor(Acthor acthor) throws SQLException;
		/**
		 * 查询类别
		 * @throws SQLException 
		 * @throws MyExcepton 
		 */
		List<Acthor> findActhor(Acthor acthor) throws SQLException, MyExcepton;
		/**
		 * 删除类别
		 * @throws SQLException 
		 * @throws MyExcepton 
		 */
		void deleteActhor(Integer acthorid) throws SQLException, MyExcepton;
		/**
		 * 修改类别
		 * @throws SQLException 
		 * @throws MyExcepton 
		 */
		void modifyActhor(Acthor acthorid) throws SQLException, MyExcepton;
		/**
		 * 精确查找
		 * @throws SQLException 
		 * @throws MyExcepton 
		 */
		Acthor findByActhorId(Integer acthorid) throws SQLException, MyExcepton;
}
