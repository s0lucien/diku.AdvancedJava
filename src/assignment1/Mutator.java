package assignment1;

public interface Mutator<T> {

	/**
	 * A mutation. This method changes the internal state of the given object.
	 * 
	 * @param x
	 *            The object to mutate.
	 */
	public void mutate(T x);

}