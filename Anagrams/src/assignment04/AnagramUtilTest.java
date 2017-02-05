/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.Test;

/**
 * Test class for our AnagramUtil functionality.
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class AnagramUtilTest {

	/**
	 * Tests insertion sort for Strings, Integers, and Characters.
	 */
	@Test
	public void testInsertionSort() {
		String[] wordsToSort = new String[] { "cat", "bear" };
		AnagramUtil.insertionSort(wordsToSort, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// Compare them lexographically in this case (by first letter).
				return o1.charAt(0) - o2.charAt(0);
			}
		});
		assertArrayEquals(new String[] { "bear", "cat" }, wordsToSort);

		Integer[] numsToSort = new Integer[] { 1, 45, 3, 79, 19, 3, 8, 5, 7, 4, 2, 5 };
		AnagramUtil.insertionSort(numsToSort, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// Compare them by simple integer value.
				return o1 - o2;
			}

		});
		assertArrayEquals(new Integer[] { 1, 2, 3, 3, 4, 5, 5, 7, 8, 19, 45, 79 }, numsToSort);

		Character[] charsToSort = new Character[] { 'c', 'd', 'y', 'e' };
		AnagramUtil.insertionSort(charsToSort, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				// Compare characters lexographically.
				return o1 - o2;
			}

		});
		assertArrayEquals(new Character[] { 'c', 'd', 'e', 'y' }, charsToSort);
	}

}
