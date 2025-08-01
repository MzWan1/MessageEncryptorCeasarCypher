/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.web.model;

/**
 *
 * @author MzWandile
 */
public class AgentIDValidation {

    public static boolean validAgentId(String agent_id){
        boolean isValid = false;
        
        char id [] = agent_id.toCharArray();
        int id_length = id.length;
        
        
        boolean isADigit = false;
        for (char c : id) {
            if (Character.isDigit(c)) {
                isADigit = true;
            } else {
                isADigit = false;
            }
        }
        
        
        if (isADigit && id_length == 3) {
            isValid = true;
        } else {
            isValid = false;
        }
        return isValid;
    }
    
  
}