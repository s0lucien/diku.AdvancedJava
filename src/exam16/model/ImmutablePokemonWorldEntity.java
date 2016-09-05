package exam16.model;

public final class ImmutablePokemonWorldEntity {
	private final Integer id;
	private final String name;
	private final IntegerLocation2D currentLocation;
	private final EntityType entityType;
	private final Boolean alive;

	public ImmutablePokemonWorldEntity(Integer id, String name, IntegerLocation2D currentLocation,
			EntityType entityType, Boolean alive) {
		this.id = id;
		this.name = name;
		this.currentLocation = currentLocation;
		this.entityType = entityType;
		this.alive = alive;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public IntegerLocation2D getCurrentLocation() {
		return currentLocation;
	}

	public EntityType getEntityType() {
		return entityType;
	}

	public Boolean isAlive() {
		return alive;
	}
	
	@Override
	public boolean equals(Object x) {
		// TODO: Implement here
		return false;
	}

	@Override
	public int hashCode() {
		// TODO: Implement here
		return 42;
	}
}
