public class Solution {
	public ListNode FindKthToTail(ListNode head,int k) {
        if (null == head) {
            return null;
        }
        ListNode p1 = head;
        while (null != p1 && k --> 0) {
            p1 = p1.next;
        }
        if (k > 0) {
            return null;
        }
        ListNode p2 = head;
        while (null != p1) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}