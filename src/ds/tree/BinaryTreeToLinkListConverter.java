package ds.tree;

/**
 *https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 */
public class BinaryTreeToLinkListConverter {
    class Dummy{
        TreeNode head;
        TreeNode tail;
        public Dummy(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    public TreeNode flatten(TreeNode a) {
        Dummy list = flattenUtil(a);
        return list.head;
    }
    private Dummy flattenUtil(TreeNode a) {
        if(a == null)
            return null;
        Dummy left = flattenUtil(a.left);
        Dummy right = flattenUtil(a.right);
        if(left == null && right == null)
        {
            return new Dummy(a, a);
        }
        if(left != null)
        {
            left.tail.right = a.right;
            a.right = left.head;
            a.left = null;
        }
        return new Dummy(a, right != null ? right.tail : left.tail);
    }
}
