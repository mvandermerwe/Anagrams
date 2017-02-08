/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

/**
 * Main class for setting up and running our anagram algorithm.
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class Main {
	public static void main(String[] args) {
		AnagramUtil nagARam = new AnagramUtil();
		
		String[] wordList = {"cat", "bear", "tac", "act", "neat", "Nate"};
		String[] anagrams = new String[wordList.length];
		
		anagrams = AnagramUtil.getLargestAnagramGroup(wordList);
		for(int index = 0; index < anagrams.length; index++) {
				System.out.println(anagrams[index]);
		}
	}
}
