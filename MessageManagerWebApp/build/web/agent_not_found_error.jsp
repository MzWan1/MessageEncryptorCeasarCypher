<%-- 
    Document   : agent_not_found_error
    Created on : 01 Aug 2025, 8:18:12 PM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agent ID Not Valid Page</title>
    </head>
    <body>
        <h1>Agent ID Not Valid</h1>
        <%
            String message = (String)session.getAttribute("message");
        %>
        <p><%=message%></p>
        <p>
            <li><a href="start.html">Start</a></li>
        </p>
    </body>
</html>
