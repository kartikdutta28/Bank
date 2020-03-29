package startupServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.persistence.ConnectionProvider;


public class loadOnStartUp extends HttpServlet {
	public ConnectionProvider cp=new ConnectionProvider();
	public Connection con;
	public PreparedStatement ps;
	public PreparedStatement ps2;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
@Override	
public void init(){
		
		try{
			con=cp.openConnection();
			ps=con.prepareStatement("select * from accounts_info_v2");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString(8).equals("L")){
					Date date=java.sql.Date.valueOf(java.time.LocalDate.now());
					
					System.out.println(date);
					Date sqld=rs.getDate(9);
					System.out.println(sqld);
					if(date.compareTo(sqld)>0){
						ps2=con.prepareStatement("update accounts_info_v2 set lock_stat=?,"
								+ "lock_date=?,counter=? where account_id=?");
						ps2.setString(1, "U");
						ps2.setDate(2, null);
						ps2.setInt(3, 0);
						ps2.setInt(4, rs.getInt(1));
						int n=ps2.executeUpdate();
						System.out.println("Transactions for account "+rs.getInt(1)+" have been unlocked");
						
					}
				}
				System.out.println("Account with "+rs.getInt(1)+" Was already unlocked");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				con.close();
				System.out.println(con+"closed");
				ps.close();
				System.out.println(ps+"ps closed");
				if(ps2!=null){
					ps2.close();
					System.out.println(ps2+"ps2.close");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
			try{
				con=cp.openConnection();
				ps=con.prepareStatement("select * from users_info_v2");
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					if(rs.getString(11).equals("L")){
						Date date=java.sql.Date.valueOf(java.time.LocalDate.now());
						Date sqld=rs.getDate(12);
						if(date.compareTo(sqld)>0){
							ps2=con.prepareStatement("update users_info_v2 set logstatus=?,"
									+ "lock_date=? where user_id=?");
							ps2.setString(1, "O");
							ps2.setDate(2, null);
							ps2.setInt(3, rs.getInt(1));
							int n=ps2.executeUpdate();
							System.out.println("Login for account "+rs.getInt(1)+" have been unlocked");
							
						}
					}
					System.out.println("User with "+rs.getInt(1)+" Was already unlocked");
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					con.close();
					System.out.println(con+"closed");
					ps.close();
					System.out.println(ps+"ps closed");
					if(ps2!=null){
						ps2.close();
						System.out.println(ps2+"ps2.close");
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		
		
		
	}

    public loadOnStartUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
