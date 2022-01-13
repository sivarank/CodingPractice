package progPractice.games;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens {


	static boolean checkQueen(List<ArrayList<Boolean>> arr, int row, int col) {
		// check previous rows
		for(int i=row-1; i>= 0; i--) {
			if(arr.get(i).get(col) == Boolean.TRUE) {
				return false;
			}
		}
		
		// check previous rows
		for(int i=col-1; i>= 0; i--) {
			if(arr.get(row).get(i)== Boolean.TRUE) {
				return false;
			}
		}
		
		// check diagonal
		
		for(int i=row-1, j= col-1; i>= 0 && j>=0; i--, j--) {
			if(arr.get(i).get(j)== Boolean.TRUE) {
				return false;
			}
		}
		
		// check diagonal
		
		for(int i=row-1, j= col+1; i>= 0 && j<8; i--, j++) {
			if(arr.get(i).get(j)== Boolean.TRUE) {
				return false;
			}
		}
		return true;
	}
	
	static boolean placeQueen(List<ArrayList<Boolean>> arr, int row) {
		if(row == 8) {
			return true;
		}
		for(int i=0; i<8; i++) {
			arr.get(row).set(i, Boolean.TRUE);
			if(checkQueen(arr, row, i) && placeQueen(arr, row+1)) {
				
				return Boolean.TRUE;
			}
			arr.get(row).set(i, null);
		}
		return Boolean.FALSE;
	}

	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		List<ArrayList<Boolean>> arr = new ArrayList<ArrayList<Boolean>>(8);
		for(int i=0; i< 8; i++) {
			arr.add(new ArrayList<Boolean>( Arrays.asList(new Boolean[8])));
		}
		placeQueen(arr, 0);
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(arr.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}

}