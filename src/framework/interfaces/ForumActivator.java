/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

/**
 *
 * @author Matt
 */
public interface ForumActivator extends ActionDiceUser {

    /**
     * Choose whether to activate a Templum with your forum activation
     * @param activate true if the user wishes to activate a Templum.
     */
    void chooseActivateTemplum(boolean activate);
}
