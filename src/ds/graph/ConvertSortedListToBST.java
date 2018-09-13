package ds.graph;

/**
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 */

import java.util.ArrayList;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class ConvertSortedListToBST
{
    private TreeNode sortedListToBST(ListNode a) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode tmp = a;
        while (tmp != null)
        {
            arr.add(tmp);
            tmp = tmp.next;
        }
        return sortedListToBSTUtil(arr, 0, arr.size()-1);
    }

    private TreeNode sortedListToBSTUtil(ArrayList<ListNode> arr, int low, int high)
    {
        if (low > high)
            return null;
        if (low == high)
        {
            return new TreeNode(arr.get(low).val);
        }
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(arr.get(mid).val);
        root.left = sortedListToBSTUtil(arr, low, mid-1);
        root.right = sortedListToBSTUtil(arr, mid+1, high);

        return root;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        TreeNode root = new ConvertSortedListToBST().sortedListToBST(head);
        System.out.println(root);
    }
}
