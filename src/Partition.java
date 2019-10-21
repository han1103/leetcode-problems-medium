/*
 * https://leetcode.com/problems/partition-list/
*/
public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(7);
		head.addAtTail(4);
		head.addAtTail(3);
		head.addAtTail(2);
		head.addAtTail(5);
		head.addAtTail(2);
		
		head.print();
		
		head = new Partition().partition(head, 7);
		System.out.println("\nEND----------------------");
		head.print();
		
	}

	public ListNode partition(ListNode head, int x) {
		
		ListNode splitNode = null;
		boolean foundSplit = false;
		ListNode itr = head;
		ListNode preItr = null;
				
		while(itr!=null) {
			if(itr.val>=x && !foundSplit) {
				splitNode = preItr;
				foundSplit = true;
			}
			if(itr.val<x && foundSplit) {
				preItr.next = itr.next;
				if( splitNode != null) {
					itr.next = splitNode.next;
					splitNode.next = itr;
				}
				else {					
					itr.next = head;						
					head = itr;
				}				
				splitNode = itr;
				itr = preItr;
			}
			preItr = itr;
			itr = itr.next;
			//System.out.println("\n----------------------");
			//head.print();			
		}
		
		return head;
	}
}
