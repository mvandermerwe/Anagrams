/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

import java.util.Comparator;

/**
 * 
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class AnagramUtil {

	/** 
	 * This method returns the sorted version of the input string. The
	 * sorting must be accomplished using an insertion sort.
	 * 
	 * @param word: word to have letters sorted
	 * @return anagramRepresentation: the word with letters sorted
	 */
	public static String sort(String word) {
		Character[] charsInWord = new Character[word.length()];
		int index = 0;
		for (Character character : word.toLowerCase().toCharArray()) {
			charsInWord[index] = character;
			index++;
		}

		AnagramUtil.insertionSort(charsInWord, new Comparator<Character>() {

			@Override
			public int compare(Character right, Character left) {
				return right.compareTo(left);
			}

		});

		String anagramRepresentation = "";
		for (Character character : charsInWord) {
			anagramRepresentation += character;
		}

		return anagramRepresentation;
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param arrayToSort
	 *            - array of T to sort using the comparator.
	 * @param comparator
	 *            - custom comparator for type T (and subclasses) to order
	 *            values.
	 */
	public static <T> void insertionSort(T[] arrayToSort, Comparator<? super T> comparator) {
		// Go through each position.
		for (int index = 1; index < arrayToSort.length; index++) {
			// Store positions of indices to be modified later.
			int index1 = index;
			int index2 = index1 - 1;
			// If the value is less than the one before it (in whatever way
			// determined), switch places.
			while (index1 != 0 && comparator.compare(arrayToSort[index1], arrayToSort[index2]) < 0) {
				// Switch values in index and its predecessor
				T first = arrayToSort[index2];
				arrayToSort[index2] = arrayToSort[index1];
				arrayToSort[index1] = first;
				// Change indices accordingly.
				index1--;
				index2--;
			}
		}
	}

	/**
	 * This method returns true if the two input strings are anagrams of each
	 * other, otherwise returns false.
	 * 
	 * @param wordOne: the first word to compare
	 * @param wordTwo: the second word to compare with
	 * 
	 * @return the result of the two words are anagrams
	 */
	public static boolean areAnagrams(String wordOne, String wordTwo) {
		return sort(wordOne).equals(sort(wordTwo));
	}

	/** 
	 * This method returns the largest group of anagrams in the input
	 * array of words, in no particular order. It returns an empty array if
	 * there are no anagrams in the input array.
	 * 
	 * @param nameToBeChanged
	 * @return 
	 */
	public static String[] getLargestAnagramGroup(String[] nameToBeChanged) {

		insertionSort(nameToBeChanged, new Comparator<String>() {

			@Override
			public int compare(String wordOne, String wordTwo) {
				//sorts anagrams
				if(areAnagrams(wordOne, wordTwo))
				{
					return 0;
				}
				return -1;
			}

		});

		// Placeholder.
		return new String[] { "" };
	}

	/** Behaves the same as the previous method, but reads the list of
	 * words from the input filename. It is assumed that the file contains
	 * one word per line. If the file does not exist or is empty, the method
	 * returns an empty array because there are no anagrams.
	 * 
	 * @param nameToBeChanged
	 * @return
	 */
	public static String[] getLargestAnagramGroup(String nameToBeChanged) {
		// Placeholder.
		return new String[] { "" };
	}
}
