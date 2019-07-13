# [用两个栈实现队列](<https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking>)

## 题目描述

时间限制：1秒

空间限制：32768K

用两个栈来实现一个队列，完成队列的Push和Pop操作。

 队列中的元素为int类型。

## 解题思路

队列：先进先出；

栈：先进后出；

用两个栈实现队列的`Push`和`Pop`操作，可以一个栈只做`Push`，一个栈只做`Pop`。

```java
Stack<Integer> stack1 = new Stack<Integer>();
Stack<Integer> stack2 = new Stack<Integer>();

/* Push操作 */
public void push(int node) {
    stack1.push(node);
}

/* Pop操作 */
public int pop() throws Exception {
    if (stack2.isEmpty()) {
        /* 把stack1的元素依次pop，然后再push到stack2里 */
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    if (stack2.isEmpty()) {
        throw new Exception("queue is empty!");
    }

    return stack2.pop();
}
```

