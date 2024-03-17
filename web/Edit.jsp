<%-- 
    Document   : Edit
    Created on : Mar 7, 2024, 6:01:37 PM
    Author     : nitesh sah
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                margin:0;
                padding:0;
                box-sizing: border-box;
                font-family: 'poppins',sans-serif;
                
            }
            .container
            {
               
                position: relative;
                width: 100%;
                min-height: 100vh;
                display:flex;
                justify-content: center;
                align-items: center;
                transition: 0.5s;
                padding: 20px;
                 background-image: url("img/edit.jpg");
                background-position: center; 
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
            .container .content{
                position: relative;
                max-width: 800px;
                
            }
            h2{
                font-weight: 600;
                margin-bottom: 10px;
                color: #333;
                
            }
            #popup{
                 margin-top: 50px;
                position: fixed;
                top: 40%;
                left: 50%;
                transform: translate(-50%,-50%);
                width: 400px;
                padding:50px;
                box-shadow: 0 5px 30px rgba(0,0,0,0.30);
                
               
                
            }
             input {
                width: 300px;
                padding: 6px;
                margin-bottom: 20px;
                box-sizing:border-box;
                display: block;
                margin-bottom: 8px;
             }
             .content button{
                 background: pink;
                padding: 10px 24px;
                text-decoration: none;
                font-size: 18px;
                border-radius: 20px;
             }
             .content button:hover{
                 
                background: #034e88;
                color: #ffffff;
             }
             
                
            
        </style>
    
    </head>
    <body>
        <%
            String uid="";
             Cookie[] ck = request.getCookies();
        for(int i=0; i<ck.length; i++) {
            if(ck[i].getName().equals("uid")) {
                uid = ck[i].getValue();
                request.setAttribute("usrid",uid);
            }
        }
            %>
              <div class="container">
                 
            <div class="content">
                 <form  action="UserEdit" id="popup">
                     
                 
                <h1>Update Here</h1>
                User id:<input type="text" name="uid" value="<%=uid%>"><br>
                user name:<input type="text" name="username" required><br>
                Mobile no.:<input type="text" name="mob" id="mob" required><br>
                Email:<input type="email" name="email" required><br>
                Password:<input type="password" name="pass" id="pass" required><br>
                <button type="submit">Edit Details</button>
                 <button onclick="goBack()">Go Back</button>
            </form>
                 <script>
        function goBack() {
            window.history.back();
        }
    </script>
                
            </div>
        </div>
    </body>
</html>
