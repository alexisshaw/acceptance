/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class ForumData extends ActivateData {

    public final int DiceToAdd;
    public final boolean useTemplumDice;
    public final int templumDiceToAdd;

    public ForumData(int DiceToAdd, boolean useTemplumDice, int templumDiceToAdd) {
        this.DiceToAdd = DiceToAdd;
        this.useTemplumDice = useTemplumDice;
        this.templumDiceToAdd = templumDiceToAdd;
    }
}