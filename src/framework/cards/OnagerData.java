/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class OnagerData extends ActivateData {

    public final int cardToAttack;
    public final int attackDieRoll;

    public OnagerData(int cardToAttack, int attackDieRoll) {
        this.cardToAttack = cardToAttack;
        this.attackDieRoll = attackDieRoll;
    }
}