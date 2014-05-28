package leetcode;

/**
 * Created by Anthony on 2014/5/28.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;

        ListNode p = head, previouspart = null;
        while(true){
            ListNode q = p;
            if(p == null){
                //if (previouspart != null)
                //    previouspart.next = p;
                return head;
            }
            for(int i = 0; i < k-1; i++){
                if(q.next == null) {
                    //if (previouspart != null)
                    //    previouspart.next = p;
                    return head;
                }
                else
                    q = q.next;
            }
            ListNode nextpart = q.next;
            if(previouspart==null) {
                head = q;
            }
            else{
                previouspart.next = q;
            }
            previouspart = p;

            ListNode oldNext = p.next;
            ListNode newNext = nextpart;
            while(p != q){
                p.next = newNext;
                newNext = p;
                p = oldNext;
                oldNext = p.next;
            };
            p.next = newNext;
            p = nextpart;
        }
        //return head;
    }

    public static void main(String args[]){
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReverseNodesinkGroup().reverseKGroup(node, 3);
    }
}
