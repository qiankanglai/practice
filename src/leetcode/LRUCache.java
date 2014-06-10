package leetcode;

import java.util.HashMap;

/**
 * Created by Anthony on 2014/6/10.
 */
public class LRUCache {
    //用单链表搜索太慢……会超时
    class DataNode{
        public int key, value;
        public DataNode prev, next;
        public DataNode(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity = 0, count = 0;
    private DataNode head = null, tail = null;
    public HashMap<Integer, DataNode> cache = new HashMap<Integer, DataNode>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void moveToHead(DataNode p){
        if(p == head){
            //nothing happens
        }
        else if(p == tail){
            tail = p.prev;
            tail.next = null;

            p.prev = null;
            p.next = head;
            head.prev = p;
            head = p;
        }
        else{
            p.prev.next = p.next;
            p.next.prev = p.prev;

            p.prev = null;
            p.next = head;
            head.prev = p;
            head = p;
        }
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

        DataNode p = cache.get(key);
        moveToHead(p);
        return p.value;
    }

    public void set(int key, int value) {
        if(!cache.containsKey(key)){
            DataNode p = new DataNode(key, value);
            cache.put(key, p);
            count++;

            if(head == null) {
                head = p;
                tail = p;
            }
            else{
                head.prev = p;
                p.next = head;
                head = p;
            }

            if(count > capacity){
                cache.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
                count--;
            }
        }
        else{
            DataNode p = cache.get(key);
            p.value = value;

            moveToHead(p);
        }
    }
}
