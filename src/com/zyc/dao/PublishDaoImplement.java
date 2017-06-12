package com.zyc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyc.entity.Publish;
import com.zyc.util.DButil;


public class PublishDaoImplement implements PublishDao{
	private Connection connection;
	
	/**
	 * @param connection
	 */
	public PublishDaoImplement(Connection connection) {
		super();
		this.connection = connection;
	}

	/**
	 * 
	 */
	public PublishDaoImplement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void addPublish(Publish publish) throws SQLException {
			String sql = "insert into publish (publishid,publishname) values(seqpublish.nextval,?)";
			DButil.startTranscation(connection);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, publish.getPublishName());
			int i = preparedStatement.executeUpdate();
			if(i>0){
				System.out.println("出版社添加成功");
				DButil.commit(connection);
			}else{
				System.out.println("出版社添加失败");
				DButil.rooback(connection);
			}
			DButil.closeTranscation(connection);
			DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public List<Publish> findPublish(Publish publish) throws SQLException {
		List<Publish> list = new ArrayList<Publish>();
		StringBuilder sql = new StringBuilder("SELECT publishid,publishname FROM publish WHERE  1=1 ");
		if(publish.getPublishName()!=null){
			sql.append("AND publishname = '"+publish.getPublishName()+"' ");
		} 
		if(publish.getPublishId()!=null){
			sql.append(" AND publishid = "+publish.getPublishId()+" ");
		} 
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()){
			Publish temp = new Publish(resultSet.getInt(1),resultSet.getString(2));
			list.add(temp);
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return list;
	}

	@Override
	public void modifyPublish(Publish publish) throws SQLException {
		StringBuilder sql = new StringBuilder("UPDATE publish SET publishname = ? WHERE publishid = ?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setString(1,"'"+publish.getPublishName()+"'");
		preparedStatement.setInt(2,publish.getPublishId());
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("出版社修改成功");
			DButil.commit(connection);
		}else{
			System.out.println("出版社修改失败");
			DButil.rooback(connection);
		}
		DButil.closeTranscation(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public void deletePublis(Integer publishId) throws SQLException {
		StringBuilder sql = new StringBuilder("DELETE FROM publish WHERE publishid = ?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1,publishId);
		int i = preparedStatement.executeUpdate();
		if(i>0){
			System.out.println("出版社删除成功");
			DButil.commit(connection);
		}else{
			System.out.println("出版社删除失败");
			DButil.rooback(connection);
		}
		DButil.closeTranscation(connection);
		DButil.closePreparedStatementAndResultset(preparedStatement, null);
	}

	@Override
	public Publish findByPublishid(Integer publishid) throws SQLException {
		StringBuilder sql = new StringBuilder("SELECT publishid,publishname FROM publish WHERE publishid = ? ");
		PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
		preparedStatement.setInt(1, publishid);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
			Publish temp = new Publish(resultSet.getInt(1),resultSet.getString(2));
			DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
			return temp;
		}
		DButil.closePreparedStatementAndResultset(preparedStatement, resultSet);
		return null;
	}

	@Override
	public void closeConnect() {
		DButil.closeConnection(connection);
	}
	
}
