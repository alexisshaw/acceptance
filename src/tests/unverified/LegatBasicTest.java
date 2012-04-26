package tests.verified;

import framework.Test;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import javax.naming.OperationNotSupportedException;

/**
 * Testing the basic mechanics of Legat.
 *
 * @author Karla Burnett (karla.burnett)
 */
public class LegatBasicTest extends Test {

    @Override
    public String getShortDescription() {
        return "Checking the basic mechanics of Legat";
    }

    @Override
    public void run(GameState gameState, MoveMaker move)
                                          throws AssertionError,
                                          UnsupportedOperationException,
                                          IllegalArgumentException {
        
        // Set up the player stats
        gameState.setPlayerVictoryPoints(0, 10);
        gameState.setPlayerVictoryPoints(1, 10);
        gameState.setPlayerSestertii(0, 0);
        gameState.setPlayerSestertii(1, 0);

        // Set up the game state for the test
        gameState.setWhoseTurn(0);
        gameState.setActionDice(new int [] {3, 3, 4});
                
        // Place the Tribunus Plebis on disc 3 and activate it
        move.placeCard(LEGAT, 3);
        move.chooseCardToActivate(3);
        
        // Check that player 0 has gained 7 victory points, but player
        // 1's score has not changed
        assert(gameState.getPlayerVictoryPoints(0) == 17);
        assert(gameState.getPlayerVictoryPoints(1) == 10);
        assert(gameState.getPlayerSestertii(0) == 0);
        assert(gameState.getPlayerSestertii(1) == 0);
        
        // Place 5 cards on the opponent's side
        setPlayerCardsOnDiscs (1, new Card[] {LEGIONARIUS, 
                                              AESCULAPINUM, 
                                              NOT_A_CARD, 
                                              CONSUL, 
                                              NOT_A_CARD, 
                                              ESSEDUM, 
                                              MACHINA});
                                              
        // Activate the Legat again
        move.chooseCardToActivate(3);
        
        // Check that player 0 has gained 2 victory points, but player
        // 1's score has not changed
        assert(gameState.getPlayerVictoryPoints(0) == 19);
        assert(gameState.getPlayerVictoryPoints(1) == 10);
        assert(gameState.getPlayerSestertii(0) == 0);
        assert(gameState.getPlayerSestertii(1) == 0);
    }
}
