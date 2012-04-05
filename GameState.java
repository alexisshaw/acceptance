package acceptanceTests;

import java.util.ArrayList;
import java.util.Collections;
public class GameState {

   private ArrayList<Card> myDeck;
   private ArrayList<Card> myDiscardPile;
   private boolean shouldAllowShuffle;
   
   private int numPlayers;
   private int whoseTurn;
   
   private int[] money;
   private int[] vp;
   private Card[][] playerHands;
   private Card[][] playerCardsOnField ;
   

   public GameState(int numOfPlayers, int whoseTurnIsIt, 
                      ArrayList<Card> deck, ArrayList<Card> discard,
                      boolean shouldDeckBeShuffled,
                      int[] myPlayersSestertii, int[] myPlayersVictoryPoints, 
                      Card[][] myPlayersHands, Card[][] myPlayersCardsOnField) {

      numPlayers           = numOfPlayers;
      whoseTurn            = whoseTurnIsIt;
      
      myDeck               = deck;
      myDiscardPile        = discard;
      
      shouldAllowShuffle   = shouldDeckBeShuffled;
      money                = myPlayersSestertii;
      vp                   = myPlayersVictoryPoints;
      playerHands          = myPlayersHands;
      playerCardsOnField   = myPlayersCardsOnField;
      
   }
   
   public int getWhoseTurn() {
      return whoseTurn;
   }
   public int getNumPlayers() {
      return numPlayers;   
   }
   public ArrayList<Card> getDeck() {
      return myDeck;
   }
   public ArrayList<Card> getDiscard() {
      return myDiscardPile;
   }
   public int getPlayerMoney(int playerNum) {
      return money[playerNum];
   }
   public int getPlayervictoryPoints(int playerNum) {
      return vp[playerNum];
   }
   public Card[] getPlayerHand(int playerNum) {
      return playerHands[playerNum];
   }
   public Card[] getPlayerCardsOnDiscs(int playerNum) {
      return playerCardsOnField[playerNum];
   }
   public boolean isDeckAllowedToBeShuffled() {
      return shouldAllowShuffle;
   }
   
}


