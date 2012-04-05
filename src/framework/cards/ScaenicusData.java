/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.cards;

/**
 *
 * @author Matt
 */
public class ScaenicusData extends ActivateData {

    public final int cardToMimic;
    ActivateData cardAction;

    public ScaenicusData(int cardToMimic, ActivateData cardAction) {
        this.cardToMimic = cardToMimic;
        this.cardAction = cardAction;
    }
}