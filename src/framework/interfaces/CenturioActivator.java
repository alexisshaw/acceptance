/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

/**
 *
 * @author Matt
 */
public interface CenturioActivator extends Attacker, ActionDiceUser{

    /**
     * Choose whether to add an action dice to your current attack.
     * @param attackAgain whether to attack again
     */
    void chooseCenturioAddActionDie (boolean attackAgain);
}
