package interviewQuestions.salesforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchAverage {
	private static int binarySearch(List<QuantityObject> list, int quantity) {
		int start =0; 
		int end = list.size();
		while(start <= end) {
			int mid = (start + end)/2;
			if(list.get(mid).quantity == quantity) {
				return mid;
			}else if(list.get(mid).quantity < quantity) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return end+1;
	}
	
	private static void findAverage(ArrayList<Integer> quantity, ArrayList<Double> price, int quant) {
		List<QuantityObject> arrList = new ArrayList<>();
		for(int i=0; i<quantity.size(); i++) {
			arrList.add(new QuantityObject(quantity.get(i), price.get(i)));
		}
		arrList.sort((a,b)->a.quantity-b.quantity);
	//	Collections.sort(arrList);
		int index = binarySearch(arrList, quant);
		if(index != -1) {
			System.out.println("quantity : "+quant+" , price :"+((arrList.get(index).price + arrList.get(index-1).price)/2));
		}
	}
	public static void main(String[] args) {
		findAverage(new ArrayList<Integer>(Arrays.asList(25,50,100)), new ArrayList<Double>(Arrays.asList(5.00, 4.00, 3.00)), 75);

	}
}

class QuantityObject implements Comparable<QuantityObject>{
	int quantity;
	double price;
	QuantityObject(int q, double p){
		this.quantity = q;
		this.price = p;
	}
	@Override
	public int compareTo(QuantityObject inputQuanity) {
		return this.quantity - inputQuanity.quantity;
	}
}
