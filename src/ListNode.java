public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
	
	public void addAtTail(int val) {
		ListNode itr = this;
		while(itr.next!=null)
			itr=itr.next;
		itr.next = new ListNode(val);
	}
	
	public void print() {
		System.out.print(val);
		ListNode itr = next;
		while(itr!=null) {
			System.out.print("->"+itr.val);
			itr = itr.next;
		}
	}
}
