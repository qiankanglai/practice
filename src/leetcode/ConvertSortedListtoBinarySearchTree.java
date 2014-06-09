package leetcode;

/**
 * Created by Anthony on 2014/6/8.
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        else if(head.next == null){
            return new TreeNode(head.val);
        }
        else{
            ListNode p = head, q = head.next;
            while(q.next != null && q.next.next != null){
                p = p.next;
                q = q.next;
                q = q.next;
            }
            TreeNode n = new TreeNode(p.next.val);
            n.right = sortedListToBST(p.next.next);
            p.next = null;
            n.left = sortedListToBST(head);
            return n;
        }
    }
}
