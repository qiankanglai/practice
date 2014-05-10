package leetcode;

/**
 * Created by anthony on 5/6/14.
 */
public class MedianofTwoSortedArrays {
    public int findkth(int A[], int B[], int k){        //k starts from 0
        int a = 0, b = 0;
        while(a < A.length && b < B.length){
            if(k == 0)
                return Math.min(A[a], B[b]);
            int a2 = Math.min(A.length-1, a+k/2);
            int b2 = Math.min(B.length-1, b+k/2);
            if(A[a2] < B[b2]){
                if(a2==a)
                    a2++;
                k -= (a2-a);
                a = a2;
            }
            else{
                if(b2==b)
                    b2++;
                k -= (b2-b);
                b = b2;
            }
        }
        if(a == A.length)
            return B[b+k];
        else
            return A[a+k];
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        if((m+n)%2==1)
            return findkth(A,B,(m+n)/2);
        else
            return (findkth(A,B,(m+n+1)/2)+findkth(A,B,(m+n-1)/2))/2.0;
    }

    public static void main(String[] args){
        int []arr1 = new int[]{1,2};
        int []arr2 = new int[]{3};
        MedianofTwoSortedArrays w = new MedianofTwoSortedArrays();
        System.out.println(w.findMedianSortedArrays(arr1, arr2));
    }
}
