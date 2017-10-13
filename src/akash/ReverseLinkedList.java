package akash;

/**
 * Created by akash on 13-10-2017.
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head, prev = null, next = null;
            if (head == null || head.next == null)
                return head;

            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
