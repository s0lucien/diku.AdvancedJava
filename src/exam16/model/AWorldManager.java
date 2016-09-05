package exam16.model;

import java.util.Set;

import exam16.interfaces.HunterWorldManger;
import exam16.interfaces.PokemonWorldManager;
import exam16.interfaces.RejuvenatorWorldManger;
import exam16.interfaces.WorldViewChanger;

/**
 * Concrete implementation of the pokemon world manager residing on the server
 * which supports all the operations to read and manipulate the pokemon world
 * TODO: Implement all the methods
 * 
 * @author bonii
 *
 */
public class AWorldManager implements PokemonWorldManager, RejuvenatorWorldManger, HunterWorldManger, WorldViewChanger {

	public AWorldManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<ImmutablePokemonWorldEntity> getNearbyEntities(IntegerLocation2D worldLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer createEntity(IntegerLocation2D spawnLocation, EntityType typeOfEntity)
			throws InvalidLocationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroyEntities(Set<Integer> entityIds) throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void killPokemon(Integer pokemonId, Integer hunterId, IntegerLocation2D pokemonLocation)
			throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveHunter(Integer hunterId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejuvenatePokemon(Integer pokemonId, Integer rejuvenatorId, IntegerLocation2D targetLocation)
			throws NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRejuvenator(Integer rejuvenatorId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePokemon(Integer pokemonId, IntegerLocation2D targetLocation)
			throws InvalidLocationException, NotFoundException {
		// TODO Auto-generated method stub
		
	}

}
