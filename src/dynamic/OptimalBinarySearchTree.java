package dynamic;

public class OptimalBinarySearchTree {

	public static void main(String[] args) {

		int[] frequency = new int[] {0,4,2,6,3};
		int n = 5;
		int[][] mem = new int[n][n];
		int[] sumFrequency = new int[n];
		
		for(int i=1; i<n ; i++) {
			sumFrequency[i] = sumFrequency[i-1] + frequency[i]; 
		}
		
		for(int d = 1; d < n; d++) {
			for(int i = 0; i+d<n; i++) {
				int j = i+d;
				int min = Integer.MAX_VALUE;
				for(int k = i+1; k<=j ; k++) {
					int val =0;
					if(k+1 <=j) {
						val = mem[i][k-1] + mem[k][j];
					}else {
						val = mem[i][k-1] ;
					}
					min = Math.min(min, val);
				}
				min += sumFrequency[j] - sumFrequency[i];
				mem[i][j] = min;
			}
		}
		System.out.println(mem[0][4]);
	}

}
