package ds.tree;

public class BalancedBSTChecker {

    public int isBalanced(TreeNode a) {

        return isBalancedUtil(a) == -1 ? 0 : 1;
    }

    private int isBalancedUtil(TreeNode root) {
        if(root == null)
            return 0;
        if (root.left == null && root.right == null)
                return 1;
        int left = 0, right = 0;
        if(root.left != null)
            left = isBalancedUtil(root.left);
        if (left == -1)
            return -1;
        if (root.right != null)
            right = isBalancedUtil(root.right);
        if (right == -1 || Math.abs(left - right) > 1)
            return -1;
        return Math.max(left, right) + 1;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
