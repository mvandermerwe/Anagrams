/**
 * Mark Van der Merwe and Thomas Oh
 */
package assignment04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Main class for setting up and running our anagram algorithm.
 * 
 * @author markvandermerwe and Thomas Oh
 *
 */
public class Main {
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

		/*
		for (int wordLength = 0; wordLength < 132000; wordLength = 2 * wordLength + 1) {
			long[] experimentResults = new long[numOfExperiments];

			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				String[] words = new String[2];
				for (int word = 1; word < 3; word++) {
					String wordTemp = "";
					for (int index = 0; index < wordLength; index++) {
						wordTemp += (char) (r.nextInt(26) + 'a');
					}
					words[word - 1] = wordTemp;
				}

				startTime = System.nanoTime();
				AnagramUtil.areAnagrams(words[0], words[1]);
				endTime = System.nanoTime();

				experimentResults[numOfExperiment] = endTime - startTime;
			}

			long sum = 0;
			for (int index = 0; index < numOfExperiments; index++) {
				sum += experimentResults[index];
			}
			System.out.println(wordLength + " " + (sum / numOfExperiments));
		}
		*/
		String[] words = AnagramUtil.getStringsFromFile("words_english");
		
		for (int wordSetLength = 0; wordSetLength < words.length; wordSetLength = 2 * wordSetLength + 1) {
			long[] experimentResults = new long[numOfExperiments];

			String[] wordsSet = new String[wordSetLength];
			for(int index = 0; index < wordSetLength; index++){
				wordsSet[index] = words[index];
			}
			
			for (int numOfExperiment = 0; numOfExperiment < numOfExperiments; numOfExperiment++) {
				
				startTime = System.nanoTime();
				AnagramUtil.getLargestAnagramGroup(wordsSet);
				endTime = System.nanoTime();

				experimentResults[numOfExperiment] = endTime - startTime;
			}

			long sum = 0;
			for (int index = 0; index < numOfExperiments; index++) {
				sum += experimentResults[index];
			}
			System.out.println(wordSetLength + " " + (sum / numOfExperiments));
		}

	}
}
