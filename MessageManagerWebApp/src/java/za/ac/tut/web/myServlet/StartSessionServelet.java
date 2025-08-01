/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.MessagesFacadeLocal;
import za.ac.tut.ejb.bl.UsersFacadeLocal;
import za.ac.tut.ejb.model.Users;
import za.ac.tut.web.exception.AgentIDNotValid;
import za.ac.tut.web.exception.UserAlreadyExistsException;
import za.ac.tut.web.model.AgentIDValidation;
import static za.ac.tut.web.model.AgentIDValidation.validAgentId;

/**
 *
 * @author nkamb
 */
public class StartSessionServelet extends HttpServlet {

    @EJB 
    UsersFacadeLocal ufl;
    
    @EJB 
    MessagesFacadeLocal mfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        
        String agent_id = request.getParameter("agent_id");
        String agent_name = request.getParameter("agent_name");
        try {
            if (!AgentIDValidation.validAgentId(agent_id)) {
                throw new AgentIDNotValid();
            }
            
            Users existingUser = ufl.find(agent_id);
            if (existingUser != null) {
                throw new UserAlreadyExistsException("Agent ID " + agent_id + " is already in use");
            }
            
            //initialize session
            initializeSession(session, agent_id, agent_name);
            request.getRequestDispatcher("start_outcome.jsp").forward(request, response);
            
        } catch (AgentIDNotValid ex) {
            session.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("agent_not_found_error.jsp").forward(request, response);
        } catch (UserAlreadyExistsException ex) {
            session.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("user_already_exists_error.jsp").forward(request, response);
        }
        
    }

    private void initializeSession(HttpSession session, String agent_id, String agent_name) {
        session.setAttribute("agent_id", agent_id);
        session.setAttribute("agent_name", agent_name);
    }
}
