/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package framework;

import framework.cards.ActivateData;
import framework.cards.Card;
import framework.interfaces.GameState;
import framework.interfaces.MoveMaker;
import java.io.PrintStream;

/**
 *
 * @author Lasath Fernando <edu@lasath.org>
 * @author Matthew Moss
 */
public class SanityChecker implements MoveMaker {
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

        // if everyhing checks out, actually call the method
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placeCard(Card toPlace, int discToPlaceOn) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
