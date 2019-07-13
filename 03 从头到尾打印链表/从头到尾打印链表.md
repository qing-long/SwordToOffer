# [从头到尾打印链表](<https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking>)

## 题目描述

时间限制：1秒

空间限制：32768K 

输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

## 解题思路

### 一、递归

要逆序打印1 -> 2 -> 3 -> 4，可以先逆序打印 3 -> 4（4，3）；

然后（4， 3）可以看成一个结果，继续逆序打印 2 -> (4, 3)；

之后一直递归，得出结果。

```java
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> res = new ArrayList<>();
    if (null != listNode) {
        res.addAll(printListFromTailToHead(listNode.next));
        res.add(listNode.val);
    }
    return res;
}
```

### 二、栈

栈的特性是，先进后出，把这个链表从头到尾依次全部置入栈中，然后再一次弹出，完成逆序。

```java
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
```

### 三、头插法

新建一个头结点，不存值；

头结点指向链表第一个节点：head -> 1；

头结点指向第二个节点：head -> 2 -> 1；

头结点指向第三个节点：head -> 3 -> 2 -> 1；

一直指向最后一个节点。

头结点和第一个节点的区别：

- 头结点是头插法中使用的一个额外的节点，这个节点不存储值；
- 第一个节点是链表中第一个真实存储值的节点。

```java
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
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
```

