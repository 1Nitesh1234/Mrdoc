
package newserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ClinicsSR extends HttpServlet {

  
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String id = "";
        
        Cookie[] ck = request.getCookies();
        for(int i=0; i<ck.length; i++) {
            if(ck[i].getName().equals("id")) {
                id = ck[i].getValue();
                out.println(id);
            }
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
            PreparedStatement pstm = con.prepareStatement("select clinic_name,doctors_name, spetialization,clinic_add, clinic_discription,clinic_image from clinic where cid=?");
            pstm.setString(1, id);
            String Name, Drname, spl, add, des, img;
            
           ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                 Name = rs.getString("clinic_name");
                 Drname = rs.getString("doctors_name");
                 spl = rs.getString("spetialization");
                 add = rs.getString("clinic_add");
                 des = rs.getString("clinic_discription");
                 img = rs.getString("clinic_image");
                
                
                
                request.setAttribute("name",Name);
                request.setAttribute("dr",Drname);
                request.setAttribute("spl",spl);
                request.setAttribute("add",add);
                request.setAttribute("des",des);
                request.setAttribute("img",img);
                RequestDispatcher rd=request.getRequestDispatcher("Imgretrive.jsp");
                rd.forward(request, response);
                
            }
           

        } catch (Exception e) {
            out.println(e);
        }

    }
    
    }



