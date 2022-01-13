package progPractice;

public class CountNumber2s {

	public CountNumber2s() {
		// TODO Auto-generated constructor stub
	}

	private static int get2sCount(int number) {
		if (number < 2) {
			return 0;
		} else if (number < 10) {
			return 1;
		}
		int leftNum = number / 10;
		int rightNum = 0;
		int decimalPosition = 1;
		int count = 0;
		while (rightNum < number) {
			int currentDigit = (number % (decimalPosition * 10)) / decimalPosition;
			count += leftNum * decimalPosition;
			if (currentDigit > 2) {
				count += decimalPosition;
			} else if (currentDigit == 2) {
				count += rightNum + 1;
			}

			leftNum /= 10;
			decimalPosition *= 10;
			rightNum = number % decimalPosition;
		}
		return count;
	}

	static int count2s(int num) {
		int digitPlace = 1;

		int count = 0;
		while (num >= digitPlace) {
			int leftNum = num / (10 * digitPlace); // 3, 0
			int rightNum = digitPlace == 1 ? 0 : num % (digitPlace / 10); // 0, 0
			int currentDigit = (num % (digitPlace * 10)) / digitPlace;// 0,3
			count += leftNum * digitPlace; // 3, 3
			if (currentDigit > 2) {
				count += digitPlace; // 13
			} else if (currentDigit == 2) {
				count += rightNum + 1;
			}
			digitPlace *= 10; // 10, 100
		}
		return count;
	}

	public static void main(String[] args) {
		/*
		 * 
		 * Step1: n/10
		 */

		System.out.println("1123 count =" + get2sCount(1123));
		System.out.println("1123 count =" + count2s(1123));
		System.out.println("1123 count =" + get2sCount(92));

		System.out.println("1123 count =" + count2s(92));

		System.out.println("1123 count =" + get2sCount(35));

		System.out.println("1123 count =" + count2s(35));
	}

}
