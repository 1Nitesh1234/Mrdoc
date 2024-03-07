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
            width: 100%; 
            padding: 10px; 
            box-sizing: border-box; 
            z-index: 999; 
            font-family: sans-serif;
}
       nav {
            background-color: #333;
            color: #fff;
            padding: 10px 40px;
            height:50px;
            margin:100px;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        nav ul li {
            float: left;
        }

        nav ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Change the color of links on hover */
        nav ul li a:hover {
            background-color: #ddd;
            color: black;
        }
</style>

    </head>
    <body>
        <marquee class="marq"  
                 direction="left" loop=""> 
            <div class="mar"> 
                <h1>WELCOME TO ${name} </h1>    
            </div> 
            
      </marquee>

<nav>
    <ul>
        <li><a href="#home">Home</a></li>
        <li><a href="#about">About</a></li>
        <li><a href="#services">Services</a></li>
        <li><a href="#contact">Contact</a></li>
    </ul>
</nav>

<div style="padding:20px">
    <h2>Simple Navigator Example</h2>
    <p>This is a basic example of a navigator (navbar) using HTML and CSS.</p>
</div>
            



</body>
</html>
