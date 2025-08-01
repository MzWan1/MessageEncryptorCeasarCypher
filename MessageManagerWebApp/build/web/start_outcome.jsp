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
        <form action="EncryptMessageSevelet.do" method="POST">
            <table>
                <tr>
                    <td>Text: </td>
                    <td><textarea name="plainText" cols="20" rows="5" required=""></textarea></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="CYPHERTEXT" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
