package leetcode;

/**
 * Created by anthony on 6/10/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode p = head, q = head.next;
        while(p != null && q != null && q.next != null){
            p = p.next;
            q = q.next;
            q = q.next;
        }

        ListNode head2 = p.next;

        p = head2;
        q = null;   //p_prev
        while(p != null){
            ListNode t = p.next;
            if(t == null){
                head2 = p;
            }
            p.next = q;
            q = p;
            p = t;
        }

        p = head;
        q = head2;

        while(p != null && q != null){
            ListNode t = p.next, t2 = q.next;
            p.next = q;
            q.next = t;
            p = t;
            q = t2;
        }
        if(p != null)
            p.next = null;
        if(q != null)
            q.next = null;
    }
}
