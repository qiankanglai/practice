package CCI;

/**
 * Created by Anthony on 2014/6/12.
 */
public class Stack {
    Node top = null;

    int pop(){
        if(top != null){
            int item = top.data;
            top = top.next;
            return item;
        }
        else
            return -1;
    }

    void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    int peek(){
        if(top != null)
            return top.data;
        else
            return -1;
    }
}
