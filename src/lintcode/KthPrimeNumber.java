package lintcode;

import java.util.LinkedList;

/**
 * Created by Anthony on 2014/6/25.
 */
public class KthPrimeNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if(k <= 0)
            return 1;
        LinkedList<Long> n3 = new LinkedList<Long>();
        LinkedList<Long> n5 = new LinkedList<Long>();
        LinkedList<Long> n7 = new LinkedList<Long>();
        n3.add(3l);
        n5.add(5l);
        n7.add(7l);
        long min = 0l;
        for(int i = 0; i < k; i++){
            min = Math.min(n3.peekFirst(), Math.min(n5.peekFirst(), n7.peekFirst()));
            if(min == n3.peekFirst()){
                n3.removeFirst();
                n3.addLast(min * 3);
                n5.addLast(min * 5);
                n7.addLast(min * 7);
            }
            else if(min == n5.peekFirst()){
                n5.removeFirst();
                n5.addLast(min * 5);
                n7.addLast(min * 7);
            }
            else {
                n7.removeFirst();
                n7.addLast(min * 7);
            }
        }
        return min;
    }

    public static void main(String args[]){
        System.out.println(new KthPrimeNumber().kthPrimeNumber(11));
    }
}
