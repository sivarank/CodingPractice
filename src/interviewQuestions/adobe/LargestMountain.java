package interviewQuestions.adobe;

import java.util.ArrayList;
import java.util.Arrays;

/*
You may recall that an array arr is a mountain array if and only if:
    arr.length >= 3
    There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray
case1:
1 2 4 5 3 2 1  2 3 6 8 9 4 3 2 1 6
ans)1  2 3 6 8 9 4 3 2 1 

case2:
1 2 4 5

ans) 0

case3: 5 4 3 2
ans) 0


finalAns
currrentAns
Print ansLeftIndex and ansRightIndex

 */
public class LargestMountain {
	static Integer findLongestMountain(ArrayList<Integer> arr) {
		if(arr.size() < 3) {
			return 0;
		}
		int ans = 0;
		int ansLeftIndex = -1, ansRightIndex = -1;
		int curentLeftIndex = -1;
		if(arr.get(0)<arr.get(1)) {
			curentLeftIndex = 0;
		}
		for(int index = 1; index < arr.size(); index++) {
			if((arr.get(index) < arr.get(index-1)) && ( index+1 <arr.size() &&   arr.get(index) < arr.get(index+1))) {
				if(curentLeftIndex != -1 && ans < index-curentLeftIndex+1) {
					ansLeftIndex = curentLeftIndex;
					ansRightIndex = index;
					ans = index-curentLeftIndex+1;
				}
				curentLeftIndex = index;
			}
		}
		System.out.println("ArraySize : "+arr.size());
		System.out.println("leftIndex : "+ansLeftIndex);
		System.out.println("ansRightIndex : "+ansRightIndex);
		return ans;
	}
		  
	public static void main(String[] args) {
		System.out.println(findLongestMountain(new ArrayList<Integer>( Arrays.asList(1, 2, 4, 5, 3, 2, 1,  2, 3, 6, 8, 9, 4, 3, 2, 1, 6))));

	}
	// below code answered in the interview
	static Integer findLongestMountain1(ArrayList<Integer> arr) {
		if (arr.size() < 3) {
			return 0; // error handling
		}

		Integer leftIndex = 0;
		Integer rightIndex = 1;
		Boolean isUpdirection = true;
		Integer ans = 0;
		Integer ansStartIndex = 0;
		Boolean reachedPeak = false;
		Integer currentAns = 0;
		while (rightIndex < arr.size()) {
			if (isUpdirection) {
				if (arr.get(rightIndex - 1) < arr.get(rightIndex)) {
					rightIndex++;
				} else { // reached peak of the mountain
					isUpdirection = false;
					rightIndex++;
					if ((rightIndex - 2 >= 0 && arr.get(rightIndex - 2) < arr.get(rightIndex - 1))) {
						reachedPeak = true;
					}
				}
			} else {
				if (arr.get(rightIndex - 1) > arr.get(rightIndex)) {
					rightIndex++;
				} else { // reached right bottom, check answer
					currentAns = rightIndex - leftIndex;
					if (reachedPeak && ans < currentAns) {
						ans = currentAns;
						// ansStartIndex = leftIndex;
					}
					leftIndex = rightIndex - 1;
					isUpdirection = true;
					reachedPeak = false;
				}
			}
		}

		if (reachedPeak && ans < currentAns) {
			ans = currentAns;
			ansStartIndex = leftIndex;
		}

		return ans < 3 ? null : ans;
	}

}
