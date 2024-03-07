
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfServ extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname = (String)request.getAttribute("name");
        String password = (String)request.getAttribute("pass");
        out.println(uname);
        out.println(password);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");

            
            String query = "SELECT email,mobile FROM regis WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uname);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                String email = resultSet.getString("email");
                String location = resultSet.getString("mobile");

                out.println("<html><head><title>User Profile</title></head><body>");
                out.println("<h1>User Profile</h1>");
                out.println("<p>Email: " + email + "</p>");
                out.println("<p>Location: " + location + "</p>");
                out.println("</body></html>");
            } else {
                out.println("User not found");
            }

            connection.close();
        }  catch(Exception e)
                    {
                    out.println(e);
                    }
          
        }
    }


