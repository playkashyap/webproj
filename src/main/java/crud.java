import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class crud
 */
@WebServlet("/crud")
public class crud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<html>");
	    out.println("<meta charset=\"utf-8\" />");
	    out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />");
	    
	    out.println("<head><title>Crops</title>");

	    
	    //style sheet 
	    out.println("<link href=\"style.css\" rel=\"stylesheet\" />");
	    out.println("<link href=\"tab.css\" rel=\"stylesheet\" />");
	    
	    out.println("<body>");
	    out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
	    out.println("<div class=\"container\">");
	    out.println("<a class=\"navbar-brand\" href=\"#!\">Crop Management</a>");
	    out.println("<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\"><span class=\"navbar-toggler-icon\"></span></button>\n");
	    out.println(" <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
	    out.println("<ul class=\"navbar-nav ms-auto mb-2 mb-lg-0\">");
	    out.println("<li class=\"nav-item\"><a class=\"nav-link\" aria-current=\"page\" href=\"abc.html\">Home</a></li>");
	    out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"http://localhost:8080/webproj/operations\">Crud</a></li>");
	    out.println("<li class=\"nav-item\"><a class=\"nav-link active\" href=\"http://localhost:8080/webproj/crud\">Data available</a></li>");
	    out.println("</ul>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</nav>");
	    out.println("<section class=\"py-5\">");
	    out.println("<div class=\"container my-5\">");
	    out.println("<div class=\"row justify-content-center\">");
	    out.println("<div class=\"card text-center\">");
	    out.println("<div class=\"card-header\">");
	    out.println("<h1>Total Crops Available</h1>");
	    out.println("</div>\n");
	    out.println("<div class=\"card-body\">");
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Shubham1234");
		
		
		
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from myLibrary"); 
		out.println("<table >"
				+ "  <tr bgcolor=\"teal\">\n"
				+ "    <th><h4><i>Name</i></h4></th>\n"
				+ "    <th><h4><i>Year</i></h4></th>\n"
				+ "    <th><h4><i>Id</i></h4></th>\n"
				+ "  </tr>");

		while(rs.next()) 
			out.println("<tr>\n"
					+ "<td>"+rs.getString(1)+"</td>\n"
					+ "<td>"+rs.getInt(2)+"</td>\n"
					+ "<td>"+rs.getInt(3)+"</td>\n"
					+ "</tr>");
		
		
		
		
		
		 	}
		catch(Exception e){ 
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<div class=\"card-footer text-muted\">");
		out.println("");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</section>");
		out.println(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>");
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
