package framework.interfaces;

import framework.cards.ActivateData;
import framework.cards.Card;

/**
 *
 * @author Matthew Moss (matthew.moss)
 * @author Lasath Fernando (lasath.fernando)
 */
public interface Move {

    /**
     * Activate the card that is currently on the given dice disc.
     *
     * <p>
     * After this method is called:
     * <ul>
     * <li>the appropriate action dice will have been used</li>
     * <li>any activation effects from the card will have been carried
     * out</li>
     * <li>if appropriate, the card will have been discarded</li>
     * </ul>
     * </p>
     *
     * <p>
     * This will never be called if:
     * <ul>
     * <li>the player does not have the appropriate action dice to
     * activate the given disc</li>
     * <li>the card cannot be activated at the current time</li>
     * <li>the ActionData parameter does not match the activated
     * card</li>
     * <li>the dice disc is not valid for the current game</li>
     * </ul>
     *  </p>
     *
     * @param disc the disc where the card to be activated is
     * @param parameters the ActivateData needed by that specific card
     *
     * @throws UnsupportedOperationException if the move is not yet
     * implemented
     */
    public void activateCard(int disc, ActivateData parameters)
                                   throws UnsupportedOperationException;

    /**
     * Activate the cards disc with the given action die, and choose
     * to keep the given card.
     *
     * <p>
     * After this method is called:
     * <ul>
     * <li>the appropriate number of cards will be removed from the
     * deck</li>
     * <li>an instance of the card given will be in the player's
     * hand</li>
     * <li>the other cards removed from the deck will be present at the
     * top of the discard pile in unspecified order</li>
     * <li>the appropriate action die will have been used</li>
     * </ul>
     * </p>
     *
     * <p>
     * This will never be called if:
     * <ul>
     * <li>if the user does not have an unused action die of the given
     * value</li>
     * <li>the cards drawn from the deck do not include the given
     * card</li>
     * </ul>
     *
     * @param diceToUse which value dice to use to activate the disc
     * @param chosen which card to keep from the group drawn from the
     * deck
     *
     * @throws UnsupportedOperationException if the move is not yet
     * implemented
     */
    public void activateCardsDisc(int diceToUse, Card chosen)
                                   throws UnsupportedOperationException;

    /**
     * Activate the Money Disc with the given action die.
     *
     * <p>
     * After this method is called:
     * <ul>
     * <li>the appropriate action die will have been used</li>
     * <li>the correct amount of sestertii will have been added to the
     * player's money</li>
     * </ul>
     * </p>
     *
     * <p>
     * This will never be called if:
     * <ul>
     * <li>if the user does not have an unused action die of the given
     * value</li>
     * </ul>
     *
     * @param diceToUse which value dice to activate the disc with
     * @throws UnsupportedOperationException if the move is not yet
     * implemented
     */
    public void activateMoneyDisc(int diceToUse)
                                   throws UnsupportedOperationException;

    /**
     * End the turn of the current player.
     *
     * <p>
     * After this method is called:
     * <ul>
     * <li>the current player will have advanced</li>
     * <li>the appropriate number of dice will have been rolled</li>
     * <li>the appropriate number of victory points will have been
     * removed for vacant dice discs</li>
     * </ul>
     * </p>
     *
     * <p>
     * There are no restrictions on the calling of this method.
     * </p>
     *
     * @throws UnsupportedOperationException if the move is not yet
     * implemented
     */
    public void endTurn()
                                   throws UnsupportedOperationException;

    /**
     * Place a card from the current player's hand on to the selected
     * dice disc.
     *
     * <p>
     * After this method is called:
     * <ul>
     * <li>the selected card will be present on the dice disc</li>
     * <li>the required amount of money will have been deducted from the
     * player's hand</li>
     * <li>any extra changes specific to the card
     * to be carried out when a card is placed, will be in effect</li>
     * </ul>
     * </p>
     *
     * <p>
     * This will never be called if:
     * <ul>
     * <li>the player's hand doesn't contain a card of the given
     * type</li>
     * <li>the player has insufficient money to place the given
     * card</li>
     * <li>the dice disc is not valid for the current game</li>
     * </ul>
     * </p>
     *
     * @param toPlace the type of card to be placed
     * @param discToPlaceOn the disc on which the card will be placed
     *
     * @throws UnsupportedOperationException if the move is not yet
     * implemented
     */
    public void placeCard(Card toPlace, int discToPlaceOn)
                                   throws UnsupportedOperationException;
}
