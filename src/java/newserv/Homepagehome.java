package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Homepagehome extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pst = con.prepareStatement("select * from regis");
            out.println("<table width=80% border=1>");
            out.println("<caption><h1>user details</h1></caption>");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalcolumn = rsmd.getColumnCount();
            out.println("<tr>");
            for (int i = 1; i <= totalcolumn; i++) {
                out.println("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            out.println("<tr>");
            while (rs.next()) {
                out.print("<tr><td>" + rs.getInt(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td><a href='Edit.html'>Update</href></td><td><a href=''>Delete</href></tr>");
            }
            out.print("</table>");

        } catch (Exception e) {
            out.println(e);
        }

    }
}
