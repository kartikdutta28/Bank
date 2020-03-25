package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	Connection con=null;
	public Connection openConnection()  throws Exception
	{
		
	Context ctx = new InitialContext();
	Context envctx=(Context)ctx.lookup("java:/comp/env");
	DataSource ds=(DataSource)envctx.lookup("jdbc/HRDB");
	
	con = ds.getConnection();
	System.out.println(" ->. con " + con);
	return con;
	}

}
