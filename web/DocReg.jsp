<%-- 
    Document   : DocReg
    Created on : Mar 8, 2024, 8:56:22 PM
    Author     : nitesh sah
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
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
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            margin: 20px auto;
            width: 300px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            box-sizing: border-box;
            border: none;
            border-radius: 3px;
            background-color: #4CAF50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        select{
             width: 100%;
            padding: 10px;
            margin: 5px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 16px;
        }
    </style>
    </head>
    <body>
        <form action="DocRegistration">
        Doctor name: <input type="text" name ="name"><br>
        Mobile no.: <input type="text" name="mob"><br>
        Email: <input type="text" name="email"><br>
        Spatiality: <label for="Catogories">Categories:</label>
        <select id="Catogories" name="spl">
            
            
            <option value="Select category" >select category</option>
            <% try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/mrdoc", "root", "root");
                Statement tm = con.createStatement();
                String querry = "select * from Categories";
                ResultSet rs = tm.executeQuery(querry);
                while (rs.next()) {
            %>
            <option value="<%=rs.getString("categoty")%>"><%=rs.getString("categoty")%></option>
            <%
                }
                con.close();
            } catch (Exception e) {
                out.println(e);
            }
            %>
        </select><br>
        experience: <input type="text" name="exp"><br>
        education: <input type="text" name="edu"><br>
        <input type="submit" name="submit">
        </form>
    </body>
</html>
