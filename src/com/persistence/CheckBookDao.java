package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.CheckBook;

public class CheckBookDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	
	public boolean addCheckBookRequest(CheckBook checkBook){
		boolean flag=false;
		if(checkRequest(checkBook.getAccount_id())==false){
			try{
				connection=cp.openConnection();
				ps=connection.prepareStatement("insert into checkbook_info values(?,?,?,?,?,?)");
				ps.setInt(1, checkBook.getRequest_id());
				ps.setInt(2, checkBook.getAccount_id());
				java.sql.Date rdate = new java.sql.Date(checkBook.getReq_date().getTime());
				java.sql.Date mdate = new java.sql.Date(checkBook.getDelivery_date().getTime());
				ps.setDate(3,rdate);
				ps.setDate(4, mdate);
				ps.setString(5, checkBook.getAddress());
				ps.setString(6, checkBook.getRequest_status());
				ps.executeUpdate();
				flag=true;
			}catch (Exception e) {
				e.printStackTrace();
			}try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	public boolean checkRequest(int account_id){
		boolean flag=false;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from checkbook_info where ACCOUNT_ID=?");
			ps.setInt(1, account_id);
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}try{
			connection.close();
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
}
