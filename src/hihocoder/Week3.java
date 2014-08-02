package hihocoder;

import java.util.Scanner;

/**
 * Created by anthony on 8/1/14.
 */
public class Week3 {
    //copy from library.KMP
    public static int KMP_count(char[] S, char[] W){
        if(S == null || W == null)
            return 0;

        if(W.length > S.length)
            return 0;
        if(W.length == 0){
            return 0;
        }
        else if(W.length == 1){
            int count = 0;
            for(int i = 0; i < S.length; i++){
                if(S[i] == W[0]){
                    count++;
                }
            }
            return count;
        }

        //kmp_table
        int[] T = new int[W.length+1];
        int pos = 2, cnd = 0;
        T[0] = -1;
        T[1] = 0;
        while(pos <= W.length){
            if(W[pos-1] == W[cnd]){
                cnd++;
                T[pos] = cnd;
                pos++;
            }
            else if(cnd > 0){
                cnd = T[cnd];
            }
            else{
                T[pos] = 0;
                pos++;
            }
        }

        int count = 0;
        //kmp_search
        int m = 0, i = 0;
        while(m + i < S.length){
            if(W[i] == S[m+i]){
                if(i == W.length-1){
                    count++;
                    i = T[i];
                    m = m+i-T[i];
                }
                else {
                    i++;
                }
            }
            else{
                if(T[i] > -1){
                    //jump to next available
                    i = T[i];
                    m = m+i-T[i];
                }
                else{
                    i = 0;
                    m++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for (int t = 0; t < T; t++) {
            char[] line1 = in.nextLine().toCharArray();
            char[] line2 = in.nextLine().toCharArray();
            System.out.println(KMP_count(line2, line1));
        }
    }
}
