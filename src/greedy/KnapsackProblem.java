package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {

	static float getOptimizedProfit(int[][] profitWeight, int n, int m) {

		
		// calculate p/w ratio
		float[][] pw = new float[n][2];
		for(int i=0; i<n; i++) {
			pw[i][0] = (float) profitWeight[i][0] / (float)profitWeight[i][1];
			pw[i][1] =i;
		}
		
		//Arrays.sort(pw, new myComparator());
		Arrays.sort(pw, new myComparator() {   // here we are using anonymous inner class
			@Override
			public int compare(float[] o1, float[] o2) {
				return Float.compare(o2[0], o1[0]);
			}
		});
		
		float result = 0;
		// calculate profit
		float remainingSize = m;
		for(int i=0;i<n && remainingSize >0; i++) {
			float pwRatio = pw[i][0];
			int index = (int)pw[i][1];
			if(remainingSize< profitWeight[index][1]) {
				result += (remainingSize/profitWeight[index][1])*profitWeight[index][0];
				remainingSize = 0;
			}else {
				result += profitWeight[index][0];
				remainingSize -= profitWeight[index][1];
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] profitWeight = new int[][] {{10,2},{5,3},{15,5},{7,7},{6,1},{18,4},{3,1}}; // int is primitive type so constructor is not required
		
		System.out.println(getOptimizedProfit(profitWeight, profitWeight.length, 15));
	}
}
class myComparator implements Comparator<float[]>{

	@Override
	public int compare(float[] o1, float[] o2) {
		return (int)(o1[0] - o2[0]);
	}
	
}
