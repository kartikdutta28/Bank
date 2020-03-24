package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Transaction;

public class TransactionDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addTransaction(Transaction transaction){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into TRANSACTION_TABLE values(?,?,?,?,?,?,?)");
			ps.setInt(1, transaction.getTransaction_id());
			ps.setInt(2, transaction.getUser_id());
			ps.setInt(3,transaction.getAccount_id());
			ps.setDouble(4, transaction.getAmount());
			ps.setDouble(5, transaction.getPost_balance());
			ps.setString(6, transaction.getTransaction_type());
			ps.setString(7, transaction.getComments());
			ps.executeUpdate();
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
	public Double getAmount(int account_id){
		Double amt=0.0;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select amount from ACCOUNTS_INFO where account_id=?");
			ps.setInt(1, account_id);
			rs=ps.executeQuery();
			if(rs.next()){
				
				amt=rs.getDouble(1);
				System.out.println(amt);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amt;
	}
	public void updateAccount(Double post_amount,int account_id){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("update ACCOUNTS_INFO set amount=? where account_id=?");
			ps.setDouble(1, post_amount);
			ps.setInt(2, account_id);
			ps.executeUpdate();
			
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