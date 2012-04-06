/**
 * Defines each of the unique cards within the Roma game
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @version 0.0.1
 * @since 05.04.2012
 */

package framework.cards;

public enum Card {
   AESCULAPINUM ("Aesculapinum"),
   ARCHITECTUS ("Architectus"),
   BASILICA ("Basilica"),
   CENTURIO ("Centurio"),
   CONSILIARUS ("Consiliarus"),
   CONSUL ("Consul"),
   ESSEDUM ("Essedum"),
   FORUM ("Forum"),
   GLADIATOR ("Gladiator"),
   HARUSPEX ("Haruspex"),
   LEGAT ("Legat"),
   LEGIONARIUS ("Legionarius"),
   MACHINA ("Machina"),
   MERCATOR ("Meractor"),
   MERCATUS ("Mercatus"),
   NERO ("Nero"),
   ONAGER ("Onager"),
   PRAETORANIUS ("Praetoranius"),
   SCAENICUS ("Scaenicus"),
   SENATOR ("Senator"),
   SICARIUS ("Sicarius"),
   TEMPLUM ("Templum"),
   TRIBUNISPLEBIS ("Tribunisplebis"),
   TURRIS ("Turris"),
   VELITES ("Velites"),
   NOT_A_CARD ("Not A Card");

   // Member to hold the name as a string.
   private String string;

   // Private constructor to construct a card from a string name.
   private Card (String name) {
       string = name;
   }

   // Overwrites the toString function.
   public String toString () {
       return string;
   }
}
