package framework.interfaces;

/**
 * This interface is required to be implemented by everyone you will
 * want to look at MoveMaker and GameState and be sure that you understand
 * how they work and how you can interface with them.
 * herp
 *
 * @author Lasath Fernando (lasath.fernando)
 * @author Benjamin James Wright (ben.wright)
 * @author Damon Stacey (damon.stacey)
 * @version 0.0.1
 * @since 0.0.1
 */
public interface AcceptanceInterface {

   /**
    * Return a {@link MoveMaker} associated with the given GameState.
    *
    * @param state the GameState that the mover will apply changes to
    *
    * @return a MoveMaker that will modify the given GameState
    */
   public MoveMaker getMover(GameState state);

   /**
    * Instantiate a {@link GameState} object.
    *
    * <p>
    * The created GameState should be a mutable new instance as this is called
    * before each test is run.
    * </p>
    *
    * <p>
    * The state should be set in the initial condition as defined per:
    * TODO: add the crap that makes an initial state here.
    * </p>
    *
    * @return
    */
   public GameState getInitialState();
}
