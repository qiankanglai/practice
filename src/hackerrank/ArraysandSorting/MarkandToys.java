package hackerrank.ArraysandSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 7/8/14.
 */
public class MarkandToys {
    public static void main(String[] args) {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();

        int answer = 0;
        Arrays.sort(prices);
        for(int i = 0; i < n; i++){
            if(k >= prices[i]){
                answer++;
                k -= prices[i];
            }
            else{
                break;
            }
        }
        // Compute the final answer from n,k,prices
        System.out.println(answer);
    }
}
