public class Solution {
	/**
     * 递归解法
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null != listNode) {
            res.addAll(printListFromTailToHead(listNode.next));
            res.add(listNode.val);
        }
        return res;
    }

    /**
     * 栈
     */
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        /* 入栈 */
        while (null != listNode) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
    
        /* 出栈 */
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * 头插法
     */
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        /* 定义一个头结点 */
        ListNode head = new ListNode(-1);
        while (null != listNode) {
            /* 把当前节点的next设置为temp */
            ListNode temp = listNode.next;
            /* 保持链表不改变顺序 */
            listNode.next = head.next;
            /* head指向当前节点 */
            head.next = listNode;
            /* 循环条件更改 */
            listNode = temp;
        }
    
        ArrayList<Integer> res = new ArrayList<>();
        head = head.next;
        while (null != head) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}