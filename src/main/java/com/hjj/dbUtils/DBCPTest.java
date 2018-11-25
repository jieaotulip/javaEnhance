package com.hjj.dbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * (1) 每次插入一条数据前，就创建一个连接，该条数据插入完成后，关闭该连接； 
 * (2) 使用DBCP连接池，每次插入一条数据前，从DBCP连接池中获取一条连接，该条数据插入完成后，该连接交由DBCP连接池管理； 
 * (3) 在插入数据之前创建一条连接，2000个数据全部使用该连接，2000个数据插入完毕后，关闭该连接。
 * 
 * @author hjj
 *
 */
public class DBCPTest {
//	@Test
	public void testWriteDBByEveryConn() {
		for (int i = 0; i < 2000; i++) {
			DBCPTestUtil.writeDBByEveryConn(i);
		}
	}

//	@Test
	public void testWriteDBByDBCP() {
		for (int i = 0; i < 2000; i++) {
			DBCPTestUtil.writeDBByDBCP(i);
		}
	}

//	@Test
	public void testWriteDBByOneConn() {
		Connection connection = DBConnectionImpl.getInstance().getConnection();
		PreparedStatement pst = null;
		for (int i = 0; i < 2000; i++) {
			DBCPTestUtil.writeDBByOneConn(i, pst, connection);
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void batchInsert(){
		DBCPTestUtil.batchInsert();
	}
	
}
