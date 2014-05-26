package leetcode;

import java.util.Arrays;

/**
 * Created by anthony on 5/25/14.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int []t = new int[n];
        for(int i = 0; i < n; i++) {
            t[i] = gas[i] - cost[i];
        }

        boolean []flags = new boolean[n];
        Arrays.fill(flags, true);
        for(int i = 0; i < n; i++){
            if(t[i] < 0){
                flags[i] = false;
                int sum = t[i];
                for(int j = 1; j <= n; j++){
                    int current = (i+n-j)%n;
                    sum += t[current];
                    if(sum < 0)
                        flags[current] = false;
                    else
                        break;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(flags[i])
                return i;
        }
        return -1;
    }

    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int n = gas.length;
        int []t = new int[n];
        t[0] = gas[0]-cost[0];
        for(int i = 1; i < n; i++) {
            t[i] = t[i - 1] + gas[i] - cost[i];
        }

        int circle_cost = t[n-1];
        for(int i = 0; i < n; i++){
            int temp = cost[i]-gas[i];
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if (t[j] < 0)
                    flag = false;
                t[j] += temp;
            }
            t[i] = circle_cost;
            if(flag)
                return i;
        }
        return -1;
    }

    public static void main(String args[]){
        System.out.println(new GasStation().canCompleteCircuit(new int[]{4}, new int[]{5}));    //-1
        System.out.println(new GasStation().canCompleteCircuit(new int[]{1,2}, new int[]{2,1}));    //1
        System.out.println(new GasStation().canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));    //3
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2,4}, new int[]{3,4}));    //-1
    }
}
