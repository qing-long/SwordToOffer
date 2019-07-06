# [重建二叉树](https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking)

## 题目描述

时间限制：1秒

空间限制：32768K

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。

假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

## 解题思路

前序遍历：根节点 -> 左子树 -> 右子树；

中序遍历：左子树 -> 根节点 -> 右子树；

依照前序遍历的特性，可以知道：

- 前序遍历的第一个节点是根节点；
- 中序遍历中，根节点的左边是左子树，右边是右子树；

然后第一层确定后，利用递归可以推导出剩下的树。

```java
/* Map用于存放中序遍历数组每个数对应的索引值 */
private Map<Integer, Integer> indexForInOrders = new HashMap<>();

public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    for (int i = 0; i < in.length; i++) {
        indexForInOrders.put(in[i], i);
    }
    
    return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
}

/* 重建二叉树，并递归调用 */
private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
    /* 传值错误直接结束 */
    if (preL > preR) {
        return null;
    }
    /* 根据前序遍历设置二叉树根节点，每个二叉树的根节点都是其前序遍历的第一个数 */
    TreeNode root = new TreeNode(pre[preL]);
    /* 获取中序遍历中根节点的索引 */
    int inIndex = indexForInOrders.get(root.val);
    /* 设置左子树的大小 */
    int leftTreeSize = inIndex - inL;
    /* 左子树 */
    root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
    /* 右子树 */
    root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
    
    return root;
}
```

