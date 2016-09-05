package exam16.model;

import exam16.interfaces.PokemonWorldManager;

/**
 * Represents a concrete pokemon thread running on the server.
 * 
 * TODO: You need to implement this.
 * 
 * @author bonii
 *
 */
public class APokemon implements Runnable {
	private PokemonWorldManager myWorldManager;
	private Integer locationStayingTimeInMSecs;

	public APokemon(Integer pokemonId, String pokemonName, IntegerLocation2D spawnLocation,
			PokemonWorldManager worldManger, Integer locationStayingTimeInMSecs) {
		// TODO -> Implement this constructor
	}

	public void kill() {
		// Terminate/suspend the pokemon, blocks until the thread has been
		// terminated/suspended
		// TODO -> Implement
	}

	@Override
	public void run() {
		// Implement the logic of the pokemon here
	}

}
