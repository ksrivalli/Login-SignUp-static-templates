import java.sql.*;  
  
public class LoginDao {  
    public static boolean validate(String name,String pass){  
        boolean status=true;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##VALLI","password");  
                
            PreparedStatement ps=con.prepareStatement("select * from user_details where USERNAME=? and PASSWORD=?");  
            ps.setString(1,name);  
            ps.setString(2,pass);  
            status=true;
            ResultSet rs=ps.executeQuery();  
            status=rs.next();  
                
        }
        catch(Exception e){System.out.println(e);}  
        return status;  
}  
}  