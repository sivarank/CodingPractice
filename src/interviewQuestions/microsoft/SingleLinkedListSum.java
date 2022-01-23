package interviewQuestions.microsoft;
/*
 L1   1->2->3->4  = 1234

L2   5->6->7->8  = 5678

            = 6912
			
			
Approach1:  start from header :			


Appraoch2: reverse L1     4->3->2->1
           reverse L2     8->7->6->5
		                  2  1  9  6

example:

1->2->6
8->9

6->2 
 */
public class SingleLinkedListSum {
	static ListNode calculateSum(ListNode L1, ListNode L2){
		if(L1 == null || L2 == null){
			return L1 == null ? L2 : L1; // new list shoul be return , 
		}
		//1->2->3
		L1 = reverseList(L1);  //3->2->2
		L2 = reverseList(L2);  //4->5>6 
		                      // L3   7->7->8   reverse ==>   8->7->7 
		int remainder = 0;
		ListNode L3 = null, p1= L1, p2 = L2, previousNode = null;
		while(p1 != null && p2 != null){
			int val1 = p1.getVal();
			int val2 = p2.getVal();
			ListNode node = new ListNode((val1 + val2 + remainder)%10);
			remainder = (val1 + val2 + remainder)/10; // 0 or 1 
			// set new list header
			if(L3 == null){
				L3 = node;
			}else{
				previousNode.next = node;
			}
			previousNode = node;
			p1 = p1.next;
			p2 = p2.next; 
		}
		//p2 == null , p1 == null  
		//p2!= null , p1 == null
		// p2== null, p1 != null 
		
		     if(p1 != null ){
				p2 = p1; 
			 }
			while(p2 != null){
				ListNode node = new ListNode((p2.getVal() + remainder)%10);  //999999  remainder 1   0000001 
				remainder = (p2.getVal() + remainder)/10; 
				previousNode.next = node;
				previousNode = node;
				p2 = p2.next;
			}
			if(remainder > 0){
				previousNode.next = new ListNode(remainder);
			}
			
	    L1 = reverseList(L1);// 1->2->3
		L2 = reverseList(L2); 
		
		return reverseList(L3); 
	}
	/*
	 1->2->3
pre  cur  next
cur.next = pre;  pre = curr	; cur = next; next = next.next;

	 */
	private static ListNode reverseList(ListNode l) {
		ListNode cur = l, prev = null, next = l.next;
		
		while(cur != null) {
			cur.next = prev;
			prev = cur;
			cur = next;
			if(next != null) {
				next = next.next;
			}
		}
		return prev;
	}
	public static void main(String[] args) {
		/// create 1st list 
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);
		l2.next.next.next = new ListNode(8);
		ListNode l3 = calculateSum(l1, l2);
		while(l3 != null) {
			System.out.println(l3.data);
			l3 = l3.next;
		}
	}

}

class ListNode{
	int data;
	ListNode next;
	ListNode(int val){
		data = val;
	}
	int getVal(){
		return data;
	}
}