package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.entity.Acthor;
import com.zyc.util.DButil;

public class ActhorDaoImplement implements ActhorDao{
	private Connection connection;
	
	/**
	 * @param connection
	 */
	public ActhorDaoImplement(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 */
	public ActhorDaoImplement() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addCategroy(Acthor acthor) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "INSERT INTO acthor (acthorid,acthorname,acthorsex) values (seqacthor.nextval,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, acthor.getActhorName());
		preparedStatement.setInt(2, acthor.getSex());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("作者插入成功");
			DButil.commit(connection);
		}else{
			System.out.println("作者插入失败");
			DButil.rooback(connection);
		}
		DButil.closeConnection(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public void deleteCategroy(Integer acthorid) throws SQLException {
		DButil.startTranscation(connection);
		String sql = "DELETE  acthor WHERE  acthorid = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, acthorid);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("作者删除成功");
			DButil.commit(connection);
		}else{
			System.out.println("作者删除失败");
			DButil.rooback(connection);
		}
		DButil.closeConnection(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
		
	}

	@Override
	public List<Acthor> findCategory(Acthor acthor) throws SQLException {
		List<Acthor> lists = new ArrayList<Acthor>();
		StringBuilder sql = new StringBuilder("SELECT  acthorid,acthorname,acthorsex FROM acthor WHERE 1=1	");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		if(acthor.getActhorName()!=null){
			sql.append("  AND acthorname = '"+ acthor.getActhorName()+"' ");
		}
		if(acthor.getActhorId()!=null){
			sql.append("  AND acthorid = '"+ acthor.getActhorId()+"' ");
		}
		if(acthor.getSex()!=null){
			sql.append("  AND acthorsex = '"+acthor.getSex()+"' ");
		}
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Acthor temp = new Acthor(resultSet.getInt(1),resultSet.getString(2),resultSet.getShort(3));
			lists.add(temp);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return lists;
	}

	@Override
	public Acthor findCategoryById(Integer acthorId) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT  acthorid,acthorname,acthorsex FROM acthor WHERE acthorid = ?	");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, acthorId);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			Acthor temp = new Acthor(resultSet.getInt(1),resultSet.getString(2),resultSet.getShort(3));
			DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
			return temp;
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return null;
	}

	@Override
	public void modifyCategory(Acthor acthor) throws SQLException {
		DButil.startTranscation(connection);
		StringBuilder sql = new StringBuilder("UPDATE acthor SET ");
		sql.append("acthorname = '"+acthor.getActhorName()+"', ");
		sql.append("acthorsex = "+acthor.getSex()+" ");
		sql.append(" WHERE acthorid = "+ acthor.getActhorId());
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("作者修改成功");
			DButil.commit(connection);
		}else{
			System.out.println("作者修改失败");
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
