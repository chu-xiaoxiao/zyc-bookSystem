package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zyc.entity.Category;
import com.zyc.util.DButil;

public class CategoryDaoImplement  implements CategoryDao{
	private Connection connection;
	
	/**
	 * @param connection
	 */
	public CategoryDaoImplement(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 */
	public CategoryDaoImplement() {
		super();
	}

	@Override
	public void addCategroy(Category category) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "INSERT INTO categroy (CATEGORYID,CATEGROYNAME) values (seqcategroy.nextval,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, category.getCategoryName());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("类别插入成功");
			DButil.commit(connection);
		}else{
			System.out.println("类别插入失败");
			DButil.rooback(connection);
		}
		DButil.closeConnection(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public void deleteCategroy(Integer categoryId) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "DELETE  categroy WHERE  CATEGORYID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, categoryId);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("类别删除成功");
			DButil.commit(connection);
		}else{
			System.out.println("类别删除失败");
			DButil.rooback(connection);
		}
		DButil.closeConnection(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public List<Category> findCategory(Category category) throws SQLException {
		List<Category> lists = new ArrayList<Category>();
		StringBuilder sql = new StringBuilder("SELECT  CATEGORYID,CATEGROYNAME FROM categroy WHERE 1=1	");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		if(category.getCategoryName()!=null){
			sql.append("  AND categoryname = '"+ category.getCategoryName()+"' ");
		}
		if(category.getCategoryId()!=null){
			sql.append("  AND categoryid = '"+ category.getCategoryId()+"' ");
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Category temp = new Category(resultSet.getInt(1),resultSet.getString(2));
			lists.add(temp);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return lists;
	}

	@Override
	public Category findCategoryById(Integer categoryid) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT  CATEGORYID,CATEGROYNAME FROM categroy WHERE categoryid = ?	");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, categoryid);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			Category temp = new Category(resultSet.getInt(1),resultSet.getString(2));
			DButil.closePreparedStatementAndResultset(preparedStatement, null);
			return temp;
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		return null;
	}

	@Override
	public void modifyCategory(Category category) throws SQLException {
		DButil.startTranscation(connection);
		StringBuilder sql = new StringBuilder("UPDATE categroy SET ");
		sql.append("CATEGORYID = "+category.getCategoryId()+", ");
		sql.append("CATEGROYNAME = '"+category.getCategoryName()+"' ");
		sql.append(" WHERE CATEGORYID = "+ category.getCategoryId());
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("类别修改成功");
			DButil.commit(connection);
		}else{
			System.out.println("类别修改失败");
			DButil.rooback(connection);
		}
		DButil.closeTranscation(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public void closeConnect() throws SQLException {
		DButil.closeConnection(connection);
	}
	
}
