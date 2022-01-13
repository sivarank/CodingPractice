package progPractice.arrays;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class FindPairsSum {


	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		
		URI uri = new URI("http://ab");
		uri.toURL();
		int[] arr = {-2,-1,1,3,5,6,7,9,13,14};
		int sum = 14;
		Arrays.sort(arr);
		int leftIndex = 0, rightIndex = arr.length -1; 
		while(leftIndex < rightIndex){
			if(arr[leftIndex] + arr[rightIndex] == sum){
				System.out.println(arr[leftIndex] +","+arr[rightIndex]);
				leftIndex++;
				rightIndex--;
			}else if(arr[leftIndex] + arr[rightIndex] < sum){
				leftIndex++;
			}else{
				rightIndex--;
			}
		}
	}

}