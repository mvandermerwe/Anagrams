/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class for setting up and running our anagram algorithm.
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class Main {
	//runs methods of AnagramUtil class for analysis
	public static void main(String[] args) {
		AnagramUtil nagARam = new AnagramUtil();
		Random r = new Random();

		int numOfExperiments = 200;

		long startTime;
		long endTime;

		//Warms up timer.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 5_000_000_000.);

		//Warms up areAnagrams (we think).
		for (int dummy = 0; dummy < 3; dummy++) {
			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				AnagramUtil.areAnagrams("thomas","mark");
			}
		}

		//creates words of random length from 0 to 132000 while doubling from 1
		for (int wordLength = 0; wordLength < 132000; wordLength = 2 * wordLength + 1) {
			long[] experimentResults = new long[numOfExperiments];
			
			//runs test multiple time for average
			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				String[] words = new String[2];
				for (int word = 1; word < 3; word++) {
					String wordTemp = "";
					for (int index = 0; index < wordLength; index++) {
						wordTemp += (char) (r.nextInt(26) + 'a');
					}
					words[word - 1] = wordTemp;
				}
				
				//starts timing of areAnagrams
				startTime = System.nanoTime();
				AnagramUtil.areAnagrams(words[0], words[1]);
				endTime = System.nanoTime();

				//stores results from each test into an array
				experimentResults[numOfExperiment] = endTime - startTime;
			}
			
			//gathers, calculates, and then prints average
			long sum = 0;
			for (int index = 0; index < numOfExperiments; index++) {
				sum += experimentResults[index];
			}
			System.out.println(wordLength + " " + (sum / numOfExperiments));
		}

		//takes in file to test
		String[] words = AnagramUtil.getStringsFromFile("words_english");
		
		//takes specifically words from 0 until then end of the list while double from 1
		for (int wordSetLength = 0; wordSetLength < words.length; wordSetLength = 2 * wordSetLength + 1) {
			long[] experimentResults = new long[numOfExperiments];

			String[] wordsSet = new String[wordSetLength];
			for(int index = 0; index < wordSetLength; index++){
				wordsSet[index] = words[index];
			}
			
			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				//starts timing of getLargestAnagramGroup
				startTime = System.nanoTime();
				AnagramUtil.getLargestAnagramGroup(wordsSet);
				endTime = System.nanoTime();

				experimentResults[numOfExperiment] = endTime - startTime;
			}
			
			//calculates averages and prints
			long sum = 0;
			for (int index = 0; index < numOfExperiments; index++) {
				sum += experimentResults[index];
			}
			System.out.println(wordSetLength + " " + (sum / numOfExperiments));
		}
		
		//Uses same word set from file above and same number of words
		for (int wordSetLength = 0; wordSetLength < words.length; wordSetLength = 2 * wordSetLength + 1) {
			long[] experimentResults = new long[numOfExperiments];
			
			//puts specific amoung of words from list into an array
			String[] wordsSet = new String[wordSetLength];
			for(int index = 0; index < wordSetLength; index++){
				wordsSet[index] = words[index];
			}
			
			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				
				//start timing for insertionSort
				startTime = System.nanoTime();
				AnagramUtil.insertionSort(wordsSet, new Comparator<String>(){
					@Override
					public int compare(String wordOne, String wordTwo) {
						// sorts anagrams
						if (AnagramUtil.areAnagrams(wordOne, wordTwo)) {
							return 0;
						}
						return -1;
					}
				});
				endTime = System.nanoTime();

				experimentResults[numOfExperiment] = endTime - startTime;
			}

			//calculates and prints averages
			long sum = 0;
			for (int index = 0; index < numOfExperiments; index++) {
				sum += experimentResults[index];
			}
			System.out.println(wordSetLength + " " + (sum / numOfExperiments));
		}

	}
}

