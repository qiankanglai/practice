package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/5.
 */
public class CountandSay {
    public String countAndSay(int n) {
        ArrayList<Integer> t = new ArrayList<Integer>();
        if(n <= 0)
            return "";
        t.add(1);
        for(int step = 2; step <= n; step++){
            ArrayList<Integer> t2 = new ArrayList<Integer>();
            for(int i = 0; i < t.size(); i++){
                int current = t.get(i);
                int count = 1;
                while(i+1 < t.size() && current == t.get(i+1)) {
                    i++;
                    count++;
                }
                t2.add(count);
                t2.add(current);
            }
            t = t2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t.size(); i++)
            sb.append(t.get(i).toString());
        return sb.toString();
    }
}
