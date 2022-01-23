package interviewQuestions.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 *  Start time: 15:24 pm 23rd -Jan -2022
 *  end time:15:50
 */

/*
 *   [10,30] [30, 35][40,45][46,55]
 */
public class MergeTimeIntervals {
	
	static boolean IsThereOverlapping(ArrayList<Integer> slotA, ArrayList<Integer> slotB) {
		return slotA.get(1) >= slotB.get(0);
	}

	private static ArrayList<ArrayList<Integer>> mergeTimeIntervals(ArrayList<ArrayList<Integer>> input) {
		// edge case
		if (input.size() < 2) {
			return input;
		}
		// sort by start time
		Collections.sort(input, (a, b) -> a.get(0) - b.get(0));

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int i=1;
		ArrayList<Integer> currentInterval = new ArrayList<Integer>();
		currentInterval.add(input.get(0).get(0));
		currentInterval.add(input.get(0).get(1));
		while( i < input.size() ) {
			if(IsThereOverlapping(currentInterval, input.get(i))) {
				currentInterval.set(1,  Math.max(currentInterval.get(1), input.get(i).get(1)));
			}else {
				result.add(new ArrayList<Integer>(currentInterval));
				currentInterval = input.get(i);
			}
			i++;
		}
		result.add(new ArrayList<Integer>(currentInterval));
		return result;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(new ArrayList<Integer>(Arrays.asList(46,55)));
		input.add(new ArrayList<Integer>(Arrays.asList(30,35)));
		input.add(new ArrayList<Integer>(Arrays.asList(40,45)));
		input.add(new ArrayList<Integer>(Arrays.asList(10,30)));
		
		System.out.println(mergeTimeIntervals(input));
	}

}


