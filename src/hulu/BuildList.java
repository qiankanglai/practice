package hulu;

/**
 * Created by anthony on 5/29/14.
 */
public class BuildList{
    //电面
    //一个单链表，有神奇的random指针指向可能的任一元素(或者null)
    //复制一个出来，不要破坏原来的
    class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) {
            val = x;
            next = null;
            random = null;
        }
        ListNode(int x, ListNode n, ListNode r) {
            val = x;
            next = n;
            random = r;
        }
    }

    public ListNode test(ListNode oldHead){
        if(oldHead == null)
            return null;
        //Step 1: newNode.next = oldNode.random; oldNode.random = newNode;
        ListNode newHead = null, oldNode = oldHead, newNode = null;
        while(oldNode != null){
            newNode = new ListNode(0);
            newNode.next = oldNode.random;
            oldNode.random = newNode;
            if(newHead == null){
                newHead = newNode;
            }

            oldNode = oldNode.next;
        }
        //Step 2: for every oldNode: oldNode.random(newNode).random = oldNode.random.next(oldNode.random).random;
        oldNode = oldHead;
        while(oldNode != null){
            newNode = oldNode.random;
            if(newNode.next != null)
                newNode.random = newNode.next.random;    //setup newNode.random properly

            oldNode = oldNode.next;
        }
        //Step 3: restore oldNode.random, build newNode.next
        oldNode = oldHead;
        while(oldNode != null){
            newNode = oldNode.random;
            ListNode temp = newNode.next;
            if(oldNode.next != null)
                newNode.next = oldNode.next.random;    //setup newNode.next properly
            oldNode.random = temp;    //restore oldNode.random

            oldNode = oldNode.next;
        }
        return newHead;
    }
}
