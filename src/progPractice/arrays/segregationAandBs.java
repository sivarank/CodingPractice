package progPractice.arrays;

public class segregationAandBs {

	private static String recursiveMerge(String a, String b){
		System.out.println(a);
		System.out.println(b);
		if(a.length() == 2){
			return a+b;
		}
		int placeDivider = (a.length()/2) % 2 == 0 ? a.length()/2 : a.length()/2-1;
		String s1 = a.substring(0, placeDivider);
		String s2 = a.substring(placeDivider);
		String s3 = b.substring(0, placeDivider);
		String s4 = b.substring(placeDivider);
		return recursiveMerge(s1,s3) + recursiveMerge(s2,s4);
	}
	public static void main(String[] args) {
		String input = "a1b1c1a2b2c2";
		System.out.println(recursiveMerge(input.substring(0, input.length()/2), input.substring(input.length()/2)));
	}

}
