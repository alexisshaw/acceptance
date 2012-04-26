package tests.verified;

import framework.Test;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import javax.naming.OperationNotSupportedException;

/**
 * Testing the basic mechanics of Tribunus Plebis.
 *
 * @author Karla Burnett (karla.burnett)
 */
public class TribunusPlebisBasicTest extends Test {

    @Override
    public String getShortDescription() {
        return "Checking the basic mechanics of Tribunus Plebis";
    }

    @Override
    public void run(GameState gameState, MoveMaker move)
                                          throws AssertionError,
                                          UnsupportedOperationException,
                                          IllegalArgumentException {
        
        // Set up the player stats
        gameState.setPlayerVictoryPoints(0, 10);
        gameState.setPlayerVictoryPoints(1, 10);
        gameState.setPlayerSestertii(0, 10);
        gameState.setPlayerSestertii(1, 0);

        // Set up the game state for the test
        gameState.setWhoseTurn(0);
        gameState.setActionDice(new int [] {3, 3, 4});
                
        // Place the Tribunus Plebis on disc 3 and activate it
        move.placeCard(TRIBUNUSPLEBIS, 3);
        move.chooseCardToActivate(3);
        
        // Check that player 0 has gained a victory point, but player
        // 1's score has not changed
        assert(gameState.getPlayerVictoryPoints(0) == 11);
        assert(gameState.getPlayerVictoryPoints(1) == 10);
        assert(gameState.getPlayerSestertii(0) == 5);
        assert(gameState.getPlayerSestertii(1) == 0);
        
        // Place a tribunus plebis on the 4, to check that only the one 
        // card is activated
        move.placeCard(TRIBUNUSPLEBIS, 4);
        move.chooseCardToActivate(4);
        
        // Check that player 0 has gained a victory point, but player
        // 1's score has not changed
        assert(gameState.getPlayerVictoryPoints(0) == 12);
        assert(gameState.getPlayerVictoryPoints(1) == 10);
        assert(gameState.getPlayerSestertii(0) == 0);
        assert(gameState.getPlayerSestertii(1) == 0);
    }
}
