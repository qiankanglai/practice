package CCI;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Anthony on 2014/6/11.
 */
public class Chapter1 {
    public static void main(String args[]){
    }
    // 1.1
    public boolean isUniqueChars1(String s){
        boolean cache[] = new boolean[256];
        Arrays.fill(cache, false);

        for(int i = 0; i < s.length(); i++){
            if(cache[s.charAt(i)])
                return false;
            else
                cache[s.charAt(i)] = true;
        }
        return true;
    }
    public boolean isUniqueChars2(String s){
        for(int i = 0; i < s.length(); i++)
            for(int j = i+1; j < s.length(); j++)
                if(s.charAt(i) == s.charAt(j))
                    return false;
        return true;
    }

    //1.2
    public void reverse(char[] str){
        int len = 0;
        while(str[len] != '\0')
            len++;
        if(len > 0){
            for(int i = 0; 2*i < len; i++){
                char c = str[i];
                str[i] = str[len-1-i];
                str[len-1-i] = c;
            }
        }
    }

    //1.3
    public boolean permutation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        int cache[] = new int[256];
        Arrays.fill(cache, 0);
        for(int i = 0; i < s1.length(); i++){
            cache[s1.charAt(i)]++;
        }
        for(int i = 0; i < s2.length(); i++){
            cache[s1.charAt(i)]--;
            if(cache[s1.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    //1.4
    public void replaceSpaces(char str[], int len){
        int spaces = 0;
        for(int i = 0; i < len; i++)
            if(str[i]==' ')
                spaces++;
        int newlen = len + 2*spaces;
        while(len >= 0){
            if(str[len] == ' '){
                str[newlen] = str[len];
                newlen--;
                len--;
            }
            else{
                str[newlen] = '0';
                str[newlen-1] = '2';
                str[newlen-2] = '%';
                newlen -= 3;
                len--;
            }
        }
    }

    //1.5
    public String compress(String str){
        StringBuilder sb = new StringBuilder();
        char last = str.charAt(0);
        sb.append(last);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(last == str.charAt(i))
                count++;
            else{
                sb.append(count);
                last = str.charAt(i);
                count = 1;
                sb.append(last);
            }
        }
        sb.append(count);
        String s2 = sb.toString();
        if(s2.length() < str.length())
            return s2;
        else
            return str;
    }

    //1.6
    public void rotate(int [][]matrix, int n){
        for(int y = 0; y <= n/2; y++){
            for(int x = y; x <= n-y; x++){
                int x1 = x, y1 = y;
                int x2 = n-y1, y2 = x1;
                int x3 = n-y2, y3 = x2;
                int x4 = n-y3, y4 = x3;

                int t = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = matrix[x3][y3];
                matrix[x3][y3] = matrix[x4][y4];
                matrix[x4][y4] = t;
            }
        }
    }

    //1.7
    public void setZero(int [][]matrix, int m, int n){
        boolean rows[] = new boolean[m];
        boolean columns[] = new boolean[n];
        for(int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (matrix[y][x] == 0) {
                    rows[y] = true;
                    columns[x] = true;
                }
            }
        }
        for(int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (rows[y] || columns[x]) {
                    matrix[y][x] = 0;
                }
            }
        }
    }

    //1.8
    public boolean check(String s1, String s2){
        if(s1.length() != s2.length())
            return false;
        String s = s1+s1;
        return s.indexOf(s2) >= 0;
    }
}
