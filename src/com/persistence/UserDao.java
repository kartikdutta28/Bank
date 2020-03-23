package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.User;

public class UserDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static PreparedStatement ps2;
	public static ResultSet rs2;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addUser(User user){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into USERS_INFO values(?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,user.getUser_id());
			ps.setString(2,user.getFirst_name());
			ps.setString(3, user.getLast_name());
			ps.setString(4,user.getAddress());
			ps.setString(5,user.getUser_name());
			ps.setString(6, user.getPhone_number());
			ps.setString(7, user.getPassword());
			ps.setString(8,user.getTransaction_password());
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
			ps=connection.prepareStatement("select * from USERS_INFO where user_name=? and password=?");
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
	public User getUserInfo(String user_name,String pwd){
		User user=null;
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from user_info where user_name=? and password=?");
			ps.setString(1, user_name);
			ps.setString(2, pwd);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
				
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
		
		return user;
	}
	
}
