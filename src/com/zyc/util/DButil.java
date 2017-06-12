package com.zyc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import oracle.jdbc.OracleDriver;

public class DButil {
	static {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接驱动
	 * 
	 * @return
	 */
	public static Connection getConnect() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-7A13540:1521:orcl", "umadmin",
					"umadmin");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭PreparedStatement和result
	 */
	public static void closePreparedStatementAndResultset(PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 关闭链接
	 */
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 开启事务
	 */
	public static void startTranscation(Connection connection) {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭事务
	 */
	public static void closeTranscation(Connection connection) {
		try {
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 提交事务
	 */
	public static void commit(Connection connection) {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 回滚事务
	 */
	public static void rooback(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
