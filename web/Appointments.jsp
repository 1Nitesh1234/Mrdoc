<%-- 
    Document   : Appointments
    Created on : Feb 11, 2024, 11:33:38 AM
    Author     : nitesh sah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    </body>
</html>
<%
    String cat=request.getParameter("Catogories");
    try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                PreparedStatement pstm = con.prepareStatement("select Dname from doctor_registration where Dspeciality =?");
                pstm.setString(1, cat);
                ResultSet rs;
                rs=pstm.executeQuery();
                String abc= rs.getString("Dname");
                out.println(abc);
    }
 catch (Exception e) {
                out.println(e);
            }        
    }
    %>
    
