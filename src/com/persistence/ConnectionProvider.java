package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	Connection con=null;
	public Connection openConnection()  throws Exception{
		Connection con = null;
		try {
			/* Initialize and load the JDBC-ODBC Bridge driver */
			Class.forName("oracle.jdbc.OracleDriver");
			/* Establish a connection with a data source */
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		/* returns connection object */
		return con;
	}
}
