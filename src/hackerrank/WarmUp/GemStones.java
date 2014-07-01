package hackerrank.WarmUp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Anthony on 2014/7/1.
 */
public class GemStones {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        boolean flags[] = new boolean[26];
        Arrays.fill(flags, true);
        in.nextLine();
        for(int i = 0; i < T; i++){
            String s = in.nextLine();
            boolean flags2[] = new boolean[26];
            for(char c : s.toCharArray()){
                flags2[c-'a'] = true;
            }
            for(int k = 0; k < 26; k++){
                if(flags[k] && !flags2[k]){
                    flags[k] = false;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 26; i++) {
            if (flags[i]) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
