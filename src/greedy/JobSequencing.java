package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {

	public static void main(String[] args) {
		int jobs[][] = new int[][] {{15,2},{5,3},{1,3},{20,2},{10,1}};
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o2[0], o1[0]);
			}
		});

		System.out.println(Arrays.toString(jobs));
		int profit = 0;
		boolean slotAssigned[] = new boolean[jobs.length];
		for(int i=0; i< jobs.length; i++) {
			int slot = jobs[i][1];
			for(int j= slot-1; j>= 0;j--) {
				if(!slotAssigned[j]) {
					profit += jobs[i][0];
					slotAssigned[j] = true;
					System.out.println("job number :"+i);
					break;
				}
			}
		}
		System.out.println("profit : "+profit);
	}

}
