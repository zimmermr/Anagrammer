package edu.institution.finalproj;

import java.util.List;

/*
 * Return a list of words from the supplied string.
 * 
 * @param anagram: the anagram to evaluat
 * @param option: command line option
 * 		nf = all potential anagram permutations of the string
 * 		words = only actual words returned
 * if null, default to "words"
*/

public interface AnagramEvaluator {
	
	List<String> evaluate(String anagram, String option);
	
}
