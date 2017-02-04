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

	@Test
	public void testInsertionSort() {
		String[] wordsToSort = new String[]{"cat", "bear"};
		AnagramUtil.insertionSort(wordsToSort, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(o1.charAt(0) > o2.charAt(0)){
					return 0;
				}else{
					return 1;
				}
			}	
		});
		
		assertEquals(new String[]{"bear", "cat"}[0], wordsToSort[0]);
	}

}
