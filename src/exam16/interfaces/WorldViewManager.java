package exam16.interfaces;

import java.util.Set;

import exam16.model.ImmutablePokemonWorldEntity;
import exam16.model.IntegerLocation2D;

/**
 * Represents the set of methods that can be used to get a view of the world
 * from a location in the world .
 * 
 * The view of the world is conditioned by the visibility parameter defined in
 * IWorldConstants.WORLD_VISIBILITY. The vicinity is defined by a grid bounded
 * with IWorldConstants.WORLD_VISIBILITY to model the bounds of the grid for
 * both the X and Y coordinate with worldLocation acting as the centre of the
 * grid.
 * 
 * In order to query get a view of the world, the rejuvenator/pokemon/hunter
 * need not be present in the location from which the view is sought.
 * 
 * @author bonii
 *
 */
public interface WorldViewManager {

	/**
	 * Returns the list of game entities (hunters/rejuvenators/pokemons) in the
	 * vicinity of a location.
	 * 
	 * @param worldLocation
	 *            Location from which the view is sought.
	 * @return
	 */
	public Set<ImmutablePokemonWorldEntity> getNearbyEntities(IntegerLocation2D worldLocation);
}
