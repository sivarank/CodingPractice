package dynamic;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
//		String str1 ="longest";
//		String str2 = "stone";
		String str1 ="stone";
		String str2 = "longest";
		int m = str1.length();
		int n = str2.length();
		
		int[][] mem = new int[m+1][n+1];
		
		for(int i=1; i<=m ; i++) {
			for(int j=1; j<= n; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					mem[i][j] = 1+ mem[i-1][j-1];
				}else {
					mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
				}
			}
		}
		
		System.out.println(mem[m][n]);
		
		int i = m;
		int j=n;
		while(i>0 && j>0) {
				// character match
				if(mem[i][j] == 1+ mem[i-1][j-1]) {
					System.out.println(str1.charAt(i-1));
					i--;
					j--;
				}else {
					if(mem[i-1][j] > mem[i][j-1]) {
						i--;
					}else {
						j--;
					}
				}
			}
	}

}
