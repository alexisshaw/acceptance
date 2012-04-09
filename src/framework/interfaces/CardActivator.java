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

    /**
     * The user chooses an action dice.
     *
     * <p>
     * An action dice of the given value is used. A dice of that value
     * must exist in the user's current unused action dice. The same
     * dice cannot be used multiple times on the same turn. The same
     * value can be used if the user has multiple dice of that value.
     * </p>
     *
     * <p>
     * Action dice are always referred to by their value, rather than
     * their index, because action dice do not have either an implicit
     * or explicit ordering.
     * </p>
     *
     * @param actionDiceValue the value of the dice to use
     */
    void chooseActionDice (int actionDiceValue);

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
