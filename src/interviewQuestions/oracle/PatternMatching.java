package interviewQuestions.oracle;
/*
 * dynamic programming can be used to solve this 
 */
public class PatternMatching {
/*
 *        abbba
 *        ab*
 *        abb*ba*
 *        *
 */
	/*
	 *   MAtch(i,j) =  match(i-1, j-1)  if p[i] == t[j]  or p[i] == '?'
	 *              =  match(i-1, j) || match(i, j-1)                 if p[i] == '*'  (null, match)
	 *              = false  
	 */
	private static boolean matchPattern(String pattern, String text) {
		int m = pattern.length();
		int n = text.length();
		boolean table[][] = new boolean[m+1][n+1];
		// initialize first row and first column
		table[0][0] = true;
		if(pattern.charAt(0) == '*') {
			for(int i=1; i<= n; i++) {
				table[0][i] = true;
			}
		}
		for(int i=1; i<= m; i++) {
			for(int j=1; j<= n; j++) {
				if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
					table[i][j] = table[i-1][j-1];
				}else if(pattern.charAt(i-1) == '*') {
					table[i][j] = table[i-1][j] || table[i][j-1];
				}
			}
		}
		return table[m][n];		
	}
	
	public static void main(String[] args) {
		System.out.println(matchPattern("*", "abcds"));
		System.out.println(matchPattern("a*", "abcds"));
		System.out.println(matchPattern("a*b*", "abcds"));
		System.out.println(matchPattern("a*b*s", "abcds"));
		System.out.println(matchPattern("*b*s", "abcds"));
		System.out.println(matchPattern("*b*d?s", "abcds"));
	}

}
