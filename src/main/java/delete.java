

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection Con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Id = request.getParameter("ID");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Shubham1234");
			PreparedStatement ps = Con.prepareStatement("DELETE FROM Mylibrary WHERE Lib_Id = ?");
			ps.setInt(1,Integer.parseInt(Id));
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
