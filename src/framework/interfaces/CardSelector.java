/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.interfaces;

/**
 *
 * @author Matt
 */
public interface CardSelector {

    /**
     * The user chooses a card from a pile.
     *
     * <p>
     * This choice is from an index where 0 is the topmost card. In the
     * case of the deck, 0 is the next to be drawn. In the case of the
     * discard, 0 is most recently discarded.
     * </p>
     *
     * @param indexOfCard the index of the card to use
     */
    void chooseCardFromPile (int indexOfCard);
}
