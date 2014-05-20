package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode a = head, b = head.next;
        while(a != null && b != null){
            if(a == b)
                return true;
            a = a.next;
            b = b.next;
            if(b == null)
                return false;
            b = b.next;
        }
        return false;
    }
}
