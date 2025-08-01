/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.model.Messages;

/**
 *
 * @author nkamb
 */
@Local
public interface MessagesFacadeLocal {

    void create(Messages messages);

    void edit(Messages messages);

    void remove(Messages messages);

    Messages find(Object id);

    List<Messages> findAll();

    List<Messages> findRange(int[] range);

    int count();
    
}
