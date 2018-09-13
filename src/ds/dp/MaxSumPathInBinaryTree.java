package ds.dp;

/**
 * https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
      val = x;
      left=null;
      right=null;
     }
 }
public class MaxSumPathInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
    /*    root.left = new TreeNode(-1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
*/
        System.out.println(new MaxSumPathInBinaryTree().maxPathSum(root));

    }

    public int maxPathSum(TreeNode A) {
        Result result = new Result(Integer.MIN_VALUE);
        int max= maxPathSumUtil(A, result);
        return Math.max(max, result.res);
    }

    private int maxPathSumUtil(TreeNode root, Result res)
    {
        if (root == null)
            return 0;
        int left = maxPathSumUtil(root.left, res);
        int right = maxPathSumUtil(root.right, res);
        int maxSubtree = Math.max(left, right);
        int maxTillRoot = Math.max(root.val, root.val + maxSubtree);
        int completeSum = left + right + root.val;
        int max  = Math.max(completeSum, maxTillRoot);
        res.res = Math.max(res.res, max);
        return maxTillRoot;
    }
}

class Result
{
    int res;

    public Result(int res) {
        this.res = res;
    }
}
