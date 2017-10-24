package akash;

/**
 * Created by akash on 23-10-2017.
 */
public class AddLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            if (l1 != null) {
                cur.val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                cur.val += l2.val;
                l2 = l2.next;
            }

            cur.val += carry;
            //cur node val = l1.val + l2.val + carry...
            //calculate carry... 13 -> carry 1
            carry = cur.val / 10;
            cur.val = cur.val % 10;
            prev.next = cur;
            prev = cur;
        }
        return head.next;
    }
}
