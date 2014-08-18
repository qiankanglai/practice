package google.campustest.practice2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anthony on 8/18/14.
 */
public class Moist {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader
                ("src/google/campustest/practice2014/C-small-practice-2.in"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = Integer.parseInt(reader.readLine());
            String arr[] = new String[n];
            for(int i = 0; i < n; i++)
                arr[i] = reader.readLine();

            int count = 0;
            String max = arr[0];
            for(int i = 1; i < n; i++){
                String t = arr[i];
                if(compare(t, max) > 0){
                    max = t;
                }
                else{
                    count++;
                }
            }

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(count);
        }
        reader.close();
    }

    private static int compare(String s, String t) {
        int l = Math.min(s.length(), t.length());
        for(int i = 0; i < l; i++){
            char s1 = s.charAt(i), s2 = t.charAt(i);
            if(s1 == ' '){
                if(s2 == ' '){
                    continue;
                }
                else{
                    return -1;
                }
            }
            if(s2 == ' '){
                return 1;
            }
            if(s1 >= 'A' && s1 <= 'Z'){
                if(s2 >= 'A' && s2 <= 'Z'){
                    if(s1 == s2){
                        continue;
                    }
                    else {
                        return s1 - s2;
                    }
                }
                else{
                    return 1;
                }
            }
            if(s2 >= 'A' && s2 <= 'Z'){
                return -1;
            }
            if(s1 != s2)
                return s1 - s2;
        }
        return s.length() - t.length();
    }
}
