package hackerrank.DynamicProgramming;

import java.util.Scanner;

/**
 * Created by Anthony on 9/22/2014.
 */
public class HexagonalGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int _t = 0; _t < t; _t++) {
            int n = in.nextInt();
            boolean ar1[] = new boolean[n+2], ar2[] = new boolean[n+2];
            String temp = in.nextLine();
            ar1[0] = true;
            ar2[0] = true;
            ar1[1] = true;
            ar2[1] = true;
            temp = in.nextLine();
            for(int i = 0; i < n; i++){
                ar1[i+2] = temp.charAt(i) == '1';
            }
            temp = in.nextLine();
            for(int i = 0; i < n; i++){
                ar2[i+2] = temp.charAt(i) == '1';
            }
            System.out.println(solve(ar1, ar2, n+2)?"YES":"NO");
        }

        in.close();
    }

    private static final int STATE_NONE = 0;
    //上留空
    private static final int STATE_UP = 1;
    //下留空
    private static final int STATE_DOWN = 2;
    //都留空
    private static final int STATE_EMPTY = 4;
    //都满
    private static final int STATE_FULL = 8;
    private static boolean solve(boolean[] ar1, boolean[] ar2, int n) {
        int states[] = new int[n];
        for(int i = 0; i < n; i++){
            states[i] = STATE_NONE;
            if(ar1[i] && ar2[i]){
                if(i == 0 || (states[i-1] & STATE_FULL) > 0) {
                    states[i] |= STATE_FULL;
                }
            }
            else if(ar1[i] && !ar2[i]){
                if((states[i-1] & STATE_FULL) > 0){
                    states[i] |= STATE_DOWN;
                }
                if((states[i-1] & STATE_DOWN) > 0){
                    states[i] |= STATE_FULL;
                }
            }
            else if(!ar1[i] && ar2[i]){
                if((states[i-1] & STATE_FULL) > 0){
                    states[i] |= STATE_UP;
                }
                if((states[i-1] & STATE_UP) > 0){
                    states[i] |= STATE_FULL;
                }
                if((states[i-1] & STATE_DOWN) > 0){
                    states[i] |= STATE_FULL;
                }
            }
            else{
                if((states[i-1] & STATE_FULL) > 0){
                    states[i] |= STATE_EMPTY;
                    states[i] |= STATE_FULL;
                    if((states[i-2] & STATE_FULL) > 0){
                        states[i-1] |= STATE_FULL;
                        states[i] |= STATE_FULL;
                    }
                }
                if((states[i-1] & STATE_UP) > 0){
                    states[i] |= STATE_DOWN;
                }
                if((states[i-1] & STATE_DOWN) > 0){
                    states[i] |= STATE_UP;
                    states[i] |= STATE_DOWN;
                }
            }
        }
        return (states[n-1] & STATE_FULL) > 0;
    }
}
