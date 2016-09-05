package exam16.interfaces;

import exam16.model.IntegerLocation2D;
import exam16.model.InvalidLocationException;
import exam16.model.NotFoundException;

/**
 * Represents the set of methods that a pokemon can invoke to change the pokemon
 * world
 * 
 * @author bonii
 *
 */
public interface PokemonWorldManager extends WorldViewManager {

	/**
	 * Move the pokemon to targetLocation
	 * 
	 * @param pokemonId
	 * @param targetLocation
	 * @throws InvalidLocationException
	 *             If the targetLocation is occupied by another pokemon,
	 *             hunter,rejuvenator
	 * @throws NotFoundException
	 *             If the pokemonId does not exist
	 */
	public void movePokemon(Integer pokemonId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException;
}
