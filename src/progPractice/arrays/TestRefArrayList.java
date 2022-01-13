package progPractice.arrays;
import java.util.ArrayList;
public class TestRefArrayList {

	private static void test(ArrayList<Integer> arr) {
		arr.set(0, arr.get(0)+2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		test(arr);
		System.out.print(arr.get(0));
	}

}
