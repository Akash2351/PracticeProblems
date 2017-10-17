package akash;

/**
 * Created by akash on 17-10-2017.
 */
public class LinkedListPalindrome {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;

        //find length of list...
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // for palindrome, reverse second half of list and
        //run pointers from both end comparing values.
        cur = head;
        for (int i = 0; i < len / 2; i++) {
            cur = cur.next;
        }
        ListNode last = reverse(cur);
        cur = head;

        //compare values from both ends till length/2
        for (int i = 0; i < len / 2; i++) {
            if (cur.val != last.val)
                return false;

            cur = cur.next;
            last = last.next;
        }

        return true;
    }


    ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
