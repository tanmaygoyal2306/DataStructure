package ds.linkedlist;

/**
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 */

public class ReverseLinkedList {

    public ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode tmp = a;
        if(m == n)
            return a;
        ListNode firstLast = null;
        int i = 1;
        for(;i < m; i++)
        {
            firstLast = tmp;
            tmp = tmp.next;
        }
        ListNode prev = firstLast;
        for(i = m; i <= n; i++)
        {
            ListNode next = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = next;
        }
        ListNode secondFirst = null;
        if(m == 1)
        {
            secondFirst = a;
            secondFirst.next = tmp;
            return prev;
        }
        secondFirst = firstLast.next;
        firstLast.next = prev;
        secondFirst.next = tmp;
        return a;
    }
}
