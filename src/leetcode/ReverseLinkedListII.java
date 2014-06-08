package leetcode;

/**
 * Created by anthony on 6/8/14.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        if(m >= n)
            return head;

        ListNode p = head, p_prev = null;
        ListNode node_m1 = null;
        m--;
        n--;
        int i = 0;
        while(i <= n){
            ListNode p_next = p.next;
            if(i == m){
                node_m1 = p_prev;
            }
            else if(i > m && i < n){
                p.next = p_prev;
            }
            else if(i == n){
                p.next = p_prev;
                if(node_m1 != null) {
                    node_m1.next.next = p_next;
                    node_m1.next = p;
                }
                else{
                    head.next = p_next;
                    head = p;
                }
            }
            i++;
            p_prev = p;
            p = p_next;
        }

        return head;
    }

    public static void main(String args[]){
        ListNode n = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReverseLinkedListII().reverseBetween(n, 1, 4);
    }
}
