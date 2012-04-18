package framework;

import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import framework.interfaces.activators.CardActivator;
import java.io.PrintStream;

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

//    @Override
//    public CardActivator chooseCardToActivate(int disc) {
//        // print out all the arguments
//        // the format of this string will need to be agreed/decided soon
//        out.println("Calling MoveMaker.activateCard(");
//        out.println("\tdisc = " + disc);
//        out.println("\tparameters = " + parameters);
//        out.println(")");
//
//        // do whatever checks are necessary to ensure that the move is valid
//        // in this.gameState
//        // whatever checks are done here will have to be documented in the
//        // MoveMaker interface
//        if (parameters == null) {
//            throw new IllegalArgumentException("ActivateData Parameters is Null");
//        }
//
//        // if everyhing checks out, actually call the method
//        mover.chooseCardToActivate(disc, parameters);
//    }

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placeCard(Card toPlace, int discToPlaceOn) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public CardActivator chooseCardToActivate(int disc) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
