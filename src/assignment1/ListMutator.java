package assignment1;

import java.util.List;

public interface ListMutator<T> {

	/**
	 * A list mutation. Mutates each element in a list by a given mutation.
	 * 
	 * @param m
	 *            The mutation.
	 * @param l
	 *            The list to mutate.
	 */
	public void listMutate(Mutator<T> m, List<T> l);

}
