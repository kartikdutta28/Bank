package com.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.FAQ;

public class FaqDao {
	public static Connection connection;
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static ConnectionProvider cp=new ConnectionProvider();
	public void addAccount(FAQ faq){
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("insert into FAQ_TABLE values(?,?,?,?)");
			ps.setInt(1, faq.getQuestion_id());
			ps.setString(2, faq.getQuestion());
			ps.setString(3, faq.getAnswer());
			ps.setString(4, faq.getUser_name());
			
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
	public List<FAQ> getAll(){
		List<FAQ> list=new ArrayList<FAQ>();
		try{
			connection=cp.openConnection();
			ps=connection.prepareStatement("select * from faq_table");
			rs=ps.executeQuery();
			while(rs.next()){
					if(rs.getString(3)!=null){
						list.add(new FAQ(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
					}
					
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}
}
