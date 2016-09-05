package exam16.model;

public final class IntegerLocation2D {
	private final Integer xCoordinate;
	private final Integer yCoordinate;

	public IntegerLocation2D(int xCoordinate, int yCoordinate) {
		this.xCoordinate = new Integer(xCoordinate);
		this.yCoordinate = new Integer(yCoordinate);
	}

	public Integer getXCoordinate() {
		return xCoordinate;
	}

	public Integer getYCoordinate() {
		return yCoordinate;
	}
}
