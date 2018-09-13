package ds.linkedlist;

/**
 * https://www.interviewbit.com/problems/rotate-list/
 */
public class RotateList {
    public ListNode rotateRight(ListNode a, int b) {
        if(a == null)
            return a;
        ListNode slow = a;
        ListNode fast = a;
        int len = 1;
        while(slow.next != null)
        {
            slow = slow.next;
            len++;
        }
        b = b%len;

        slow =a;
        if(b == 0 || a.next == null)
            return a;
        for(int i = 1; i <= b; i++)
        {
            fast = fast.next;
        }

        while(fast != null && fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode head = slow.next;
        slow.next = null;
        fast.next = a;
        return head;

    }
}
