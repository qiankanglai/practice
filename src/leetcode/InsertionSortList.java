package leetcode;

import java.util.List;

/**
 * Created by Anthony on 2014/5/6.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode p = head.next;
        head.next = null;
        while(p != null){
            ListNode q = p.next;
            p.next = null;
            if(p.val < head.val){
                p.next = head;
                head = p;
            }
            else{
                ListNode i = head;
                while(i.next != null && i.next.val < p.val)
                    i = i.next;
                p.next = i.next;
                i.next = p;
            }
            p = q;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3), node2 = new ListNode(4), node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        new InsertionSortList().insertionSortList(node1);
    }
}
