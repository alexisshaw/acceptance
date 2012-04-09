package framework.interfaces;

import framework.cards.Card;

/**
 * Provides a way of passing data to a card that is being activated.
 *
 * @author Matthew Moss (matthew.moss)
 * @author Lasath Fernando (lasath.fernando)
 */
public interface CardActivator {

    /**
     * Choose the number of victory points to buy with the Mercator.
     * @param VPToBuy the number of points to buy
     */
    void chooseMercatorBuyNum (int VPToBuy);

    /**
     * Choose the amount a dice disc value changes by.
     *
     * <p>
     * Valid changes are -1 or 1 in the current game.
     * </p>
     *
     * @param amount the amount to change by.
     */
    void chooseConsulChangeAmount (int amount);

    /**
     * Choose whether to add an action dice to your current attack.
     * @param attackAgain whether to attack again
     */
    void chooseCenturioAddActionDie (boolean attackAgain);

    /**
     * Choose whether to activate a Templum with your forum activation
     * @param activate true if the user wishes to activate a Templum.
     */
    void chooseActivateTemplum(boolean activate);

    /**
     * Select a card to mimic with the Scaenicus.
     *
     * <p>
     * This method selects a card for an activated Scaenicus to mimic.
     * A new CardActivator corresponding to the chosen card is returned,
     * so the test may use it to activate the selected card.
     * </p>
     *
     * @param diceDisc
     * @return
     */
    CardActivator getScaenicusMimicTarget (int diceDisc);

    /**
     * Mark the pending activation as complete.
     *
     * <p>
     * This method must be called when an activation is complete.
     * This method cannot be called until all required activation
     * methods have been called. No other methods in the move maker can
     * be called after a CardActivator has been received until after its
     * complete method is called. This is really important.
     * </p>
     */
    void complete();
}
