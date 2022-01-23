package interviewQuestions.oracle;

import java.util.Arrays;

public class BRRoundDiceSum {
	private static int matchCount(int currentDiceNumber, int[] result, int numOfDices, int targetSum) {
		// base condition
		if (numOfDices == currentDiceNumber) {
			int currentSum = 0;
			for (int i = 0; i < numOfDices; i++) {
				currentSum += result[i];
			}
			if(targetSum == currentSum) {
				System.out.println(Arrays.toString(result));
			}
			return targetSum == currentSum ? 1 : 0;
		}

		int matchSum = 0;
		for (int i = 1; i <= 6; i++) {
			if ((currentDiceNumber == 0) || (currentDiceNumber > 0 && result[currentDiceNumber - 1] <= i)) {
				result[currentDiceNumber] = i;
				matchSum += matchCount(currentDiceNumber + 1, result, numOfDices, targetSum);
			}
		}
		return matchSum;
	}

	private static int countCombinations(int numOfDice, int targetNum) {
		if (targetNum < numOfDice || targetNum > 6*numOfDice) {
			return 0;
		}
		int[] result = new int[numOfDice];

		return matchCount(0, result, numOfDice, targetNum);
	}

	public static void main(String[] args) {
		System.out.println(countCombinations(4, 12));
		System.out.println(countCombinations(4, 6));
	}
}
