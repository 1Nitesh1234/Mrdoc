<%-- 
    Document   : newjsp
    Created on : Jan 16, 2024, 3:10:52 PM
    Author     : nitesh sah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        .navi {
            background-color: #555;
            color: #fff;
            padding: 10px;
            text-align:right;
        }
        .navigate{
              background-color: #454545;
            color: #fff;
            padding: 10px;
            text-align:left;
        }

        section {
            padding: 20px;
        }

        footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

    </style>

    </head>



    <body>
        
        <nav class="navi">
        <a href="#">Home</a> |
        <a href="Homepagehome">Users</a> |
        <a href="AdminLogin.html">Logout</a>|
        <a href="Admin_Addclinic.html">add new clinic</a>|
        <a href="DocReg.jsp">Add Doctor</a>
    </nav>
        <nav class="navigate">
            <p>Hello, ${name}!</p>
        </nav>

    <section>
        
        <p>This is your admin homepage.</p>

    </section>

    <footer>
        <p>&copy; 2024 Admin Dashboard</p>
    </footer>




</body>
</html>

