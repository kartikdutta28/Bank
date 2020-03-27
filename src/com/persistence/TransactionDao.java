package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.model.Transaction;

public class TransactionDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addTransaction(Transaction transaction){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into TRANSACTION_TABLE values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, transaction.getTransaction_id());
			ps.setInt(2, transaction.getUser_id());
			ps.setInt(3,transaction.getAccount_id());
			ps.setDouble(4, transaction.getAmount());
			ps.setDouble(5, transaction.getPost_balance());
			ps.setString(6, transaction.getTransaction_type());
			ps.setString(7, transaction.getComments());
			java.sql.Date sqlDate = new java.sql.Date(transaction.getDate().getTime());
			ps.setDate(8, sqlDate);
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
			ps=connection.prepareStatement("select amount from ACCOUNTS_INFO_V2 where account_id=?");
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
	public void updateAccount(Double post_amount,int account_id,int c){
		try{
			c=c+1;
			connection=cp.openConnection();
			ps=connection.prepareStatement("update ACCOUNTS_INFO_V2 set amount=?,counter=? where account_id=?");
			ps.setDouble(1, post_amount);
			ps.setInt(2, c);
			ps.setInt(3, account_id);
			
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
	public void updateAccountForTrac(Double post_amount,int account_id){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("update ACCOUNTS_INFO_V2 set amount=? where account_id=?");
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
	public List<Transaction> getStatement(int account_id,int rows){
		List<Transaction> list=new ArrayList<Transaction>();
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from transaction_table where account_id=? order by tdate asc");
			ps.setInt(1, account_id);
			ps.setMaxRows(rows);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Transaction(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getDouble(4), 
						rs.getDouble(5), rs.getString(6),rs.getString(7),rs.getDate(8)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Transaction> getStatementByDate(int account_id,String sdate,String edate){
		List<Transaction> list=new ArrayList<Transaction>();
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from transaction_table where account_id=? and (tdate between ? and ?)");
			ps.setInt(1, account_id);
			Date fdate = new SimpleDateFormat("yyyy-MM-dd").parse(sdate);
			Date s2date = new SimpleDateFormat("yyyy-MM-dd").parse(edate);
			java.sql.Date sqlsDate = new java.sql.Date(fdate.getTime());
			java.sql.Date sqleDate = new java.sql.Date(s2date.getTime());
			System.out.println(sqlsDate);
			System.out.println(sqleDate);
			ps.setDate(2, sqlsDate);
			ps.setDate(3, sqleDate);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Transaction(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getDouble(4), 
						rs.getDouble(5), rs.getString(6),rs.getString(7),rs.getDate(8)));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	public boolean checkCounter(int acc_id){
		int c=0;
		String type="";
		boolean flag=true;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from accounts_info_v2 where ACCOUNT_ID=?");
			ps.setInt(1, acc_id);
			rs=ps.executeQuery();
			if(rs.next()){
				c=rs.getInt(6);
				type+=rs.getString(7);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				ps.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(type.equals("N")&c==3){
			flag=false;
		}else if(type.equals("P")&c==5){
			flag=false;
		}
		return flag;
	}
	public int getCounter(int acc_id){
		int c=0;
		
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from accounts_info_v2 where ACCOUNT_ID=?");
			ps.setInt(1, acc_id);
			rs=ps.executeQuery();
			if(rs.next()){
				c=rs.getInt(6);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				connection.close();
				ps.close();
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	public void lockAccount(int acc_id){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("update ACCOUNTS_INFO_V2 set lock_stat=?,lock_date =? where account_id=?");
			ps.setString(1, "L");
			Date d=new Date();
			java.sql.Date sqlDate = new java.sql.Date(d.getTime());
			ps.setDate(2, sqlDate);
			ps.setInt(3, acc_id);
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
