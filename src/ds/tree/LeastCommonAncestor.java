package ds.tree;

/**
 * https://www.interviewbit.com/problems/least-common-ancestor/
 */
public class LeastCommonAncestor {
    public int lca(TreeNode a, int val1, int val2)
    {
        TreeNode lca = lcaRec(a, val1, val2);
        if(lca == null)
            return -1;
        if(lca.val != val1 && lca.val != val2)
            return lca.val;
        if(lca.val == val1)
            return search(lca, val2) ? val1 : -1;
        return search(lca, val1) ? val2 : -1;
    }
    private boolean search(TreeNode a, int val) {
        if (a == null)
            return false;
        return a.val == val || search(a.left, val) || search(a.right, val);
    }
    private TreeNode lcaRec(TreeNode a, int val1, int val2)
    {
        if(a == null)
            return null;
        if(a.val == val1 || a.val == val2)
            return a;
        TreeNode left = lcaRec(a.left, val1, val2);
        TreeNode right = lcaRec(a.right, val1, val2);
        if(left != null && right != null)
            return a;
        if(left != null)
            return left;
        return right;
    }
}
