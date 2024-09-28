import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*; 
  
public class Contact extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
  
				//step1 load the driver class 
				Class.forName("oracle.jdbc.driver.OracleDriver");    
  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##VALLI","password");  
  
				// Create a SQL query to insert data into table 
				PreparedStatement st = con.prepareStatement("insert into contact_details values(?, ?, ?)"); 
	  
				st.setString(1, request.getParameter("firstname"));
				st.setString(2, request.getParameter("email"));
				st.setString(3, request.getParameter("msg"));
								
	  
  
				// Execute the insert command using executeUpdate() 
				st.executeUpdate(); 
				
				// Close the statement 
				st.close(); 
				
				// Get a writer pointer to display the successful result 
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><h3>Successfully Sent Message</h3><br/>");
				out.println("<b>Go back to home page<b/>");
				
				con.close();            

        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
		
		RequestDispatcher rd=request.getRequestDispatcher("sentMessage.jsp");
		rd.forward(request,response);
    } 
} 