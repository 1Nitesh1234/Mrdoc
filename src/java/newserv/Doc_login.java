
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

public class Doc_login extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         {
            String uname = request.getParameter("username");
            String pass = request.getParameter("password");
            request.setAttribute("name", uname);

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                PreparedStatement pstm = con.prepareStatement("select Dpass,Dname from  doctor_registration where Demail=?");
                pstm.setString(1, uname);
                ResultSet rs = pstm.executeQuery();
              

                if (rs.next()) {
                    if (pass.equals(rs.getString(1))) {
                        out.println("registered successfully");
                        RequestDispatcher rd = request.getRequestDispatcher("Doctor_Loginpage.html");
                        rd.forward(request, response);
                         

                    } else {
                       out.println("<h1 style='position:relative; bottom:200px; left:300px'>User does not exist</h1>");

                        RequestDispatcher rd = request.getRequestDispatcher("Doctor_Loginpage.html");
                        rd.include(request, response);

                    }
                     }
            } catch (Exception e) {
                out.println(e);
            }


           
    }


    }
}
