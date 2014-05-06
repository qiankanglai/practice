package leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Anthony on 2014/5/6.
 */
public class LinkedListCycleII {
    //http://oj.leetcode.com/discuss/396/is-there-any-better-answer-for-the-linked-list-cycle-ii
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return head;
        ListNode p = head, q = head;
        do{
            p = p.next;
            q = q.next;
            if(q != null)
                q = q.next;
            else
                return null;
            if(p == null || q == null)
                return null;
        }while(p != q);
        ListNode p2 = head;
        //p2 starts from head, and when p2 reaches start, p will just at start at the same time!!!
        while(p2 != p){
            p2 = p2.next;
            p = p.next;
        }
        return p2;
    }
}
