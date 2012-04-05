/**
 * TODO add description.
 * @author Benjamin James Wright (@ben.wright)
 * @author Damon Stacey (@damon.stacey)
 * @version 0.0.1
 * @since 05.04.2012
 */

package acceptanceTests;

public interface AcceptanceInterface {
   public void createGame(GameState myState);
   public void takeTurn(Move myMove);
   public GameState getState();

}
