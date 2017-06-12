package com.zyc.controlller;

import java.sql.SQLException;
import java.util.List;

import com.zyc.entity.Acthor;
import com.zyc.util.MyExcepton;

public interface ActhorController {
	/**
	 * 添加作者
	 * @throws SQLException 
	 */
	void addActhor(Acthor acthor) throws SQLException;
	/**
	 * 修改作者
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void modifyActhor(Acthor acthor) throws SQLException, MyExcepton;
	/**
	 * 删除作者
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	void deleteActhor(Integer acthorId) throws SQLException, MyExcepton;
	/**
	 * 查询作者
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	List<Acthor> findActhor(Acthor acthor) throws SQLException, MyExcepton;
	/**
	 * 精确查找
	 * @throws SQLException 
	 * @throws MyExcepton 
	 */
	Acthor findByActhorId(Integer acthorid) throws SQLException, MyExcepton;
}
