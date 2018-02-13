/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import sorting.Quicksort;

/**
 * @author mauren
 *
 */
public class QuicksortValidation {
	/**
	 * Test method for {@link sorting.Quicksort#sort(java.util.List, int, int)}.
	 */
	@Test
	public void testSort() {
		List<Integer> l = new ArrayList<Integer>();
		Random r = new Random(System.currentTimeMillis());
		int size = r.nextInt(100);

		for (int i = 0; i < size; i++) {
			l.add(r.nextInt(Integer.MAX_VALUE));
		}
		
		Quicksort<Integer, List<Integer>> q = new Quicksort<Integer, List<Integer>>();
		q.sort(l, 0, l.size() - 1);

		boolean ordered = true;

		for (int i = 0; i < l.size() - 1; i++)
			if (l.get(i) > l.get(i + 1)) {
				ordered = false;
				break;
			}

		Assert.assertTrue(ordered);
		Assert.assertEquals(size, l.size());
	}
}
