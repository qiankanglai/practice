package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode t = head.next;
        head.next = t.next;
        t.next = head;
        head = t;

        t = head.next;
        while(t != null){
            ListNode p1 = t.next;
            if(p1 == null)
                break;
            ListNode p2 = p1.next;
            if(p2 == null)
                break;
            p1.next = p2.next;
            p2.next = p1;
            t.next = p2;
            t = p1;
        }
        return head;
    }
}
