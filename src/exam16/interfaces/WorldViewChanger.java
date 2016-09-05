package exam16.interfaces;

import java.util.Set;

import exam16.model.EntityType;
import exam16.model.IntegerLocation2D;
import exam16.model.InvalidLocationException;
import exam16.model.NotFoundException;

/**
 * Represents the set of methods that a pokemon game controller would invoke and
 * manage to manipulate the pokemon world.
 * 
 * @author bonii
 *
 */
public interface WorldViewChanger extends WorldViewManager {

	/**
	 * Create an entity of the respective type, returns after successful
	 * creation of the entity.
	 * 
	 * @param spawnLocation
	 *            The location where the entity is to be created.
	 * @param typeOfEntity
	 *            The type of the entity (rejuvenator/pokemon/hunter)
	 * @return The Id of the entity
	 * @throws InvalidLocationException
	 *             If the location is occupied by another entity
	 */
	public Integer createEntity(IntegerLocation2D spawnLocation, EntityType typeOfEntity)
			throws InvalidLocationException;

	/**
	 * Kills a set of entities i.e., removes them from pokemon world and
	 * terminates/suspends the threads of execution if the entity is a pokemon.
	 * Not an all-or-nothing operation, try to remove as many entities as
	 * possible.
	 * 
	 * @param entityIds
	 *            Ids of hunters to be killed
	 * @throws NotFoundException
	 *             If at least one entity was not found for killing
	 */
	public void destroyEntities(Set<Integer> entityIds) throws NotFoundException;

}
