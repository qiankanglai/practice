package leetcode;

/**
 * Created by Anthony on 2014/6/8.
 */
public class CopyListwithRandomPointer {
    //hulu面试题
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        //Step 1: newNode.next = oldNode.random; oldNode.random = newNode;
        RandomListNode newHead = null, oldNode = head, newNode = null;
        while(oldNode != null){
            newNode = new RandomListNode(oldNode.label);
            newNode.next = oldNode.random;
            oldNode.random = newNode;
            if(newHead == null){
                newHead = newNode;
            }

            oldNode = oldNode.next;
        }
        //Step 2: for every oldNode: oldNode.random(newNode).random = oldNode.random.next(oldNode.random).random;
        oldNode = head;
        while(oldNode != null){
            newNode = oldNode.random;
            if(newNode.next != null)
                newNode.random = newNode.next.random;    //setup newNode.random properly

            oldNode = oldNode.next;
        }
        //Step 3: restore oldNode.random, build newNode.next
        oldNode = head;
        while(oldNode != null){
            newNode = oldNode.random;
            RandomListNode temp = newNode.next;
            if(oldNode.next != null)
                newNode.next = oldNode.next.random;    //setup newNode.next properly
            else
                newNode.next = null;
            oldNode.random = temp;    //restore oldNode.random

            oldNode = oldNode.next;
        }
        return newHead;
    }

    public static void main(String args[]){
        RandomListNode n1 = new RandomListNode(-1);
        RandomListNode n2 = new RandomListNode(-1);
        n1.next = n2;   n2.random = n1;

        RandomListNode newHead = new CopyListwithRandomPointer().copyRandomList(n1);
    }
}
