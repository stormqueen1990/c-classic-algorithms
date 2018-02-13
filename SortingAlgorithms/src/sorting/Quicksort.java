package sorting;

import java.util.List;

/**
 * Quicksort implementation. Uses the middle pivot rule.
 * 
 * @author mauren
 *
 * @param <T>
 *            the type of collection meant to be sorted. Must be of type list.
 */
public class Quicksort<E extends Comparable<E>, T extends List<E>> {
	/**
	 * Returns the pivot position for the given collection.
	 * 
	 * @param data
	 *            the collection for which a pivot must be chosen.
	 * @param initialPosition
	 *            initial position to be sorted (allows for
	 *            division-and-conquest recursive calls).
	 * @param finalPosition
	 *            final position to be sorted (allows for division-and-conquest
	 *            recursive calls).
	 * @return an {@code int} containing the pivot position value.
	 */
	private int getPivotPosition(T data, int initialPosition, int finalPosition) {
		int size = finalPosition - initialPosition + 1;
		int pivotPos = (size / 2) + initialPosition;

		if (size % 2 == 1)
			pivotPos++;

		return pivotPos;
	}

	/**
	 * Sorts the data using the quicksort algorithm.
	 * 
	 * @param data
	 *            the list of data to be sorted.
	 * @param initialPosition
	 *            initial position to be sorted (allows for
	 *            division-and-conquest recursive calls).
	 * @param finalPosition
	 *            final position to be sorted (allows for division-and-conquest
	 *            recursive calls).
	 */
	public void sort(T data, int initialPosition, int finalPosition) {
		if (initialPosition < finalPosition) {
			int pivotPosition = getPivotPosition(data, initialPosition,
					finalPosition);
			E pivot = data.get(pivotPosition);

			for (int i = initialPosition; i <= finalPosition; i++) {
				E current = data.get(i);

				if (current != null) {
					if (current.compareTo(pivot) < 0 && i > pivotPosition) {
						for (int j = i - 1; j >= pivotPosition; j--) {
							E moving = data.get(j);
							data.set(j + 1, moving);
						}

						data.set(pivotPosition, current);

						pivotPosition++;
						i = -1;
					} else if (current.compareTo(pivot) > 0
							&& i < pivotPosition) {
						for (int j = i + 1; j <= pivotPosition; j++) {
							E moving = data.get(j);
							data.set(j - 1, moving);
						}

						data.set(pivotPosition, current);

						pivotPosition--;
						i = -1;
					}
				}
			}

			if (pivotPosition == initialPosition) {
				sort(data, initialPosition + 1, finalPosition);
			} else if (pivotPosition == finalPosition) {
				sort(data, initialPosition, finalPosition - 1);
			} else {
				sort(data, initialPosition, pivotPosition - 1);
				sort(data, pivotPosition + 1, finalPosition);
			}
		}
	}
}
