package interviewQuestions.google;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxDecrements {
	/*
	 *  [1,2]  2 
	 *  [3 2 3] 3
	 */

	
	static Integer findMinimumDecrements(ArrayList<Integer> arr) {
		if (arr.size() < 2) {
			return arr.isEmpty() ? 0 : 1;
		}
		boolean foundAnswer = false;
		int minDecrements = 0;
		while (!foundAnswer) {
			foundAnswer = true;
			Integer minNum = Integer.MAX_VALUE;
			Integer startIndex = 0;
			for (int index = 0; index <= arr.size(); index++) {
				if (index == arr.size() || arr.get(index) == 0) {
					if (minNum == Integer.MAX_VALUE) {
						startIndex = index + 1;
						continue;
					}
					minDecrements += 1; // minDecrements = 1+ 2 + 4 = 7
					rangeDecrement(arr, startIndex, index - 1, minNum); // [2,0,4] ==> [0,0,4] ==> [0,0,0]
					minNum = Integer.MAX_VALUE;
					startIndex = index + 1;// 4, 1, 4

				} else {
					foundAnswer = false;
					if (minNum > arr.get(index)) {
						minNum = arr.get(index); // minNum = 3 , 1, 1 == 2, ==4
					}
				}
			}
		}
		return minDecrements;
	}

	
	private static void rangeDecrement(ArrayList<Integer> arr, Integer startIndex, int endIndex, Integer minNum) {
		while (startIndex <= endIndex) {
			arr.set(startIndex, arr.get(startIndex) - minNum);
			startIndex++;
		}
	}
	static Integer findMinimumDecrementsOptimized(ArrayList<Integer> arr) {
		if (arr.size() < 2) {
			return arr.isEmpty() ? 0 : 1;
		}
		int previousNum = arr.get(0);
		int count = 1;
		for(int index = 1; index < arr.size(); index++) {
			if(previousNum != arr.get(index)) {
				count++;
				previousNum = arr.get(index);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(findMinimumDecrements(new ArrayList(Arrays.asList(5, 7, 2, 10, 6)))); // 1 (2), 1(3), 1(2), 1(4), 1(4)
		System.out.println(findMinimumDecrementsOptimized(new ArrayList(Arrays.asList(5, 7, 2, 10, 6))));
		System.out.println(findMinimumDecrements(new ArrayList(Arrays.asList(5, 5, 5, 5, 5))));
		System.out.println(findMinimumDecrementsOptimized(new ArrayList(Arrays.asList(5, 5, 5, 5, 5))));
		//5->8, 8->5, 5->7,  7->2, 2->10,10->6, 6->5
		// 1, 1,1,1,1,1,1,1
		System.out.println(findMinimumDecrements(new ArrayList(Arrays.asList(5, 5, 8,5, 7, 2, 10, 6, 5, 5))));
		System.out.println(findMinimumDecrementsOptimized(new ArrayList(Arrays.asList(5, 5, 8,5, 7, 2, 10, 6, 5, 5))));
	}
}
/*
 * Given that you have to start from a zero array of length N 
and reach a given array of unique natural numbers using only a range increment operator, find the minimum number of operations needed.
  
  

zero array of length N ?
  
N = 5
  
  st = [ 0 0 0 0 0 ]
  
  dst = [ 5 7 2 10 6 ] 
  
  
  [2,2,2,2,2]= O(n)
  [2,2] = 2
  [2,3] = 2 + 1
  [2,3,4,5]
  [4,2,5,3] = [2,0,3,1] == 1 decrement by 2
              [0,0,3,1] == 1 decrement by 2
              [0,0,3,1] == 1 decrement by 1
              [0,0,2,0] == 1 by 2 
  
  RI(st, end)
  
  [ 1 1 1 2 2 ]
  RI(1, 3)
  
 [ 1 2 2 3 2 ]
  
  ======
  
  TC1: [10] -- 10 ans
  TC2: [5,7] - RI(0,1) - 5  = 7  --- max element 
               RI(1,1) - 2  

  TC3: [3, 1, 5, 2] = [2,0,4,1] = RD(0,3) = 1
                       [2] min =2 RD(0,0) = 2
                       [4,1]= min =1        1
                       [3,0]
                        [3] = 3
    
    [8,0,8]
   Time complexity :    O(n*n) - 
     O(n*K) -  wrong
     
     [1]
     [2,3] == [2,3] (0,1,2) 
              [0,1] () 
     
     [3,1,500]

 */
