package framework;

import framework.cards.ActivateData;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import java.io.PrintStream;
import java.util.Collection;

/**
 * Wrapper for a testee's MoveMaker, to ensure no invalid moves are
 * given.
 *
 * @author Lasath Fernando (lasath.fernando)
 * @author Matthew Moss (matthew.moss)
 */
class SanityChecker implements MoveMaker {
    private MoveMaker mover;
    private GameState gameState;
    private PrintStream out;

    public SanityChecker(MoveMaker mover, GameState gameState, PrintStream out) {
        this.mover = mover;
        this.gameState = gameState;
        this.out = out;
    }

    @Override
    public void activateCard(int disc, ActivateData parameters) {
        // print out all the arguments
        // the format of this string will need to be agreed/decided soon
        out.println("Calling MoveMaker.activateCard(");
        out.println("\tdisc = " + disc);
        out.println("\tparameters = " + parameters);
        out.println(")");

        // do whatever checks are necessary to ensure that the move is valid
        // in this.gameState
        // whatever checks are done here will have to be documented in the
        // MoveMaker interface
        if (parameters == null) {
            throw new IllegalArgumentException("ActivateData Parameters is Null");
        }

        // if everything checks out, actually call the method
        mover.activateCard(disc, parameters);
    }

    @Override
    public void activateCardsDisc(int diceToUse, Card chosen) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void activateMoneyDisc(int diceToUse) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void endTurn() throws UnsupportedOperationException {
        // endTurn is always a sane thing to call
        mover.endTurn();
    }

    @Override
    public void placeCard(Card toPlace, int discToPlaceOn) throws UnsupportedOperationException {
    	
    	// check that the player's hand has a card of this type
    	Collection<Card> hand = gameState.getPlayerHand(gameState.getWhoseTurn());
    	boolean found = false;
    	for (Card card : hand) {
    		if (toPlace == card) {
    			found = true;
    		}
    	}
    	if (!found) {
    		throw new IllegalArgumentException("Player doesn't have " + toPlace);
    	}
    	
    	//throw new UnsupportedOperationException("Not supported yet.");
    	mover.placeCard(toPlace, discToPlaceOn);
    }
}
