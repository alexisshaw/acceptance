/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

/**
 *
 * @author Matt
 */
public interface Targeted extends CardActivator {

    /**
     * The user chooses a dice disc.
     *
     * <p>
     * Only valid if the pending activation requires a dice disc from
     * the user at the point this method is called.
     * </p>
     *
     * @param diceDisc dice disc to use, by dice value
     */
    void chooseDiceDisc(int diceDisc);
}
