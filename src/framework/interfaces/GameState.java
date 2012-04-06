/**
 * GameState holds a complete state of the game consisting of
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @author Matthew Moss (@matthew.moss)
 * @author Lasath Fernando (@lasath.fernando)
 * @version 0.0.1
 * @since 05.04.2012
 */

package framework.interfaces;

import framework.cards.Card;
import java.util.Collection;
import java.util.List;

public interface GameState {

   /**
    * Getter for whoesTurn attribute.
    * @return whoesTurn flag for the players turn.
    */
   public int getWhoseTurn ();
   public int setWhoseTurn();

   /**
    * Getter for the deck attribute.
    * @return deck returns the deck.
    */
   public List<Card> getDeck ();
   public void setDeck (List<Card> deck);

   /**
    * Getter for the discard attribute.
    * @return discard the discard pile.
    */
   public List<Card> getDiscard ();
   public void setDiscard (List<Card> discard);

   /**
    * Getter for the sestertii.
    * @return sestertii the currency of Roma.
    */
   public int getSestertii (int playerNum);
   public void setSestertii (int playerNum, int amount);

   /**
    * Getter for the Player's Victory Points.
    * @return victoryPoints the victory points for that player.
    */
   public int getPlayerVictoryPoints (int playerNum);
   public void setPlayerVictoryPoints (int playerNum, int points);

   /**
    * Getter for the Player's Hand.
    * @return playerHands returns the playerHands.
    */
   public Collection<Card> getPlayerHand (int playerNum);
   public void getPlayerHand (int playerNum, Collection<Card> hand);

   /**
    * Getter for the Player's CardsOnDiscs.
    * @return playerCardsOnField the players cards on field.
    */
   public Card[] getPlayerCardsOnDiscs (int playerNum);
   public void setPlayerCardsOnDiscs (int playerNum, Card[] discCards);
}
