import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.swing.*;
  
public class Validate extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("login");  
    String p=request.getParameter("password");
    
    LoginDao ld=new LoginDao();
    boolean status=ld.validate(n,p);


    if(status){  
        
        RequestDispatcher rd=request.getRequestDispatcher("home.html");
	    rd.forward(request,response);
        

    }  
    else{  
        out.print("Username or Password incorrect");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    }  
          
    out.close();  
    }  
}  