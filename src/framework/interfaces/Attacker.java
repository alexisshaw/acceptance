/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

/**
 *
 * @author Matt
 */
public interface Attacker extends CardActivator {

    /**
     * Give the result of an attack die roll.
     *
     * <p>
     * Only valid if the pending activation requires an attack dice
     * roll.
     * </p>
     *
     * @param roll the outcome of the attack dice roll
     */
    void giveAttackDieRoll (int roll);
}
