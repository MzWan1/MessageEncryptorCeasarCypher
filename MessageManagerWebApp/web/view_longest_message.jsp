<%-- 
    Document   : view_longest_message
    Created on : 02 Aug 2025, 7:57:08 PM
    Author     : nkamb
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.ejb.model.Messages"%>
<%@page import="za.ac.tut.ejb.model.Users"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Longest Message Page</title>
    </head>
    <body>
        <h1>View Longest Message</h1>
        <%
            Users user= (Users) session.getAttribute("userWithLongestMessage");
            Messages message = (Messages) session.getAttribute("longestMsg");
        %>
        <p>
            Agent ID: <%=user.getAgentId()%> <br>
            Message:  <%=message.getCyphertext()%> <br>
            Message Byte Size: <%=message.getMessageLen()%> <br>
        </p>
        <p>
            <ul>
                <li><a href="start_outcome.jsp">Add Message</a></li>
                <li><a href="index.html">Home</a></li>
                <li><a href="LogoutServlet.do">Logout</a></li>
            </ul>
        </p>
    </body>
</html>
