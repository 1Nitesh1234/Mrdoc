
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLogin extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        {
             String uname = request.getParameter("username");
            String pass = request.getParameter("password");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                  
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                PreparedStatement pstm = con.prepareStatement("select adminpass from admin where adminname=?");
                pstm.setString(1, uname);
                ResultSet rs=pstm.executeQuery();
                if(rs.next())
                {
                    if(pass.equals(rs.getString(1))){
                       RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage");
                       rd.forward(request, response);
                       
                    }
                    else{
                       out.println("<h1>user does not exist</h1>");
                       RequestDispatcher rd=request.getRequestDispatcher("login.html");
                       rd.include(request, response);
                        
                    }

            }
            }
            catch(Exception e)
                    {
                    out.println(e);
                    }
            
        }
           
    }

   
}
