

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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Connection Con;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String book = request.getParameter("name");
		String ID = request.getParameter("Id");
		String year = request.getParameter("year");
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Shubham1234");
			PreparedStatement ps = Con.prepareStatement("UPDATE Mylibrary SET Lib_name = ? WHERE Lib_id = ? ");
			ps.setString(1, book);
			
			ps.setInt(2,Integer.parseInt(ID));

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
