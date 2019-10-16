
public class InsertionSortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(6);
		head.addAtTail(1);
		head.addAtTail(5);
		head.addAtTail(3);
		head.addAtTail(8);
		head.addAtTail(7);
		head.addAtTail(2);
		head.addAtTail(4);
		
		head.print();
		
		head = new InsertionSortList().insertionSortList(head);
		
		System.out.println("\n-----------------------");
		
		head.print();
	}
	
	public ListNode insertionSortList(ListNode head) {
		if(head==null)
			return head;
		
		ListNode itrNode = head.next;
		ListNode preItrNode = head;
		
		while(itrNode!=null) {
			ListNode innerItrNode = head;
			ListNode preInnerItrNode = head;
			while(innerItrNode != itrNode) {
				if(innerItrNode.val >= itrNode.val) {
					preItrNode.next = itrNode.next;
					itrNode.next = innerItrNode;
					if(innerItrNode==head)
						head = itrNode;
					else
						preInnerItrNode.next = itrNode;
                    itrNode = preItrNode;    	
					break;
				}
				preInnerItrNode = innerItrNode;
				innerItrNode = innerItrNode.next;
			}
			preItrNode = itrNode;
			itrNode = itrNode.next;
		}
		
		return head;
	}
}
