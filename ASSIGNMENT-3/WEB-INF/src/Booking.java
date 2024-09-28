import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*; 
  
public class Booking extends HttpServlet {
	
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    { 
        try { 
  
				//step1 load the driver class 
				Class.forName("oracle.jdbc.driver.OracleDriver");    
  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##VALLI","password");  
  
				// Create a SQL query to insert data into table 
				PreparedStatement st = con.prepareStatement("insert into booking values(?, ?, ?, ?, ?, ?)"); 


				st.setString(1, request.getParameter("f-name"));
				st.setString(2, request.getParameter("dest"));
				st.setString(3, request.getParameter("dept"));
				st.setString(4, request.getParameter("arr"));
				st.setInt(5, Integer.parseInt(request.getParameter("room")));
				st.setInt(6, Integer.parseInt(request.getParameter("mob")));	
										
	  
  
				// Execute the insert command using executeUpdate() 
				st.executeUpdate(); 
				
				// Close the statement 
				st.close(); 
				
				// Get a writer pointer to display the successful result 
				PrintWriter out = response.getWriter(); 
				out.println("<html><body><h3>Successfully Inserted</h3><br/>");
				out.println("<b>Querying table Data<b/>");
				Statement stmt = con.createStatement();  
				ResultSet rs = stmt.executeQuery("select * from booking");  
				out.println("<table border=1>");  
				out.println("<tr><th>Name</th><th>Destination</th><th>DAeparture</th><th>Arrival</th><th>Roooms</th><th>Mob</th><tr>");  
				while (rs.next()) 
				{  
					String name = rs.getString("name");  
					String dest = rs.getString("destination");  
					String dept = rs.getString("departure"); 
					String arr = rs.getString("arrival");
					
					String room = String.valueOf(rs.getInt("room")); 
					String mob = String.valueOf(rs.getInt("mob")); 
					
					out.println("<tr><td>" + name + "</td><td>" + dest + "</td><td>" + dept + "</td><td>" + arr + "</td><td>" + room + "</td><td>" + mob +"</td> </tr>");   
				}  
				out.println("</table>");  
				out.println("</body></html>");  
				con.close();            

        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
        RequestDispatcher rd=request.getRequestDispatcher("bookingMessage.jsp");
		rd.forward(request,response);
    } 
} 