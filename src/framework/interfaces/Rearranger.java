/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

import framework.cards.Card;

/**
 *
 * @author Matt
 */
public interface Rearranger {

    /**
     * Place a floating card on to a dice disc.
     *
     * <p>
     * When cards that allow rearrangement are activated, all the cards
     * affected enter a floating state. Cards are then given new
     * locations with this method. The pending activation cannot be
     * completed while there are floating cards.
     * </p>
     *
     * @param card the card to place
     * @param diceDisc the location for the card to be placed
     */
    void placeCard (Card card, int diceDisc);
}
