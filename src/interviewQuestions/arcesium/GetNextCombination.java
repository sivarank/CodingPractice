package interviewQuestions.arcesium;

import java.util.ArrayList;
import java.util.List;

/**
DataStructure - next possible combination from string( has to be in lexicographical order)
Iterator -> next(), hasNext()
next() -> next lexicographical combination
hasNext() -> if there exists a next possible combination

Input - String(character are in sorted), K (integer) -> size of combination
 
 Input - "ABCD", K = 2
 
 Output -> 
 next() -> AB
 next() -> AC
 hasNext() -> true
 next() -> AD
 next() -> BC
 next() -> BD
 next() -> CD
 hasNext() -> false
 
 Combinations ->
 AB, AC, AD, BC, BD, CD
 ABC, ABD, ACD, BCD (lexicographically increasing)
*/
public class GetNextCombination {
	private static void getLexiCombinationsHelper(String inputString, int index, int remainingSize, List<String> result,
			char[] comb) {
		if (remainingSize == 0) {
			result.add(new String(comb)); 
		}else if(index < inputString.length()) {
			comb[comb.length - remainingSize] = inputString.charAt(index);
			getLexiCombinationsHelper(inputString, index + 1, remainingSize - 1, result, comb);
			getLexiCombinationsHelper(inputString, index + 1, remainingSize, result, comb); 		
		} 
	}

	private static List<String> getLexiCombinations(String str, int combinationSize) {
		if (str.isEmpty() || combinationSize < 1 || combinationSize > str.length()) {
			return new ArrayList<String>();
		}
		List<String> result = new ArrayList<>();
		char[] comb = new char[combinationSize];
		getLexiCombinationsHelper(str, 0, combinationSize, result, comb);
		return result;
	}

	public static void main(String[] args) {
		List<String> arr = getLexiCombinations("ABCD", 2);
		System.out.println(arr);
	}
}
