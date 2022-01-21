package interviewQuestions.oracle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Question 2: Write a function that should take a large string as an input and print top k frequent characters. Note: ‘A’ and ‘a’ are considered different and there may be special characters like ‘@’ and ‘!’ etc. in the string provided as input.

Example :

Input : "$geeksforGEEKs@", k=3
Output :
Character is e count is 2
Character is E count is 2
Character is s count is 2
 */
public class HighFrequentCharacters {
	public static void main(String[] args) {
		String str = "$geeksforGEEKs@";
		int k = 3;
		Map<Character, Integer> countMap = new HashMap<>(); 
		for(int index=0; index<str.length(); index++ ) {
			int count =1;
			if(countMap.containsKey(str.charAt(index))) {
				count = count + countMap.get(str.charAt(index));
			}
			countMap.put(str.charAt(index), count);
		}
		
		//PriorityQueue<Node> queue = new PriorityQueue<Node>(k, new NodeComparator());
		PriorityQueue<Node> queue = new PriorityQueue<Node>(k, (a,b)-> {return a.count - b.count;});
		
		for(Character ch : countMap.keySet()) {
			queue.add(new Node(countMap.get(ch), ch));
			if(queue.size() > k) {
				queue.poll();
			}
		}
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.ch +" , "+n.count+"   --> ");
		}
	}

}

class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node n1, Node n2) {
		return n1.count - n2.count;
	}
	
}

class Node{
	int count;
	Character ch;
	Node(int count, Character ch){
		this.count = count;
		this.ch = ch;
	}
}