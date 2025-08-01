<%-- 
    Document   : user_already_exists_error
    Created on : 01 Aug 2025, 8:35:47 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Already Exists Error Page</title>
    </head>
    <body>
        <h1>User Already Exists Error</h1>
        <%
            String message = (String)session.getAttribute("message");
        %>
        <p><%=message%></p>
        <p>
            <li><a href="start.html">Start</a></li>
        </p>
    </body>
</html>
