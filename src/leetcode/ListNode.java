package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    ListNode(int x, ListNode n) {
        val = x;
        next = n;
    }
}
