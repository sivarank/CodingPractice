package interviewQuestions.google;
/*
 Given 2D array. Find a maximum path from 1st row to last row. There is a penality if you change column from one row to another. 
 We need to deduct penality from path sum. 
 
 1 penality if you change 1 column. Say change from 0th column to 1st column or 3rd to 2nd. 
 2 penality if you chnage 2 columns.  
  
 */
public class MaxSumPenalityPAths {

	public static void main(String[] args) {
		int[][] input = new int[][] {
			{1,3,3,4,5},
			{4,1,3,2,1},
			{9,2,5,6,1},
			{7,6,9,8,7},
			{7,2,9,1,5}};
		
		int len = input.length;
		
		int[][] table = new int[input.length][input[0].length];
		int numRows = table.length;
		int numCols = table[0].length;
		for(int index =0 ; index <numCols; index++ ) {
			table[numRows-1][index] = input[numRows-1][index];
		}
		
		for(int row = numRows-2; row>=0; row-- ) {
			System.out.println("row : "+row);
			for(int col=0; col< numCols; col++) {
				int maSum = 0;
				for(int index =0; index <numCols; index++) {
					maSum = Math.max(maSum, table[row+1][index]-Math.abs(col-index));
				}
				table[row][col] =  maSum + input[row][col];
				System.out.print(table[row][col]+" ");
			}
			System.out.println("");
		}
		
		int ans = 0;
		for(int col = 0; col<table[0].length; col++) {
			ans = Math.max(ans, table[0][col]);
		}
		System.out.println(ans);
	}
}
