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

/**
 * Servlet implementation class loadOnStartUp
 */
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
					java.util.Date date=new java.util.Date();
					Date sqld=rs.getDate(9);
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
				ps.close();
				if(ps2!=null){
					ps2.close();
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
