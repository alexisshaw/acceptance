package acceptanceTests;

public interface AcceptanceInterface {

   public void createGame(GameState myState);
   public void takeTurn(Move myMove);
   public GameState getState();

}
