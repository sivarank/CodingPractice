package progPractice.games;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class TikTokTie {

public enum cellVal
{
	EMPTY, 
	WHITE, 
	BLACK
}



	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		ArrayList<ArrayList<cellVal>> arr = new ArrayList<ArrayList<cellVal>>();
		ArrayList<cellVal> a = new ArrayList<cellVal>();
		a.add(cellVal.BLACK);
		a.add(cellVal.WHITE);
		a.add(cellVal.EMPTY);
		arr.add(a);
		a = new ArrayList<cellVal>();
		a.add(cellVal.WHITE);
		a.add(cellVal.WHITE);
		a.add(cellVal.EMPTY);
		arr.add(a);
		
		a = new ArrayList<cellVal>();
		a.add(cellVal.BLACK);
		a.add(cellVal.WHITE);
		a.add(cellVal.BLACK);
		arr.add(a);
		
		int n = arr.size();
		int diag1 =0, diag2 = 0; 
		for(int i=0 ; i<n; i++) {
			//
			if(arr.get(i).get(i) == arr.get(0).get(0)) {
				diag1++;
			}
			
			if(arr.get(i).get(n-i-1) == arr.get(0).get(n-1)) {
				diag2++;
			}
			int rowSum=0, colSum = 0;
			//Row sum
			for(int j=0; j<n;j++ ) {
				System.out.println(","+arr.get(i).get(j));
				if(arr.get(i).get(j) == arr.get(i).get(0)) {
					rowSum++;
				}else {
					break;
				}				
			}
			if(rowSum == n) {
				System.out.println(arr.get(i).get(0));
				break;
			}
			
			// Col
			for(int j=0; j<n;j++ ) {
				if(arr.get(j).get(i) == arr.get(0).get(i)) {
					colSum++;
				}else {
					break;
				}				
			}
			if(colSum == n) {
				System.out.println(arr.get(0).get(i));
				break;
			}		
		}
		if(diag1 == n) {
			System.out.println(arr.get(0).get(0));
		}
		if(diag2 == n) {
			System.out.println(arr.get(0).get(n-1));
		}
	}

}