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
    	
    	int currentPlayer = gameState.getWhoseTurn();
    	
    	// check that the player's hand has a card of this type
    	Collection<Card> hand = gameState.getPlayerHand(currentPlayer);
    	if (!cardExists(toPlace, hand)) {
    		throw new IllegalArgumentException("Player doesn't have " + toPlace);
    	}
    	
    	// check that the player has sufficient sestertii to place the card
    	if (gameState.getPlayerSestertii(currentPlayer) < 0 ) { //TODO: @luke.cameron doesn't know how to get a card's cost
    		throw new IllegalArgumentException("Player doesn't have sufficient sestertii ");
    	}
    	
    	
    	// check that the dice disc is valid for the current game
    	
    	
    	mover.placeCard(toPlace, discToPlaceOn);
    }

	private boolean cardExists(Card toPlace, Collection<Card> hand) {
		boolean found = false;
    	for (Card card : hand) {
    		if (toPlace == card) {
    			found = true;
    		}
    	}
		return found;
	}
}
