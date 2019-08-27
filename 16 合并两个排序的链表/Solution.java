public class Solution {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if (null == list1) {
			return list2;
		}
		if (null == list2) {
			return list1;
		}
		if (list1.val <= list2.val) {
			list1.next = Merge(list1.next, list2);
			return list1;
		} else {
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}
}

public class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
}