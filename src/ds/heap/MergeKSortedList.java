package ds.heap;

/**
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((o1, o2) -> {
            if (o1.val > o2.val)
                return 1;
            if (o1.val < o2.val)
                return -1;
            return 0;
        });

        for (ListNode listNode : lists) {
            if (listNode != null)
                pq.add(listNode);
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (!pq.isEmpty())
        {
            ListNode node = pq.poll();
            curr.next = node;
            if (node.next != null)
                pq.add(node.next);
            curr = curr.next;
        }
        return head.next;
    }
}

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }