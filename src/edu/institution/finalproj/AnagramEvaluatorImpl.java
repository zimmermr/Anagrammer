package edu.institution.finalproj;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AnagramEvaluatorImpl implements AnagramEvaluator {

	private static List<String> permList = new ArrayList<>();
	private static List<String> filteredList = new ArrayList<String>();
	
	@Override
	public List<String> evaluate(String anagram, String option) {
		anagram = anagram.toUpperCase();
		char[] searchArray = anagram.toCharArray();
		
		// Bring in a set of the actual words
		AnagramDataReaderImpl reader = new AnagramDataReaderImpl();
		Set<String> wordList = reader.readData();
		
		// Fill the permList Set with all possible combinations
		findPermutations(searchArray, searchArray.length, searchArray.length);
		
		
		if(option.equals("nf")) {
			return permList;
		} else if(option.equals("words") || option.isEmpty() || option.equals(null)) {
			for(String s : permList) {
				if(wordList.contains(s)) {
					filteredList.add(s);
				}
			}
			return filteredList;
		} else {
			List<String> emptyList = new ArrayList<>();
			emptyList.add("The word list is empty.");
			return emptyList;
		}
		
	}
	
	private static void arrayToStringSet(char[] permutation) {
		String newPerm = new String(permutation);
		if(!permList.contains(newPerm)) {
			permList.add(newPerm);
		}
	}
	
	// Algorithm found at: https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/
	private static void findPermutations (char[] searchTerm, int size, int n) {
		if(size == 1) {
			arrayToStringSet(searchTerm);
		}
		
		for (int i = 0; i < size; i++) {
            findPermutations(searchTerm, size - 1, n);
 
            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                char temp = searchTerm[0];
                searchTerm[0] = searchTerm[size - 1];
                searchTerm[size - 1] = temp;
            }
 
            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                char temp = searchTerm[i];
                searchTerm[i] = searchTerm[size - 1];
                searchTerm[size - 1] = temp;
            }
        }
	}

}
