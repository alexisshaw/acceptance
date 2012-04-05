/**
 * GameState holds a complete state of the game consisting of
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @version 0.0.1
 * @since 05.04.2012
 */

package acceptance;

import java.util.List;
import java.util.Collections;

public class GameState {
   private static final int DIE_DISC_COUNT = 6;                   
   private static final int TOTAL_DISC_COUNT = DIE_DISC_COUNT + 2;
   private static final int PLAYER_COUNT = 2;
   private static final int NUM_CARDS = 52;

   private List<Card> deck;              // Container for the deck.
   private List<Card> discardPile;       // Container for the discard.
   private boolean shouldAllowShuffle;   // Flag to allow shuffing.
   private int numPlayers;               // Number of players in the game.
   private int whoseTurn;                // Defines the current players turn.
   private int[] sestertii;              // Array of sestertii for each player.
   private int[] victoryPoints;          // Array of victoryPoints for players.
   private List<Card>[] playerHands;     // List of cards containing players hands.
   private Card[][] playerCardsOnField;  // Arary containing the players cards.

   /**
    * Constructor to build the game state out of required components.
    * @param numPlayers the number of players in the game.
    * @param whoseTurn the current players turn.
    * @param deck a list of the cards in the board deck.
    * @param discard a list of cards within the board discard pile.
    * @param sestertii the amount of money for each player in the game.
    * @param victoryPoints the victory points for each player in the game.
    * @param playersHands a list of cards in each players hand.
    * @param playersCardsOnField a list of the cards currently on field.
    */
   public GameState (int numPlayers, int whoseTurn, List<Card> deck,
                    List<Card> discard, boolean shouldAllowShuffle,
                    int[] sestertii, int[] victoryPoints,
                    List<Card>[] playersHands, Card[][] playersCardsOnField) {
      // Assert preconditions are met.
      assert (numPlayers == PLAYER_COUNT);
      assert (whoseTurn >= 0 && whoseTurn < PLAYER_COUNT);
      assert (deck != null);
      assert (discard != null);
      assert (sestertii != null);
      assert (victoryPoints != null);
      assert (playersHands != null);
      assert (playersCardsOnField !=null);
      assert (playersHands.length == PLAYER_COUNT);
      assert (playersCardsOnField.length == PLAYER_COUNT);
      // Checks the field length is exactly the DIE_DISC_COUNT.
      int numCards = deck.size() + discard.size();
      for (int i = 0; i < PLAYER_COUNT; i++) {
         assert (playersCardsOnField[i].length == DIE_DISC_COUNT);
         numCards += playersHands[i].size();
      }
      // Checking the number of cards in the game is NUM_CARDS.
      assert (numCards == NUM_CARDS);

      this.numPlayers = numPlayers;
      this.whoseTurn = whoseTurn;
      this.deck = deck;
      this.discardPile = discardPile;
      this.shouldAllowShuffle = shouldAllowShuffle;
      this.sestertii = sestertii;
      this.victoryPoints = victoryPoints;
      this.playerHands = playerHands;
      this.playerCardsOnField = playerCardsOnField;
   }
   
   /**
    * Getter for whoesTurn attribute.
    * @return whoesTurn flag for the players turn.
    */
   public int getWhoseTurn () {
      return whoseTurn;
   }

   /**
    * Getter for the number of players.
    * @return numPlayers the number of players in the game.
    */
   public int getNumPlayers () {
      return numPlayers;   
   }

   /**
    * Getter for the deck attribute.
    * @return deck returns the deck.
    */
   public List<Card> getDeck () {
      return deck;
   }

   /**
    * Getter for the discard attribute.
    * @return discard the discard pile.
    */
   public List<Card> getDiscard () {
      return discardPile;
   }

   /**
    * Getter for the serritti.
    * @return serritti the currency of roma.
    */
   public int getSestertii (int playerNum) {
      return sestertii[playerNum];
   }

   /**
    * Getter for the Player's Victory Points.
    * @return victoryPoints the victory points for that player.
    */
   public int getPlayerVictoryPoints (int playerNum) {
      return victoryPoints[playerNum];
   }

   /**
    * Getter for the Player's Hand.
    * @return playerHands returns the playerHands.
    */
   public List<Card> getPlayerHand (int playerNum) {
      return playerHands[playerNum];
   }

   /**
    * Getter for the Player's CardsOnDiscs.
    * @return playerCardsOnField the players cards on field.
    */
   public Card[] getPlayerCardsOnDiscs (int playerNum) {
      return playerCardsOnField[playerNum];
   }

   /**
    * Predicate, if the deck is allowed to be shuffled.
    * @return shouldAllowShuffle if the deck can be shuffled.
    */
   public boolean isDeckAllowedToBeShuffled () {
      return shouldAllowShuffle;
   }
}
