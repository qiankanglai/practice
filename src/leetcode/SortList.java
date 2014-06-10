package leetcode;

/**
 * Created by Anthony on 2014/6/10.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        int step = 1;
        while(true){
            boolean sortAtLeaseOnce = false;
            ListNode p = head, prev_p = null;
            while(p != null) {
                ListNode q = p;
                for (int i = 0; i < step-1; i++) {
                    if (q.next == null)
                        break;
                    q = q.next;
                }
                if (q.next == null) {
                    //这两句一开始少了~需要接回去！
                    if(prev_p != null)
                        prev_p.next = p;
                    break;
                }

                ListNode temp = q.next;
                q.next = null;
                q = temp;

                for (int i = 0; i < step-1; i++) {
                    if (temp.next == null)
                        break;
                    temp = temp.next;
                }
                ListNode next_p = temp.next;
                temp.next = null;

                //now merge sort p,q
                ListNode current = null;
                while(p != null && q != null){
                    ListNode node = null;
                    if(p.val < q.val){
                        node = p;
                        p = p.next;
                    }
                    else{
                        node = q;
                        q = q.next;
                    }

                    if(current == null){
                        current = node;
                        if(prev_p == null){
                            head = current;
                        }
                        else{
                            prev_p.next = current;
                        }
                    }
                    else{
                        current.next = node;
                        current = node;
                    }
                }

                if(p != null){
                    current.next = p;
                }
                else{
                    current.next = q;
                }
                while(current.next != null)
                    current = current.next;
                prev_p = current;

                p = next_p;
                sortAtLeaseOnce = true;
            }

            if(!sortAtLeaseOnce)
                break;
            step *= 2;
        }
        return head;
    }

    public static void main(String args[]){
        ListNode node = new ListNode(3, new ListNode(2, new ListNode(4)));
        new SortList().sortList(node);
    }
}
