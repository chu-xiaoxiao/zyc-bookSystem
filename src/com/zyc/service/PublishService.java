package com.zyc.service;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

public interface PublishService {
	/**
	 * 添加出版社
	 * @throws SQLException 
	 */
	void addPublish(Publish publish) throws SQLException;
	/**
	 * 查询出版社
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Publish> findPublis(Publish publish) throws SQLException, MyExcepton;
	/**
	 * 删除出版社
	 * @throws SQLException 
	 */
	void deletePublis(Integer publishid) throws SQLException;
	/**
	 * 修改出版社
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyPublis(Publish publish) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Publish findBypublisId(Integer publishid) throws SQLException, MyExcepton;
}
