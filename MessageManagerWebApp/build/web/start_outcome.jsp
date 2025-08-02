<%-- 
    Document   : start_outcome
    Created on : 28 Jul 2025, 3:15:59 AM
    Author     : nkamb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Outcome Page</title>
    </head>
    <body>
        <h1>Start Outcome </h1>
        <%
            String agent_name = (String)session.getAttribute("agent_name");
            String computer_name = application.getInitParameter("computer_name");
        %>
        <p>Hi <b><%=agent_name%></b> my name is <b><%=computer_name%></b>, please select option below</p>
        <ul>
            <li><a href="agent_menu.html">Agent Menu</a></li>
            <li><a href="agent_manager_menu.html">Agent Manger Menu</a></li> 
        </ul>
    </body>
</html>
