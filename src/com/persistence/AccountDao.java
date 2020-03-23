package com.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Account;
import com.model.User;

public class AccountDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addAccount(Account account){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into ACCOUNTS_INFO values(?,?,?,?,?)");
			ps.setInt(1, account.getAccount_id());
			ps.setInt(2, account.getUser_id());
			ps.setString(3, account.getAccount_type());
			ps.setDouble(4, account.getAmount());
			java.sql.Date sqlDate = new java.sql.Date(account.getCreation_date().getTime());
			ps.setDate(5, sqlDate);
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
	public List<Account> getAccountInfo(int user_id){
		List<Account> list=new ArrayList<Account>();
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from ACCOUNTS_INFO where USER_ID=? " );
			ps.setInt(1, user_id);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDate(5)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
