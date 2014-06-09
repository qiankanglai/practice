package leetcode;

import java.util.Arrays;

/**
 * Created by Anthony on 2014/6/9.
 */
public class ScrambleString {
    int[] count = new int[26];
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null)
            return false;
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        int l1 = s1.length();
        if(l1 == 0)
            return true;
        else if(l1 == 1){
            return false;
        }
        boolean flag = true;
        for(int l1_half = 1; l1_half < l1; l1_half++) {
            String s1_1 = s1.substring(0, l1_half), s1_2 = s1.substring(l1_half);
            String s2_1 = s2.substring(0, l1_half), s2_2 = s2.substring(l1_half);

            flag = true;
            Arrays.fill(count, 0);
            //不剪枝会超时~
            for(char c : s1_1.toCharArray()){
                if(c >= 'a' && c <= 'z')
                    count[c-'a']++;
            }
            for(char c : s2_1.toCharArray()){
                if(c >= 'a' && c <= 'z')
                    count[c-'a']--;
            }
            for(int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(char c : s1_2.toCharArray()){
                    if(c >= 'a' && c <= 'z')
                        count[c-'a']++;
                }
                for(char c : s2_2.toCharArray()){
                    if(c >= 'a' && c <= 'z')
                        count[c-'a']--;
                }
                for(int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && isScramble(s1_1, s2_1) && isScramble(s1_2, s2_2))
                return true;

            s2_1 = s2.substring(0, l1 - l1_half);
            s2_2 = s2.substring(l1 - l1_half);
            flag = true;
            Arrays.fill(count, 0);
            for(char c : s1_1.toCharArray()){
                if(c >= 'a' && c <= 'z')
                    count[c-'a']++;
            }
            for(char c : s2_2.toCharArray()){
                if(c >= 'a' && c <= 'z')
                    count[c-'a']--;
            }
            for(int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(char c : s1_2.toCharArray()){
                    if(c >= 'a' && c <= 'z')
                        count[c-'a']++;
                }
                for(char c : s2_1.toCharArray()){
                    if(c >= 'a' && c <= 'z')
                        count[c-'a']--;
                }
                for(int i = 0; i < 26; i++) {
                    if (count[i] != 0) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag && isScramble(s1_1, s2_2) && isScramble(s1_2, s2_1))
                return true;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(new ScrambleString().isScramble("great", "rgeat"));
        System.out.println(new ScrambleString().isScramble("great", "rgtae"));
        System.out.println(new ScrambleString().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}
