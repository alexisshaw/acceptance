/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class ConsulData extends ActivateData {

    public final int diceToChangeIndex;
    public final int change;

    public ConsulData(int diceToChangeIndex, int change) {
        this.diceToChangeIndex = diceToChangeIndex;
        this.change = change;
    }
}
