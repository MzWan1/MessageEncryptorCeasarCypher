/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class view_decrypted_messages extends HttpServlet {

    @EJB private UsersFacadeLocal ufl;
    @EJB private MessagesFacadeLocal mfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        List<Users> userList = new ArrayList<>();
        
        userList = ufl.findAll();
        
        session.setAttribute("userList", userList);
        
        request.getRequestDispatcher("view_decrypted_text.jsp").forward(request, response);
    }
}
