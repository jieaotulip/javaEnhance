package com.hjj.dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCPTestUtil {
	private static Connection connection = null;
	private static PreparedStatement pst = null;
	private static ResultSet result = null;

	// (1) 每次插入一条数据前，就创建一个连接，该条数据插入完成后，关闭该连接；
	public static void writeDBByEveryConn(int i) {
		connection = DBConnectionImpl.getInstance().getConnection();
		String sql = "INSERT INTO Employees VALUES (?, 28, 'Sumit', 'Mittal')";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, i);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(connection, pst, result);
		}
	}

	// 2) 使用DBCP连接池，每次插入一条数据前，从DBCP连接池中获取一条连接，该条数据插入完成后，该连接交由DBCP连接池管理；
	public static void writeDBByDBCP(int i) {
		connection = KCYDBCPUtil.getConnection();
		String sql = "INSERT INTO Employees VALUES (?, 28, 'Sumit', 'Mittal')";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, i);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(connection, pst, result);
		}
	}

	public static void writeDBByOneConn(int i, PreparedStatement pst,
			Connection connection) {
		String sql = "INSERT INTO Employees VALUES (?, 28, 'Sumit', 'Mittal')";
		try {
			pst = connection.prepareStatement(sql);
			pst.setInt(1, i);
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connection connection = KCYDBCPUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			String sql = "select * from Employees where id=100";
			pst = connection.prepareStatement(sql);
			// pst.setInt(1, 100);
			result = pst.executeQuery();
			Employee employee = null;
			while (result.next()) {
				employee = new Employee();
				employee.setId(result.getInt("id"));
				employee.setAge(result.getInt("age"));
				employee.setFirst(result.getString("first"));
				employee.setLast(result.getString("last"));
				System.out.println(employee.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(connection, pst, result);
		}
	}

	public static void batchInsert() {
		Connection connection = KCYDBCPUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet result = null;
		try {
			connection.setAutoCommit(false);
			String sql = "INSERT INTO Employees VALUES (?, 28, 'Sumit', 'Mittal')";
			pst = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			for (int j = 0; j < 2000; j++) {
				pst.setInt(1, j);
				pst.addBatch();
			}
			pst.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeCon(connection, pst, result);
		}

	}

	public static void closeCon(Connection connection, PreparedStatement pst,
			ResultSet result) {
		try {
			if (connection != null)
				connection.close();
			if (pst != null)
				pst.close();
			if (result != null)
				result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
