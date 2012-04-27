package tests.verified;

import framework.Test;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import javax.naming.OperationNotSupportedException;

/**
 * Testing the basic mechanics of Senator.
 *
 * @author Karla Burnett (karla.burnett)
 */
public class SenatorBasicTest extends Test {

    @Override
    public String getShortDescription() {
        return "Checking the basic mechanics of Senator";
    }

    @Override
    public void run(GameState gameState, MoveMaker move)
                                          throws AssertionError,
                                          UnsupportedOperationException,
                                          IllegalArgumentException {
        
        // Set up the player stats
        gameState.setPlayerVictoryPoints(0, 10);
        gameState.setPlayerVictoryPoints(1, 10);
        gameState.setPlayerSestertii(0, 3);
        gameState.setPlayerSestertii(1, 0);

        // Set up the game state for the test
        gameState.setWhoseTurn(0);
        gameState.setActionDice(new int [] {3, 3, 4});
        Collection<Card> hand = new ArrayList<Card> ();
        Collections.addAll(hand, Card.SENATOR,
                                 Card.VELITES,
                                 Card.PRAETORIANUS,
                                 Card.ESSEDUM,
                                 Card.CENTURIO,
                                 Card.SICARIUS,
                                 Card.ARCHITECTUS);
        gameState.setPlayerHand(0, hand);
                
        // Place the Tribunus Plebis on disc 3 and activate it
        move.placeCard(Card.SENATOR, 3);
        move.chooseCardToActivate(3);
        
        // Check that player has lost the necessary sestertii from laying
        // these cards
        assert(gameState.getPlayerVictoryPoints(0) == 10);
        assert(gameState.getPlayerVictoryPoints(1) == 10);
        assert(gameState.getPlayerSestertii(0) == 0);
        assert(gameState.getPlayerSestertii(1) == 0);
        
        // Check that the player can still lay character cards
        move.placeCard(Card.VELITES, 1);
        move.placeCard(Card.PRAETORIANUS, 2);
        move.placeCard(Card.ESSEDUM, 4);
        move.placeCard(Card.CENTURIO, 5);
        move.placeCard(Card.SICARIUS, 6);
        move.placeCard(Card.ARCHITECTUS, 7);
    }
}
