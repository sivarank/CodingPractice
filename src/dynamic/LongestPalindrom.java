package dynamic;

public class LongestPalindrom {

	public static void main(String[] args) {
		String str = "32454236";
		int ans= 1;
		int[][] table = new int[str.length()+1][str.length()+1];
		int k = 0;
		while(k <str.length()) {
			for(int i=0; i+k <str.length(); i++ ) {
				if(k==0) {
					table[i][i] = 1;
				}else {
					if((str.charAt(i) == str.charAt(i+k)) && (k == 1 || table[i+1][i+k-1] == k-1)) {
						table[i][i+k] = k+1;
						ans = Math.max(ans, k+1);
					}else {
						table[i][i] = 1;
					}
				}
			}
			k++;
		}
		System.out.println(ans);
	}

}
