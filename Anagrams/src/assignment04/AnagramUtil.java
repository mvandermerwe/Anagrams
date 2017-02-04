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

	// This method returns the sorted version of the input string. The
	// sorting must be accomplished using an insertion sort.
	public static String sort(String nameToBeChanged) {
		//Use insertionSort w/ array of chars.

		//Placeholder.
		return "";
	}

	// This generic method sorts the input array using an insertion sort and
	// the input Comparator object.
	public static <T> void insertionSort(T[] arrayToSort, Comparator<? super T> comparator) {
		for(int index = 1; index < arrayToSort.length; index++){
			int index1 = index;
			int index2 = index1 -1;
			while(index1 != 0 && comparator.compare(arrayToSort[index1], arrayToSort[index2])!=0){
				T first = arrayToSort[index2];
				arrayToSort[index2] = arrayToSort[index1];
				arrayToSort[index1] = first;
				index1--;
				index2--;
			}
		}
	}

	// This method returns true if the two input strings are anagrams of each
	// other, otherwise returns false.
	public static boolean areAnagrams(String nameToBeChanged, String nameToBeChanged2) {

		// Placeholder.
		return false;
	}

	// This method returns the largest group of anagrams in the input
	// array of words, in no particular order. It returns an empty array if
	// there are no anagrams in the input array.
	public static String[] getLargestAnagramGroup(String[] nameToBeChanged) {
		
		insertionSort(nameToBeChanged, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		});

		// Placeholder.
		return new String[] { "" };
	}

	// Behaves the same as the previous method, but reads the list of
	// words from the input filename. It is assumed that the file contains
	// one word per line. If the file does not exist or is empty, the method
	// returns an empty array because there are no anagrams.
	public static String[] getLargestAnagramGroup(String nameToBeChanged) {

		// Placeholder.
		return new String[] { "" };
	}
}
