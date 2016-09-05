package exam16.interfaces;

import exam16.model.IntegerLocation2D;
import exam16.model.InvalidLocationException;
import exam16.model.NotFoundException;

/**
 * Represents the set of methods that a rejuvenator can invoke to change the
 * pokemon world
 * 
 * @author bonii
 *
 */
public interface RejuvenatorWorldManger extends WorldViewManager {

	/**
	 * Rejuvenate the pokemon if it is dead and occupying targetLocation. Also
	 * check that the pokemon is in the visibility range of the hunter. Use
	 * visibility definition in the WorldViewManager interface.
	 * 
	 * This must also create/re-activate the pokemon thread depending whether
	 * termination/supension was used to implement killing pokemons. The method
	 * should only return when the thread creation/re-activation is complete.
	 * 
	 * @param pokemonId
	 * @param targetLocation
	 * @throws NotFoundException
	 *             If the pokemon id does not exist of if a dead pokemon with
	 *             pokemonId does not exist at targetLocation or if the
	 *             rejuvenatorId does not exist or the pokemon is beyond the
	 *             visibility range of the rejuvenator
	 */
	public void rejuvenatePokemon(Integer pokemonId, Integer rejuvenatorId, IntegerLocation2D targetLocation)
			throws NotFoundException;

	/**
	 * Moves the rejuvenator to targetLocation
	 * 
	 * @param rejuvenatorId
	 * @param targetLocation
	 * @throws InvalidLocationException
	 *             If targetLocation is occupied by another
	 *             pokemon,hunter,rejuvenator
	 * @throws NotFoundException
	 *             If the rejuvenatorId does not exist
	 */
	public void moveRejuvenator(Integer rejuvenatorId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException;
}
