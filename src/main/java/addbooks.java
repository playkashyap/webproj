import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addbooks
 */
@WebServlet("/addbooks")
public class addbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection Con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addbooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String book = request.getParameter("book");
		String year = request.getParameter("year");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Shubham1234");
			PreparedStatement ps = Con.prepareStatement("insert into Mylibrary (Lib_Name,Lib_year) values (?,?)");
			ps.setString(1, book);	
			ps.setString(2, year);	

			int c=ps.executeUpdate();
			System.out.println(c);
			response.sendRedirect("http://localhost:8080/webproj/operations");
			 
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
