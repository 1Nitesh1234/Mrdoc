package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProfServ extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uname = "";
        String password;
        Cookie[] ck = request.getCookies();
        if (ck != null) {
            for (int i = 0; i < ck.length; i++) {
                if (ck[i].getName().equals("name")) {
                    uname = ck[i].getValue();
                }

            }
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");

            String query = "SELECT uid,email,mobile,password FROM regis WHERE name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uname);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                String email = resultSet.getString("email");
                String Mobile = resultSet.getString("mobile");
                String userid = resultSet.getString("uid");
                String pass = resultSet.getString("password");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Profile</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; }");
                out.println("h1 { color: #333; text-align: center; }");
                out.println("p { color: #666; }");
                out.println(".container {");
                out.println("    width: 50%;");
                out.println("    margin: 0 auto;");
                out.println("}");
                out.println(".profile-info {");
                out.println("    border: 1px solid #ccc;");
                out.println("    border-radius: 5px;");
                out.println("    padding: 20px;");
                out.println("    margin-bottom: 20px;");
                out.println("}");
                out.println(".profile-info p { margin: 10px 0; }");
                out.println(".edit-link {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("}");
                out.println(".edit-link a {");
                out.println("    background: #85c1ee;");
                out.println("    padding: 10px 24px;");
                out.println("    text-decoration: none;");
                out.println("    font-size: 18px;");
                out.println("    border-radius: 20px;");
                out.println("}");
                out.println(".edit-link a:hover {");
                out.println("    background: #034e88;");
                out.println("    color: #ffffff;");
                out.println("}");
                out.println("button {");
                out.println("background: #85c1ee;");
                out.println("padding: 10px 24px;");
                out.println("text-decoration: none;");
                out.println("font-size: 18px;");
                out.println("border-radius: 20px;");
                out.println("}");
                out.println(" button:hover{");
                out.println("background: #034e88;");
                out.println("color: #fff");
                out.println("}");
                
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h1>User Profile</h1>");
                out.println("<div class='profile-info'>");
                out.println("<p><strong>User ID:</strong> <span id='usrid'>" + userid + "</span></p>");
                out.println("<p><strong>Name:</strong> " + uname + "</p>");
                out.println("<p><strong>Email:</strong> " + email + "</p>");
                out.println("<p><strong>Mobile No.:</strong> " + Mobile + "</p>");
                out.println("<p><strong>Password:</strong> " + pass + "</p>");
                out.println("</div>");
                out.println("<div class='edit-link'>");
                out.println("<a href='Edit.jsp'>Edit</a>");
                out.println("<button onclick='goBack()'>Go Back</button>");
                out.println("</div>");
                out.println("</div>");
                out.println("<script>var x=document.getElementById('usrid').innerHTML;"
                        + " document.cookie = 'uid=' + x;"
                        + "function goBack() {"
                        + "            window.history.back();"
                        + "}"
                        
                        + "</script></body>");
                out.println("</html>");

            } else {
                out.println("User not found");
            }

            connection.close();
        } catch (Exception e) {
            out.println(e);
        }

    }
}


