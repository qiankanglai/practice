package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        if(l1 == null) {
            head = l2;
            if (l2 != null) l2 = l2.next;
        }
        else if(l2 == null) {
            head = l1;
            if (l1 != null) l1 = l1.next;
        }
        else
        {
            if(l1.val < l2.val){
                head = l1;
                l1 = l1.next;
            }
            else{
                head = l2;
                l2 = l2.next;
            }
        }
        ListNode p = head;
        while(l1 != null || l2 != null){
            if(l2 != null && (l1 == null || l2.val < l1.val)){
                //concat l2
                p.next = l2;
                l2 = l2.next;
            }
            else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }
        return head;
    }
    public static void main(String args[]){
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(3);
        n2.next.next = new ListNode(4);
        new MergeTwoSortedLists().mergeTwoLists(n1, n2);
    }
}
