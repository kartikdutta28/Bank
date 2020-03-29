package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Transfer;

public class TransferDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static PreparedStatement ps2;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	
	
	public void addTransfer(Transfer transfer){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into TRANSFER_INFO_V2 values(?,?,?,?,?,?)");
			System.out.println("Started add transfer");
			ps.setInt(1, transfer.getTransfer_id());
			ps.setInt(2, transfer.getFrom_account());
			ps.setInt(3, transfer.getTarget_account());
			ps.setDouble(4, transfer.getAmount());
			java.sql.Date sqlDate = new java.sql.Date(transfer.getTdate().getTime());
			ps.setString(5, transfer.getComments());
			ps.setDate(6, sqlDate);
			ps.executeUpdate();
			System.out.println("Inside add transfer");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
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
