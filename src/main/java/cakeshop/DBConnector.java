package com.cakeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	private static final String url = "sql203.epizy.com/epiz_27181266_cakeshop";
	private static final String user = "epiz_27181266";
	private static final String password = "FQz6LbmscX";

	private DBConnector() {

	}

	public static Connection getConnection() throws Exception {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("ERROR: Connection Failed " + e.getMessage());
		}
		return connection;

	}

	public static void closeConnection(Connection con) throws Exception {
		if (con != null)
			con.close();
	}

	public static void closeConnectionAll(Connection con, Statement st, ResultSet rs) throws Exception {
		if (con != null)
			con.close();
		if (st != null)
			st.close();
		if (rs != null)
			rs.close();
	}
}