package leetcode;

import java.util.ArrayList;
import java.util.List;
import library.SmallRootHeap;

/**
 * Created by Anthony on 2014/5/28.
 */
public class MergekSortedLists {
    class ListNode2 extends ListNode implements Comparable<ListNode2>{
        public ListNode2(ListNode node){
            super(node.val);
            this.next = node.next;
        }

        @Override
        public int compareTo(ListNode2 o) {
            return (this.val-o.val);
        }
    }
    public ListNode mergeKLists(List<ListNode> lists) {
        SmallRootHeap<ListNode2> heap = new SmallRootHeap<ListNode2>();
        for(ListNode node:lists) {
            if (node != null)
                heap.add(new ListNode2(node));
        }
        if(heap.empty())
            return null;
        ListNode head = heap.pop(), ptr = head;
        if(ptr.next != null){
            heap.add(new ListNode2(ptr.next));
            ptr.next = null;
        }
        while(!heap.empty()){
            ptr.next = heap.pop();
            ptr = ptr.next;
            if(ptr.next != null){
                heap.add(new ListNode2(ptr.next));
                ptr.next = null;
            }
        }

        return head;
    }

    public static void main(String args[]){
        //Test 127
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(new ListNode(-4));
        list.add(new ListNode(-10, new ListNode(-6, new ListNode(-6))));
        list.add(new ListNode(0, new ListNode(3)));
        list.add(new ListNode(2));
        list.add(new ListNode(-10,new ListNode(-9,new ListNode(-8,new ListNode(3,new ListNode(4,new ListNode(4)))))));
        list.add(new ListNode(-10,new ListNode(-10,new ListNode(-8,new ListNode(-6,new ListNode(-4,new ListNode(-3,new ListNode(1))))))));
        list.add(new ListNode(2));
        list.add(new ListNode(-9,new ListNode(-4,new ListNode(-2,new ListNode(4,new ListNode(4))))));
        list.add(new ListNode(-4,new ListNode(0)));
        
        new MergekSortedLists().mergeKLists(list);
    }
}
