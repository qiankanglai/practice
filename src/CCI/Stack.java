package CCI;

/**
 * Created by Anthony on 2014/6/12.
 */
public class Stack {
    Node top = null;
    private int count = 0;

    public int pop(){
        if(top != null){
            int item = top.data;
            top = top.next;
            return item;
        }
        else
            return -1;
    }

    public void push(int data){
        Node node = new Node(data);
        node.next = top;
        top = node;
        count++;
    }

    public int peek(){
        if(top != null) {
            count--;
            return top.data;
        }
        else
            return -1;
    }

    public int size(){
        return count;
    }
}
