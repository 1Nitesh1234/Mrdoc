package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserEdit extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("uid");
        String name = request.getParameter("username");
        String mobile = request.getParameter("mob");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("UPDATE regis SET name=?, mobile=?, email=?, password=? WHERE uid=?");
            pstm.setString(1, name); // Corrected parameter order
            pstm.setString(2, mobile);
            pstm.setString(3, email);
            pstm.setString(4, password);
            pstm.setString(5, uid); // Corrected parameter order

            int row = pstm.executeUpdate();

             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Update Result</title>");
            out.println("<style>");
            out.println("body {");
            out.println("font-family: Arial, sans-serif;");
            out.println("}");
            out.println(".output-container {");
            out.println("border: 2px solid #ccc;");
            out.println("padding: 20px;");
            out.println("margin: 20px auto;");
            out.println("max-width: 600px;");
            out.println("}");
            out.println("h1 {");
            out.println("color: #333;");
            out.println("}");
            out.println("button {");
            out.println("background: #85c1ee;");
            out.println("padding: 10px 24px;");
            out.println("text-decoration: none;");
            out.println("font-size: 18px;");
            out.println("border-radius: 20px;");
            out.println("}");
            out.println("button:hover {");
            out.println("background: #034e88;");
            out.println("color: #fff;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"output-container\">"); // Add a div for output container
            if (row == 1) {
                out.println("<h1>Update Successful</h1>"
                        + "<h1>Hello user: " + name
                        + "<br>Registration id: " + uid + "</h1>");
            } else {
                out.println("<h1>Data could not be updated</h1>");
            }
            out.println("<button onclick='goBack()'>Go Back</button>");
            out.println("</div>"); // Close the output container div
            out.println("<script>"
                    + "function goBack() {"
                    + "            window.history.back();"
                    + "}"
                    + "</script></body>");
            out.println("</html>");

        } catch (Exception e) {
            out.println(e);
        }
    }

}
