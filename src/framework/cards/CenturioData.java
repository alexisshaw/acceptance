/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class CenturioData extends ActivateData {

    public final int attackDieRoll;
    public final boolean useActionDie;
    public final int actionDieToAdd;

    public CenturioData(int attackDieRoll, boolean useActionDie, int actionDieToAdd) {
        this.attackDieRoll = attackDieRoll;
        this.useActionDie = useActionDie;
        this.actionDieToAdd = actionDieToAdd;
    }
}