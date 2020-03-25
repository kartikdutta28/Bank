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
	
	public void targetOperation(int acc_id,Double amt){
		int n=0;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("update accounts_info set amount=amount+? where account_id=?");
			ps.setDouble(1, amt);
			ps.setInt(2, acc_id);
			n=ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public void fromOperation(int acc_id,Double amt,int target){
		
		try{
			connection=cp.openConnection();
			System.out.println("Started from operation");
			TransactionDao td=new TransactionDao();
			Double amount=td.getAmount(acc_id);
			Double amount2=td.getAmount(target);
			ps=connection.prepareStatement("update accounts_info set amount=? where account_id=?");
			ps.setDouble(1, amount-amt);
			ps2=connection.prepareStatement("update accounts_info set amount=? where account_id=?");
			ps2.setDouble(1, amount2+amt);
			ps2.setInt(2, target);
			ps.setInt(2, acc_id);
			ps.executeUpdate();
			ps2.executeUpdate();
			System.out.println("Inside from operation");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	public void addTransfer(Transfer transfer){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into TRANSFER_INFO values(?,?,?,?,?,?)");
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
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
