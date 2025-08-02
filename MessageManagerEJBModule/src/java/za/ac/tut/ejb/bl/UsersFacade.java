/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.ejb.model.Users;

/**
 *
 * @author MzWandile
 */
@Stateless
public class UsersFacade extends AbstractFacade<Users> implements UsersFacadeLocal {

    @PersistenceContext(unitName = "MessageManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    @Override
    public Users findLongestMessage() {
        try {
            // Find the message with maximum length and return its associated user
            String jpql = "SELECT m.agentIdFk FROM Messages m WHERE m.messageLen = " +
                         "(SELECT MAX(m2.messageLen) FROM Messages m2)";

            List<Users> users = em.createQuery(jpql, Users.class)
                                .setMaxResults(1) // Get just one in case of ties
                                .getResultList();

            return users.isEmpty() ? null : users.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}