package tests.unstable;

import framework.AcceptanceInterface;
import framework.Card;
import framework.GameState;
import java.util.ArrayList;

public class isGameStateImplemented implements framework.Test {

   public String toString () {
      return "testing tests could work (have you implemented our interface...";
   }

   public void run () {
      {
         System.out.print("   Testing the interface has been implemented...\n");
         AcceptanceInterface toBeTested = new myTestingInterface();

         System.out.print("   Testing the interface recieves a game state...\n");
         //2 Players, Start of game (round 1), a deck filled entirely with TRIBUNIS PLEBIS's
         //both players starting with 22 sestertii, and 14 victory points
         //  and a hand of size 3 mercators for each player, and a field like the following
         /*
                    |Coins|
            Mercator  |1| Mercator
                      |2|
            Mercator  |3| Mercator
            Mercator  |4| Mercator
                      |5|
                      |6|
                    |Cards|
          */

         int numPlayers = 2;
         int whoseTurnIsIt = 0; //first players turn. Players are 0 or 1
         ArrayList<Card> deck = new ArrayList<Card>();
         ArrayList<Card> discard = new ArrayList<Card>();

         for (int i = 0; i < 52; i++) {
            deck.add(Card.TRIBUNISPLEBIS);
         }

         boolean shouldDeckBeShuffled = false;
         int[] myPlayersSestertii = new int[numPlayers];
         int[] myPlayersVictoryPoints = new int[numPlayers];
         Card[][] myPlayersHands = new Card[numPlayers][255];
         Card[][] myPlayersCardsOnField = new Card[numPlayers][255];

         for (int i = 0; i < numPlayers; i++) {
            myPlayersSestertii[i] = 22;
            myPlayersVictoryPoints[i] = 14;
            for (int j = 1; j <= 6; j++) {
               if (j == 1) {
                  myPlayersHands[i][j] = Card.MERCATOR;
                  myPlayersCardsOnField[i][j] = Card.NOT_A_CARD;
               } else if (j >= 5) {
                  myPlayersCardsOnField[i][j] = Card.NOT_A_CARD;
               } else {
                  myPlayersHands[i][j] = Card.MERCATOR;
                  myPlayersCardsOnField[i][j] = Card.MERCATOR;
               }
            }

         }


         GameState newState = new GameState(numPlayers, whoseTurnIsIt, deck, discard, shouldDeckBeShuffled, myPlayersSestertii, myPlayersVictoryPoints, myPlayersHands, myPlayersCardsOnField);

         System.out.print("   Testing that we can give a state to the game...\n");
         toBeTested.createGame(newState);
         System.out.print("   Testing that without making any changes, the game returns what we gave them...\n");
         assert(newState.equals(toBeTested.getState()));
         System.out.print("   Success...\n");

      }
   }
}

