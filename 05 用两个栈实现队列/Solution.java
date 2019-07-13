public class Solution {
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
}