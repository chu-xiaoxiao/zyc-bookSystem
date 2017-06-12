package com.zyc.dao;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Publish;


public interface PublishDao {
	/**
	 * 添加出版社
	 * 
	 * @param publish
	 * @throws SQLException
	 */
	void addPublish(Publish publish) throws SQLException;

	/**
	 * 组合查询
	 * 
	 * @throws SQLException
	 */
	List<Publish> findPublish(Publish publish) throws SQLException;

	/**
	 * 修改出版社
	 * 
	 * @throws SQLException
	 */
	void modifyPublish(Publish publish) throws SQLException;

	/**
	 * 删除出版社
	 * 
	 * @throws SQLException
	 */
	void deletePublis(Integer publishId) throws SQLException;

	/**
	 * 
	 * @param publishid
	 * @return
	 * @throws SQLException 
	 */
	Publish findByPublishid(Integer publishid) throws SQLException;
	/**
	 * 关闭连接
	 */
	void closeConnect();
}
