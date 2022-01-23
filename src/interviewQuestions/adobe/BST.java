package interviewQuestions.adobe;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
 */

public class BST {

		  
	public static void main(String[] args) {
		
		int[] arr = {1,5,10,15,20,25,30,35,40,45};
		System.out.println(bst(arr, 10));
		System.out.println(bst(arr, 11));
	}

	private static int  bst(int[] arr, int key) {
		int left = 0, right = arr.length;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				left = mid + 1;
			} else { // mid > key
				right = mid - 1;
			}
		}
			return right + 1;
	}

}
