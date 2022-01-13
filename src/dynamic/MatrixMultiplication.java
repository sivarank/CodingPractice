package dynamic;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int size[] = new int[] {5,4,6,2,7};// (5,4)(4,6)(6,2)(2,7)
		int mem[][] = new int[size.length-1][size.length-1];
		int path[][] = new int[size.length-1][size.length-1];
		int n = size.length -1;
		for(int d = 1; d < n; d++) {
			for(int i=0; i<n-d; i++) {
				int j = i+d;
				int min = Integer.MAX_VALUE;
				for(int k = i; k<j; k++) {
					int value = mem[i][k] + mem[k+1][j] + size[i]*size[k+1]*size[j+1];
					if(value < min) {
						min = value;
						path[i][j] = k;
					}
				}
				mem[i][j] = min;
			}
		}
		System.out.println( mem[0][3]);
	}
}
