/**
 * 
 */
package edu.institution.finalproj;

import java.util.Set;

/**
 * Return a set with all words from the anagram_data.txt file
 * 
 * Return the set, or an empty set if no words are found
 *
 */
public interface AnagramDataReader {

	Set<String> readData();
	
}
