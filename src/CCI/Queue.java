package CCI;

/**
 * Created by Anthony on 2014/6/12.
 */
public class Queue {
    Node first = null, last = null;

    void enqueue(int item){
        Node node = new Node(item);
        if(first == null){
            first = node;
            last = node;
        }
        else{
            last.next =  node;
            last = node;
        }
    }

    int dequeue(){
        if(first == null){
            return -1;
        }
        else{
            int item = first.data;
            first = first.next;
            return item;
        }
    }
}
