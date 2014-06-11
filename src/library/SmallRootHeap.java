package library;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Anthony on 2014/5/28.
 */
public class SmallRootHeap<V extends Comparable<V>>{
    private V[] values = null;
    private int capacity = 0, size = 0;

    public SmallRootHeap(){
        capacity = 10;
        values = (V[])new Comparable<?>[capacity];
    };

    public int size(){return size;};
    public boolean empty(){return size==0;};

    public V peak(){
        if(size == 0)
            return null;
        return values[0];
    }
    public V pop(){
        if(size == 0)
            return null;
        V v = values[0];

        values[0] = values[size-1];
        size--;
        int ptr = 0;
        while(ptr < size){
            V self = values[ptr];
            V left = (ptr*2+1 < size)?values[ptr*2+1]:null;
            V right = (ptr*2+2 < size)?values[ptr*2+2]:null;
            if(right == null){
                if(left == null)
                    break;
                else if(self.compareTo(left) > 0){
                    values[ptr] = left;
                    values[ptr*2+1] = self;
                    ptr = ptr*2+1;
                }
                else
                    break;
            }
            else{
                if(right.compareTo(left) > 0){
                    if(self.compareTo(left) > 0){
                        values[ptr] = left;
                        values[ptr*2+1] = self;
                        ptr = ptr*2+1;
                    }
                    else
                        break;
                }
                else {
                    if (self.compareTo(right) > 0) {
                        values[ptr] = right;
                        values[ptr * 2 + 2] = self;
                        ptr = ptr * 2 + 2;
                    } else
                        break;
                }
            }
        }

        return v;
    }
    public void add(V value){
        if(size == capacity-1){
            capacity = capacity*2;
            values = Arrays.copyOf(values, capacity);
        }
        values[size] = value;
        int ptr = size;
        size++;

        while(ptr > 0){
            V parent = values[(ptr-1)/2];
            V self = values[ptr];
            if(parent.compareTo(self) > 0){
                values[ptr] = parent;
                values[(ptr-1)/2] = self;
                ptr = (ptr-1)/2;
            }
            else
                break;
        }
    };

    public static void main(String args[]){
        //Test
        SmallRootHeap<Integer> h = new SmallRootHeap<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 10; i++) {
            int t = rand.nextInt(32);
            System.out.print(t);
            System.out.print('\t');
            h.add(t);
        }
        System.out.println();

        while(!h.empty()){
            System.out.print(h.pop());
            System.out.print('\t');
        }
    }
}
