package leetcode;

/**
 * Created by Anthony on 2014/5/20.
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p != null)
        {
            if(p.next != null && p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
}
