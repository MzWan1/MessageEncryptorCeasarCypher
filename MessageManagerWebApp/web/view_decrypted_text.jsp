<%@page import="za.ac.tut.ejb.model.Messages"%>
<%@page import="za.ac.tut.ejb.model.Users"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Decrypted Text Page</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>View Decrypted Text</h1>

    <%
        List<Users> userList = (List<Users>) session.getAttribute("List<Users>");
        if (userList != null && !userList.isEmpty()) {
    %>

    <table>
        <thead>
            <tr>
                <th>Agent ID</th>
                <th>Agent Name</th>
                <th>Message ID</th>
                <th>Message Length</th>
                <th>Message (Cyphertext)</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Users user : userList) {
                    List<Messages> messages = user.getMessagesList();
                    if (messages != null && !messages.isEmpty()) {
                        for (Messages msg : messages) {
            %>
                <tr>
                    <td><%= user.getAgentId() %></td>
                    <td><%= user.getAgentName() %></td>
                    <td><%= msg.getMessageId() %></td>
                    <td><%= msg.getMessageLen() %></td>
                    <td><%= msg.getCyphertext() %></td>
                </tr>
            <%
                        }
                    } else {
            %>
                <tr>
                    <td><%= user.getAgentId() %></td>
                    <td><%= user.getAgentName() %></td>
                    <td colspan="3">No messages found</td>
                </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
    <%
        } else {
    %>
        <p>No users found or no data available in session.</p>
    <%
        }
    %>
</body>
</html>
