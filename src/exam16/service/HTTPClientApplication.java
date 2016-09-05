package exam16.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import exam16.model.EntityType;
import exam16.model.ImmutablePokemonWorldEntity;
import exam16.model.IntegerLocation2D;

public class HTTPClientApplication {
	private static final Random RND = new Random();
	private static final String SERVER = "http://localhost:8080";

	public static void main(String[] args) throws Exception {

		HTTPHunterClientService hunterClient = new HTTPHunterClientService(SERVER);
		HTTPRejuvenatorClientService rejuvenatorClient = new HTTPRejuvenatorClientService(SERVER);
		HTTPWorldChangerClientService worldChangerClient = new HTTPWorldChangerClientService(SERVER);

		Integer hunterId = worldChangerClient.createEntity(getRandomLocation(), EntityType.HUNTER);
		Integer pokemonId1 = worldChangerClient.createEntity(getRandomLocation(), EntityType.POKEMON);
		Integer pokemonId2 = worldChangerClient.createEntity(getRandomLocation(), EntityType.POKEMON);
		Integer rejuvenatorId = worldChangerClient.createEntity(getRandomLocation(), EntityType.REJUVENATOR);

		rejuvenatorClient.moveRejuvenator(rejuvenatorId, getRandomLocation());
		hunterClient.moveHunter(hunterId, getRandomLocation());

		// Let's play!
		Set<ImmutablePokemonWorldEntity> entities = hunterClient.getNearbyEntities(getRandomLocation());
		for (ImmutablePokemonWorldEntity entity : entities) {
			if (entity.getEntityType() == EntityType.POKEMON && entity.isAlive()) {
				hunterClient.killPokemon(entity.getId(), hunterId, entity.getCurrentLocation());
			}
		}

		rejuvenatorClient.moveRejuvenator(rejuvenatorId, getRandomLocation());
		hunterClient.moveHunter(hunterId, getRandomLocation());

		entities = rejuvenatorClient.getNearbyEntities(getRandomLocation());
		for (ImmutablePokemonWorldEntity entity : entities) {
			if (entity.getEntityType() == EntityType.POKEMON && !entity.isAlive())
				rejuvenatorClient.rejuvenatePokemon(entity.getId(), rejuvenatorId, entity.getCurrentLocation());
		}

		Set<Integer> toBeKilledEntities = new HashSet<>();

		toBeKilledEntities.add(rejuvenatorId);
		toBeKilledEntities.add(hunterId);
		toBeKilledEntities.add(pokemonId1);
		toBeKilledEntities.add(pokemonId2);

		worldChangerClient.destroyEntities(toBeKilledEntities);

		// game over :)
	}

	private static IntegerLocation2D getRandomLocation() {
		return new IntegerLocation2D(RND.nextInt(), RND.nextInt());

	}

}
