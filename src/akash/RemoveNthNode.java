package akash;

/**
 * Created by akash on 28-10-2017.
 */
public class RemoveNthNode {

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //one pass algorithm.. using 2 pointers, which are n nodes apart.
    // advance the first pointer to n positions first
    //keep advancing second pointer until first becomes null. now
    //second will be at nth node from the end.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //create a dummy node to handle first node removal easy.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 0; i < n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        //when second moves to nth position from end, first will be null.
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
