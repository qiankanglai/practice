package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/24.
 */
public class KthLargestElement {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    //Kth Largest Element
    public int partition(int start, int end, ArrayList<Integer> numbers){
        if(start >= end){
            return start;
        }
        int ptr = start;
        for(int i = start; i < end; i++){
            if(numbers.get(i) < numbers.get(end)){
                int t = numbers.get(ptr);
                numbers.set(ptr, numbers.get(i));
                numbers.set(i, t);
                ptr++;
            }
        }
        int t = numbers.get(end);
        numbers.set(end, numbers.get(ptr));
        numbers.set(ptr, t);
        return ptr;
    }

    public int kthLargestElement(int start, int end, int k, ArrayList<Integer> numbers) {
        // O(n): 需要5个数作为group，然后挑中位数
        // http://stackoverflow.com/questions/251781/how-to-find-the-kth-largest-element-in-an-unsorted-array-of-length-n-in-on
        // http://c3p0demo.googlecode.com/svn/trunk/scalaDemo/script/Order_statistics.ppt
        int pivot = partition(start, end, numbers);
        if(pivot == k)
            return numbers.get(pivot);
        else if(pivot < k)
            return kthLargestElement(pivot+1, end, k, numbers);
        else
            return kthLargestElement(start, pivot-1, k, numbers);
    }

    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        if(numbers == null || k < 0 || k > numbers.size())
            return -1;
        return kthLargestElement(0, numbers.size()-1, numbers.size()-k, numbers);
    }

    public static void main(String args[]){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(8);
        numbers.add(9);
        numbers.add(10);
        numbers.add(7);
        System.out.println(new KthLargestElement().kthLargestElement(10, numbers));
    }
}
