/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.web.exception;

/**
 *
 * @author MzWandile
 */
public class AgentIDNotValid extends Exception{

    private static final String errMsg = "The agent ID does not meet the minimum requirements which is three digits";
    public AgentIDNotValid() {
        super(errMsg);
    }
}