package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addUser(User user){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into user_info values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,user.getUser_id());
			ps.setInt(2, user.getAccount_id());
			ps.setString(3,user.getFirst_name());
			ps.setString(4, user.getLast_name());
			ps.setString(5,user.getAddress());
			ps.setString(6,user.getUser_name());
			ps.setString(7, user.getPhone_number());
			ps.setString(8,user.getPassword());
			ps.setString(9, user.getEmail());
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
	public boolean validate(String name,String pwd){
		boolean flag=false;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from user_info where user_name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs.next()){
				flag=true;
			}
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
		
		return flag;
	}
	
}
