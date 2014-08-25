package hackerrank.DynamicProgramming;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by anthony on 8/21/14.
 */
public class VerticalSticks {
    // 这道题参考了http://cs.stackexchange.com/questions/1076/how-to-approach-vertical-sticks-challenge
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            float sum = 0;
            sum += 1;   //最短的一根贡献必然为1
            int pre_min_id = 0;
            for(int i = 1; i < n; i++){
                while(arr[pre_min_id] < arr[i]){
                    pre_min_id++;
                }
                int greater_or_equal = n-pre_min_id;      //至少和当前数一样大的
                //n个位置放greater_or_equal个筷子，有C(n,greater_or_equal)种
                //平均每个筷子前长度平均为x=(n+1)/(greater_or_equal+1)
                sum += (float)(n+1) / (greater_or_equal+1);
            }
            System.out.println(numberFormat.format(sum));
        }
        in.close();
    }
}
