package interviewQuestions.microsoft;
/*
Input: "I am good"
OutPut:
        I a g
           m o
              o
               o
                d
           
 */
public class PrintStringsVertically {
	public static void main(String[] args) {
		String input = "  I  AM  GOOD  ";
		input = input.trim().replace("\\s+", " ");
		String[] strs = input.split(" ");
		int maxSubStringlength = 0;
		for(String str: strs) {
			maxSubStringlength = Math.max(maxSubStringlength, str.length());
		}
		
		for(int startingIndex =0; startingIndex < maxSubStringlength; startingIndex++) {
			for(int i=startingIndex; i>0; i--) {
				System.out.print(" ");
			}
			for(String str: strs) {
				if(str.length() <= startingIndex ) {
					System.out.print(" ");
				}else {
					System.out.print(str.charAt(startingIndex));
				}
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}
