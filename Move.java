package acceptanceTests;

public class Move {

   private int[] myDice;
   private int[] whereDiceGo;
   private Card[] whichCardsLaid;
   private int[] whereCardsLaid;
   
   String[] detailsOfCardMoves;

   public Move (int[] dice, int[] whereDiceShouldGo, 
                  Card[] cardsLaid, int[] whereCardsAreLaid,
                  String[] detailsOfCardActivation) {
   
      myDice               = dice;
      whereDiceGo          = whereDiceShouldGo;
      whichCardsLaid       = cardsLaid;
      whereCardsLaid       = whereCardsAreLaid;
      detailsOfCardMoves   = detailsOfCardActivation;
   
   }

   /*the values on dice that are rolled. */
   public int[] getDice() {
      return myDice;
   }
     
   /*on which dice discs these dice are layed (same order as the dice, 
            getWhereTheDiceGo()[0] is the disc number the getDice()[0] 
            dice is put on). 0 is card disc, 7 is money disc */
   public int[] getWhereTheDiceGo() {
      return whereDiceGo;
   }
   
   /*The collection of cards that are to be laid. (Note no explicit check cards are in hand.) */
   public Card[] getWhichCardsLaid() {
      return whichCardsLaid;
   }
 
   /*on which dice discs these cards are layed (same order as the cardsIndexed, 
            getWhereTheDiceGo()[0] is the disc number the getDice()[0] 
            dice is put on). 0 is card disc, 7 is money disc */
   public int[] getWhereCardsLaid() {
      return whereCardsLaid;
   }  

   //reduces the details of any card activation to a string? 
   public String[] detailsOfCardActivation() {
      return detailsOfCardMoves;
   }

}
