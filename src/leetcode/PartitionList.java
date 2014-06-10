package leetcode;

/**
 * Created by Anthony on 2014/6/10.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode p1 = null, p2 = null;
        ListNode p1_head = null, p2_head = null;
        while(head != null){
            if(head.val < x){
                if(p1 == null) {
                    p1 = head;
                    p1_head = head;
                }
                else{
                    p1.next = head;
                    p1 = head;
                }
            }
            else{
                if(p2 == null){
                    p2 = head;
                    p2_head = head;
                }
                else{
                    p2.next = head;
                    p2 = head;
                }
            }
            head = head.next;
        }
        if(p1 != null)
            p1.next = null;
        if(p2 != null)
            p2.next = null;

        if(p1_head == null)
            return p2_head;
        if(p2_head == null)
            return p1_head;

        p1.next = p2_head;
        return p1_head;
    }
}
