<%-- 
    Document   : Imgretrive
    Created on : Feb 19, 2024, 6:33:57 PM
    Author     : nitesh sah
--%>

<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
  background-image: url("${img}");
    background-repeat: no-repeat;
    background-size: cover; /* This property ensures that the background image covers the entire viewport */
    font-family: Arial, sans-serif;
    color: #ffffff;

}
.marq {
            font-family: Arial, sans-serif;
            
            color:  darksalmon;
            position: fixed; 
            top: 0; 
            width: 80%; 
            padding: 10px; 
            box-sizing: border-box; 
            z-index: 99; 
            font-family: sans-serif;
</style>

    </head>
    <body>
        <marquee class="marq"  
                 direction="left" loop=""> 
            <div class="mar"> 
                <h1>WELCOME TO ${name} </h1>    
            </div> 
      </marquee>

</body>
</html>
