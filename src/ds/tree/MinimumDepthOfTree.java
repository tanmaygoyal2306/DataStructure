package ds.tree;

public class MinimumDepthOfTree {
    public int minDepth(TreeNode a) {
        if(a.left == null && a.right== null)
            return 1;
        int leftMin = Integer.MAX_VALUE, rightMin = Integer.MAX_VALUE;
        if(a.left != null)
            leftMin = minDepth(a.left);
        if(a.right != null)
            rightMin = minDepth(a.right);

        return Math.min(leftMin, rightMin) + 1;
    }
}
