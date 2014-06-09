package leetcode;

/**
 * Created by Anthony on 2014/6/9.
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null, p = head;
        while(p != null){
            if(p.next != null && p.val == p.next.val){
                while(p.next != null && p.val == p.next.val){
                    p.next = p.next.next;
                }
                if(prev != null) {
                    prev.next = p.next;
                    p = p.next;
                }
                else{
                    head = p.next;
                    p = p.next;
                }
            }
            else{
                prev = p;
                p = p.next;
            }
        }
        return head;
    }
}
