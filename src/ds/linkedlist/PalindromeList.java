package ds.linkedlist;

/**
 * https://www.interviewbit.com/problems/palindrome-list/
 */

public class PalindromeList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lPalin(ListNode A) {
		if(A == null || A.next == null)
			return 1;
		ListNode slow = A;
		ListNode fast = A.next;
		while(fast != null && fast.next != null)
		{
			fast = fast.next;
			fast = fast.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		ListNode newMid = reverse(mid);
		ListNode head1 = A;
		ListNode head2 = newMid;
		while(head2 != null)
		{
			if(head1.val != head2.val)
				return 0;
			head1 = head1.next;
			head2 = head2.next;
		}
		return 1;
    }

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null)
		{
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}



class ListNode {
     public int val;
	 public ListNode next;
	 ListNode(int x) { val = x; next = null; }
 }