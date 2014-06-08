package leetcode;

/**
 * Created by Anthony on 2014/6/8.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode p = head;
        while(n > 0){
            p = p.next;
            if(p == null)
                p = head;
            n--;
        }
        ListNode q = head;
        while(p.next != null){
            q = q.next;
            p = p.next;
        }
        p.next = head;
        head = q.next;
        q.next = null;

        return head;
    }
}
