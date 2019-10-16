/*
 * https://leetcode.com/problems/partition-list/
*/
public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.addAtTail(4);
		head.addAtTail(3);
		head.addAtTail(2);
		head.addAtTail(5);
		head.addAtTail(2);
		
		head.print();
		
		new Partition().partition(head, 3);
		System.out.println("\n----------------------");
		head.print();
		
	}

	public ListNode partition(ListNode head, int x) {
		
		ListNode splitNode = null;
		ListNode itr = head;
		ListNode preItr = head;
		
		while(itr!=null) {
			if(itr.val>=x && splitNode==null) {
				splitNode = preItr;
			}
			if(itr.val<x && splitNode!=null) {
				preItr.next = itr.next;
				itr.next = splitNode.next;
				if(splitNode==head)
					head = itr;
				else
					splitNode.next = itr;
				itr = preItr;
			}
			preItr = itr;
			itr = itr.next;
		}
		
		return head;
	}
}
