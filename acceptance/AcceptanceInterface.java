/**
 * This interface is required to be implemented by everyone you will
 * want to look at Move and GameState and be sure that you understand
 * how they work and how you can interface with them.
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @version 0.0.1
 * @since 05.04.2012
 */

package acceptance;

public interface AcceptanceInterface {
   /**
    * Create a new game in a state.
    * @param state the GameState to set.
    */
   public void setState(GameState state);

   /**
    * Requests a specific move from your game.
    * @param myMove the move to make.
    */
   public void takeTurn(Move myMove);

   /**
    * Return the current state of the game.
    * @return GameState the state of the game.
    */
   public GameState getState();
}
