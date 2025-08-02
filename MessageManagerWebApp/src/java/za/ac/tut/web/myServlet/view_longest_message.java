/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.MessagesFacadeLocal;
import za.ac.tut.ejb.bl.UsersFacadeLocal;
import za.ac.tut.ejb.model.Messages;
import za.ac.tut.ejb.model.Users;

/**
 *
 * @author nkamb
 */
public class view_longest_message extends HttpServlet {
    @EJB private MessagesFacadeLocal mfl;
    @EJB private UsersFacadeLocal ufl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Users userWithLongestMessage = ufl.findLongestMessage();
        
        if (userWithLongestMessage != null) {
            // Get the actual longest message from the user's messages
            Messages longestMsg = null;
            int maxLen = -1;
            
            for (Messages msg : userWithLongestMessage.getMessagesList()) {
                if (msg.getMessageLen() != null && msg.getMessageLen() > maxLen) {
                    maxLen = msg.getMessageLen();
                    longestMsg = msg;
                }
            }
            
            session.setAttribute("userWithLongestMessage", userWithLongestMessage);
            session.setAttribute("longestMsg", longestMsg);
        }
        
        request.getRequestDispatcher("view_longest_message.jsp").forward(request, response);
    }
}