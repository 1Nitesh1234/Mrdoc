
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserhomepageDbcon extends HttpServlet {

 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         Random rand = new Random();
        int Did = rand.nextInt(1000);
        String Name = request.getParameter("PN");
        
        String gender = request.getParameter("GN");
        String cat = request.getParameter("Categories");
        String doc = request.getParameter("doctor");
        String Adate = request.getParameter("date");
        String Atime = request.getParameter("time");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("insert into booking_details values(?,?,?,?,?,?,?)");
            pstm.setInt(1, Did);
            pstm.setString(2,Name);
            pstm.setString(3, gender);
            pstm.setString(4, cat);
            pstm.setString(5, doc);
            pstm.setString(6, Adate);
            pstm.setString(7, Atime);

            int row = pstm.executeUpdate();
            if (row == 1) {
                out.println("<html><head><title>Registration Success</title><style>"
                        + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }"
                        + "h1 { text-align: center; margin-top: 20px; }"
                        + "p { text-align: center; }"
                        + "a { display: block; text-align: center; margin-top: 20px; }"
                        + "</style></head><body>"
                        + "<h1>Registration Successful</h1>"
                        + "<p>User Name: " + Name + "</p>"
                        + "<p>Registration ID: " + Did + "</p>"
                        + 
                        "</body></html>");
            } else {
                out.println("Data could not be inserted");
            }
        } catch (Exception e) {
            out.println(e);
        }
        }
    }



