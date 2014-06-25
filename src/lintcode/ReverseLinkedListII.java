package lintcode;

/**
 * Created by anthony on 6/25/14.
 */
public class ReverseLinkedListII {
    /**
     * @param head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head == null)
            return null;
        if(m >= n)
            return head;
        ListNode p_prev = null, p = head;
        for(int i = 0; i < m-1; i++){
            p_prev = p;
            p = p.next;
            if(p == null){
                return head;
            }
        }
        ListNode prev = p, q = p.next, next = null;
        for(int i = 0; i < n-m; i++){
            next = q.next;
            q.next = prev;
            prev = q;
            q = next;
        }
        if(p_prev != null){
            p_prev.next = prev;
        }
        else{
            head = prev;
        }
        p.next = q;
        return head;
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        new ReverseLinkedListII().reverseBetween(l1, 4, 5);
    }
}
