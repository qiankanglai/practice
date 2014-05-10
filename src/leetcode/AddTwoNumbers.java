package leetcode;

/**
 * Created by Anthony on 2014/5/8.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = new ListNode(0), p = p1;
        boolean addone = false;
        while(l1 != null && l2 != null){
            int s = l1.val+l2.val+(addone?1:0);
            addone = s>=10;
            p.next = new ListNode(s%10);
            p = p.next;l1=l1.next;l2=l2.next;
        }
        while(l1 != null){
            int s = l1.val+(addone?1:0);
            addone = s>=10;
            p.next = new ListNode(s%10);
            p = p.next;l1=l1.next;
        }
        while(l2 != null){
            int s = l2.val+(addone?1:0);
            addone = s>=10;
            p.next = new ListNode(s%10);
            p = p.next;l2=l2.next;
        }
        if(addone){
            p.next = new ListNode(1);
        }
        return p1.next;
    }
}
