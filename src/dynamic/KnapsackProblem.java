package dynamic;

public class KnapsackProblem {

	public static void main(String[] args) {
		int[] p = new int[] {1,2,5,6};
		int[] w = new int[] {2,3,4,5};
		int m = 8;
		int n = 4;
		int[][] mem = new int[n+1][m+1];
		
		for(int  i = 1; i<= n; i++) {
			for(int j = 1; j<= m ; j++) {
				if(j < w[i-1]) {
					mem[i][j] = mem[i-1][j]; 
				}else {
					int profit = p[i-1];
					if(j-w[i-1] > 0) {
						profit += mem[i-1][j-w[i-1]];
					}
					mem[i][j] = Math.max(mem[i-1][j], profit);
				}
			}
		}
		System.out.println(mem[n][m]);
	}

}
