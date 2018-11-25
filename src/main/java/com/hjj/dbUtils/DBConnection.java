package com.hjj.dbUtils;

import java.sql.Connection;

public interface DBConnection {
	void dbInit();
	Connection getConnection();
}
