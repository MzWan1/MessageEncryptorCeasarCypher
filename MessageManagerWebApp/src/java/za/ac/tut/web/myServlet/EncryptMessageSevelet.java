package za.ac.tut.web.myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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

public class EncryptMessageSevelet extends HttpServlet {

    @EJB 
    UsersFacadeLocal ufl;
    
    @EJB 
    MessagesFacadeLocal mfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String plainText = request.getParameter("plainText");
        Integer messageLen = plainText.length();
       
        String agent_id = (String) session.getAttribute("agent_id");
        String agent_name = (String) session.getAttribute("agent_name");
        
      
        String cypherText = plainText.toLowerCase()
                              .replace("a", "1")
                              .replace("e", "2")
                              .replace("i", "3")
                              .replace("o", "4")
                              .replace("u", "5");

        
        Users existingUser = ufl.find(agent_id);
        List<Messages> myMessages = new ArrayList<>();
        Users userFk = new Users(agent_id);
        if (existingUser == null) {
            
            Messages message = new Messages(cypherText, messageLen, userFk);
            myMessages.add(message);
            
            Users user = new Users(agent_id, agent_name,  myMessages);
            ufl.create(user);
            
        } else{
            
            Messages message = new Messages(cypherText, messageLen, userFk);
            myMessages.add(message);
            mfl.create(message);
        }
        
        
     
        session.setAttribute("agent_id", agent_id);
        session.setAttribute("agent_name", agent_name);
        session.setAttribute("cypherText", cypherText);
        session.setAttribute("messageLen", messageLen);
        
        request.getRequestDispatcher("encrypt_outcome.jsp").forward(request, response);
    }
}