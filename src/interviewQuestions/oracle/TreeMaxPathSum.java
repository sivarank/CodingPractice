package interviewQuestions.oracle;

public class TreeMaxPathSum {
	private static int maxSum;

	public static void main(String[] args) {
		/*
		 * TreeNode root = new TreeNode(5); root.left = new TreeNode(10); root.right =
		 * new TreeNode(12);
		 */
		/*
		 * TreeNode root = new TreeNode(-10); root.left = new TreeNode(14); root.right =
		 * new TreeNode(20); root.right.left = new TreeNode(15); root.right.right = new
		 * TreeNode(7);
		 */

		TreeNode root = new TreeNode(-10);
		root.left = new TreeNode(-14);
		root.right = new TreeNode(-20);
		root.right.left = new TreeNode(-15);
		root.right.right = new TreeNode(7);

		findPathSum(root);
		System.out.println("maxSum is : " + maxSum);
	}

	private static int findPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftSum = findPathSum(root.left);
		int rightSum = findPathSum(root.right);

		int currentSum = 0;
		if (leftSum > 0) {
			currentSum = leftSum;
		}
		if (rightSum > 0) {
			currentSum += rightSum;
		}
		currentSum += root.data;

		maxSum = Math.max(maxSum, currentSum);

		int returnSum = root.data;
		returnSum = Math.max(returnSum, root.data + leftSum);
		returnSum = Math.max(returnSum, root.data + rightSum);
		return returnSum;
	}
}
/*
 * Time compelxity is O(n) Space complexity is O(n)
 */

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	TreeNode(int value) {
		this.data = value;
	}
}

/*
 * root is +ve all other children -ve 



1. root is null 
2. single node but it is -10 ;  // my code does not work
3. all +ve numbers
4. all left children -ve 
5. all right children -ve
6. only leaf children -ve 

7. Integer over  prime



   -10
   / \ 
  14  20 
     / \ 
    15  7 
    
    100
    /  \
 -50   80
       /
      -70
*/

/* 
Your previous Plain Text content is preserved below:


/*
Binary Tree Maximum Path Sum 
A node can only appear in the sequence at most once.

Given the root of a binary tree, return the maximum path sum of any path.


   5
  / \
 10  12  
 
 Answer = 27
 
 

    
 Answer = 42    
 
 
 

 
 left = 14 , right = 35 , rootvalue = -10  currentSum= 39  
 maxSum = Math.max(currentSum, maxSum);
 
 
 
 10
 
 
 private int maxSum ; 

*/
