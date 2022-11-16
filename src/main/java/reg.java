import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;

    /**
     * Default constructor. 
     */
    public reg() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		System.out.println(username + "\t"+email+"\t"+pass);
		
		
		try{
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webpro","root","Shubham1234");  
			PreparedStatement ps = con.prepareStatement("insert into web (name,pass,email) values (?,?,?)");
				ps.setString(1, username);	
				ps.setString(2, pass);	
				ps.setString(3, email);	
				int c=ps.executeUpdate();
			System.out.println(c);
			response.sendRedirect("login.html");
		}
		catch(Exception e){ 
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

