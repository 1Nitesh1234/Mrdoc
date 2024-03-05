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

public class AddClinic extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Random rand = new Random();
        int RN = rand.nextInt(300);
        String ClinicName = request.getParameter("clinic_name");
        String Drname = request.getParameter("Drname");
        String spetialization = request.getParameter("Spe");
        String Address = request.getParameter("Add");
        String description = request.getParameter("spl");
        String Location = request.getParameter("file");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("insert into clinic values(?,?,?,?,?,?,?)");
            pstm.setInt(1, RN);
            pstm.setString(2, ClinicName);
            pstm.setString(3, Drname);
            pstm.setString(4, spetialization);
            pstm.setString(5, Address);
            pstm.setString(6, description);
            pstm.setString(7, Location);

            int row = pstm.executeUpdate();

            if (row == 1) {
                out.println("<h1>Clinic Added Successfull</h1>"
                );
            } else {
                out.println("Some error occured");
            }

        } catch (Exception e) {
            out.println(e);
        }

    }
}
