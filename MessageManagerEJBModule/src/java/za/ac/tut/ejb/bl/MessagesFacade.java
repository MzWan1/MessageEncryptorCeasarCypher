/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.bl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.ac.tut.ejb.model.Messages;

/**
 *
 * @author MzWandile
 */
@Stateless
public class MessagesFacade extends AbstractFacade<Messages> implements MessagesFacadeLocal {

    @PersistenceContext(unitName = "MessageManagerEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MessagesFacade() {
        super(Messages.class);
    }

}