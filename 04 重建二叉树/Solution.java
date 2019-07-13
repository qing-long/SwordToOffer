public class Solution {
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
}