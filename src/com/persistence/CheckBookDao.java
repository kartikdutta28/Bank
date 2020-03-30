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
				System.out.println("Inside ck dao");
				System.out.println(checkBook.getAddress());
				ps.setString(5, checkBook.getAddress());
				ps.setString(6, checkBook.getRequest_status());
				ps.executeUpdate();
				flag=true;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try{
					connection.close();
					System.out.println(" ->. con " + connection+" closed");
					ps.close();
					System.out.println(" ->. ps " + ps+" closed");
				}catch(Exception e){
					e.printStackTrace();
				}
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
		}finally {
			try{
				connection.close();
				System.out.println(" ->. con " + connection+" closed");
				ps.close();
				System.out.println(" ->. ps " + ps+" closed");
				rs.close();
				System.out.println(" ->. rs " + rs+" closed");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	public CheckBook getStatus(int account_id){
		CheckBook ck=null;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from checkbook_info where ACCOUNT_ID=?");
			ps.setInt(1, account_id);
			rs=ps.executeQuery();
			if(rs.next()){
				ck=new CheckBook(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getString(5), rs.getString(6));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				System.out.println(" ->. con " + connection+" closed");
				ps.close();
				System.out.println(" ->. ps " + ps+" closed");
				rs.close();
				System.out.println(" ->. rs " + rs+" closed");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return ck;
	}
	public void updateAddress(int id,String add){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("update checkbook_info set DELIVERY_ADDRESS=? WHERE ACCOUNT_ID=? ");
			ps.setString(1, add);
			ps.setInt(2, id);
			int n=ps.executeUpdate();
			System.out.println(n+" Rows updated  ");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				System.out.println(" ->. con " + connection+" closed");
				ps.close();
				System.out.println(" ->. ps " + ps+" closed");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
