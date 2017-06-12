package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Publish;
import com.zyc.util.MyExcepton;

public interface PublishControlller {
	/**
	 * 添加出版社
	 * @throws SQLException 
	 */
	void addPublish(Publish publish) throws SQLException;
	/**
	 * 修改出版社
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyPublish(Publish publish) throws SQLException, MyExcepton;
	/**
	 * 删除出版社
	 * @throws SQLException 
	 */
	void deletePublish(Integer publishId) throws SQLException;
	/**
	 * 查询出版社
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Publish> findPublish(Publish publish) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Publish findByPublishId(Integer publishid) throws SQLException, MyExcepton;
}
