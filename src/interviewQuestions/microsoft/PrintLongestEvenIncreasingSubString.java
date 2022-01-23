package interviewQuestions.microsoft;
/*
 *   TC1: ""
 *   TC2: "1"
 *   TC3: "2"
 *   Tc4: "24"
 *   Tc4: "245244"
 */
public class PrintLongestEvenIncreasingSubString {

	public static void main(String[] args) {
		String str = "12446888217262102429";
		int currentLeftIndex = -1;
		//find first evenNumber
		int i=0; 
		while((i  < str.length()) && ((str.charAt(i)-'0')%2 != 0)) {
			i++;
		}
		
		if(i == str.length()) {
			System.out.println("There is no even number in input");
		}else {
			currentLeftIndex = i;
			int max = 0;
			int maxLeftIndex = 0;
			while(i<str.length()) {
				if((str.charAt(i)-'0')%2 != 0) {
					if(i-currentLeftIndex  > max) {
						maxLeftIndex = currentLeftIndex;
						max = i-currentLeftIndex ;
					}
					currentLeftIndex = i+1;
				}
				i++;
			}
			
			if(i - currentLeftIndex > max) {
				maxLeftIndex = currentLeftIndex;
				max = i-currentLeftIndex ;
			}
			
			System.out.println(str.substring(maxLeftIndex, maxLeftIndex+max));
		}

	}

}
