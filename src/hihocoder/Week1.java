package hihocoder;

import java.util.Scanner;

/**
 * Created by anthony on 7/6/14.
 */
public class Week1 {
    //http://hihocoder.com/contest/hiho1/problem/1
    //之前leetcode的DP解法不够，参考:
    // http://www.felix021.com/blog/read.php?2040
    // http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
    public static int longestPalindrome(String s) {
        if(s.length() <= 1)
            return s.length();

        int len = s.length(), newlen = 2*len+1;
        char c[] = new char[newlen];
        for(int i = 0; i < newlen; i++){
            c[i] = (i % 2 == 1)?s.charAt(i/2):0;
        }
        int p[] = new int[newlen];
        int id = 0, right = 0;
        int max = 0;
        for(int i = 0; i < newlen; i++){
            p[i] = 1;
            if(right > i){
                if(i + p[2*id-i] < right)
                    p[i] = p[2*id-i];
                else
                    p[i] = right - i;
            }
            while(i - p[i] >= 0 &&  i + p[i] < newlen && c[i-p[i]] == c[i+p[i]]){
                p[i]++;
            }
            if(p[i] + i > right){
                id = i;
                right = p[i] + i;
            }
            if(max < p[i]-1)
                max = p[i]-1;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        for(int t = 0; t < T; t++){
            String line = in.nextLine();
            System.out.println(longestPalindrome(line));
        }
    }
}
