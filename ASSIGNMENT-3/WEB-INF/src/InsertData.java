import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*; 
  
public class InsertData extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
  
				//step1 load the driver class 
				Class.forName("oracle.jdbc.driver.OracleDriver");    
  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##VALLI","password");  
  
				// Create a SQL query to insert data into table 
				PreparedStatement st = con.prepareStatement("insert into user_details values(?, ?, ?, ?)"); 
	  
				st.setString(1, request.getParameter("firstname"));
				st.setString(2, request.getParameter("username"));
				st.setString(3, request.getParameter("email"));
				st.setString(4, request.getParameter("password"));				
	  
  
				// Execute the insert command using executeUpdate() 
				st.executeUpdate(); 
				
				// Close the statement 
				st.close(); 
				
				// Get a writer pointer to display the successful result 
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><h3>Successfully Inserted</h3><br/>");
				out.println("<b>Querying table Data<b/>");
				Statement stmt = con.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from user_details");  
				out.println("<table border=1>");  
				out.println("<tr><th>Name</th><th>UserName</th><th>Email</th><th>Password</th><tr>");  
				while (rs.next()) 
				{  
					String firstname = rs.getString("name");  
					String username = rs.getString("username"); 
					String email = rs.getString("email");
					String password = rs.getString("password"); 
					out.println("<tr><td>" + firstname + "</td><td>" + username + "</td><td>" + email + "</td><td>" + password + "</td></tr>");   
				}  
				out.println("</table>");  
				out.println("</body></html>");  
				con.close();            

        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
	RequestDispatcher rd=request.getRequestDispatcher("home.html");
	rd.forward(request,response);
    } 
} 