package exam16.interfaces;

import exam16.model.IntegerLocation2D;
import exam16.model.InvalidLocationException;
import exam16.model.NotFoundException;

/**
 * Represents the set of methods that a hunter client can invoke
 * 
 * @author bonii
 *
 */
public interface HunterWorldManger extends WorldViewManager {

	/**
	 * Kills the pokemon if the pokemon identified by the id is still at target
	 * location for the kill. Also check that the pokemon is in the visibility
	 * range of the hunter. Use visibility definition in the WorldViewManager
	 * interface.
	 * 
	 * The thread which is used to simulate the pokemon must be
	 * terminated/suspended (depending upon your design) as well, and the method
	 * should return only when the termination/suspension is complete.
	 * 
	 * @param pokemonId
	 *            Id of the pokemon trying to be killed
	 * @param hunterId
	 *            Id of the hunter trying to kill a pokemon
	 * @param pokemonLocation
	 * @throws NotFoundException
	 *             If the pokemonId does not exist of if the pokemon is not
	 *             present at the location provided in pokemonLocation or the
	 *             hunterId does not exist or the pokemon is not in the
	 *             visibility range of the hunter
	 */
	public void killPokemon(Integer pokemonId, Integer hunterId, IntegerLocation2D pokemonLocation)
			throws NotFoundException;

	/**
	 * Moves the hunter to a target location if the target location is not
	 * occupied already.
	 * 
	 * @param hunterId
	 * @param targetLocation
	 * @throws InvalidLocationException
	 *             If the targetLocation is already occupied by another hunter,
	 *             rejuvenator or pokemon
	 * @throws NotFoundException
	 *             If the hunterId does not exist
	 */
	public void moveHunter(Integer hunterId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException;
}
