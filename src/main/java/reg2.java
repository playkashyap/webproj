

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class reg2
 */
@WebServlet("/reg2")
public class reg2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/webpro","root","Shubham1234"); 
			 PreparedStatement st = (PreparedStatement) con.prepareStatement("Select email, pass from web where email=? and pass=?");

                 st.setString(1, email);
                 st.setString(2, pass);
                 ResultSet rs = st.executeQuery();
                 
                 boolean flag = false;
				while(rs.next()) {
                	 if(rs.getString(1).equalsIgnoreCase(email) && rs.getString(2).equalsIgnoreCase(pass)){
                		 response.sendRedirect("abc.html");
                	 }
                	 else {
                		 flag = false;
                	 }
                	 
                 }
                 if(flag== false) {
                	 response.sendRedirect("error.html");
                 }
			
			
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
