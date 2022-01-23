package interviewQuestions.microsoft;

import java.util.Stack;

/*
 *  Reverse stack elements without using buffer
 *  
 *   
 *      1
 *      2
 *      3
 *      4
 *      ===
 */
public class ReverseStack {
	
	private static void recursivePush(Stack<Integer> stk, int elm, int index) {
		if(index == 0) {
			stk.push(elm);
		}else {
			int val = stk.pop();
			recursivePush(stk, elm, index-1);
			stk.push(val);
		}
	}
	private static void reverseStack(Stack<Integer> stk) {
		int size = stk.size();
		for(int i=0; i<size; i++) {
			int val = stk.pop();
			recursivePush(stk, val, size-i-1);
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(4);
		stk.push(3);
		stk.push(2);
		stk.push(1);
		System.out.println(stk.toString());		
		reverseStack(stk);
		System.out.println(stk.toString());				
	}

}
