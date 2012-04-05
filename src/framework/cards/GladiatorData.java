/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class GladiatorData extends ActivateData {

    public final int cardToReturnToOpponentHand;

    public GladiatorData(int cardToReturnToOpponentHand) {
        this.cardToReturnToOpponentHand = cardToReturnToOpponentHand;
    }
}
