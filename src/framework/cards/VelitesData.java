/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class VelitesData extends ActivateData {

    public final int cardToAttack;
    public final int actionDiceRoll;

    public VelitesData(int cardToAttack, int actionDiceRoll) {
        this.cardToAttack = cardToAttack;
        this.actionDiceRoll = actionDiceRoll;
    }
}