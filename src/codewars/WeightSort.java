package codewars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by qiank on 1/29/2016.
 */
public class WeightSort {
    public static String orderWeight(String strng) {
        if(strng==null||strng.length()==0) return strng;
        String []s = strng.split(" ");
        ArrayList<String> x = new ArrayList();
        for(int i = 0; i < s.length; i++)
        {
            x.add(s[i]);
        }
        Collections.sort(x, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int t1=0,t2=0;
                for(int i=0;i<o1.length();i++)
                {
                    t1+=o1.charAt(i)-'0';
                }
                for(int i=0;i<o2.length();i++)
                {
                    t2+=o2.charAt(i)-'0';
                }
                if(t1==t2)
                    return o1.compareTo(o2);
                else
                    return t1-t2;
            }
        });

        String res="";
        for(int i=0;i<x.size();i++)
        {
            if(i!=0) res += ' ';
            res +=x.get(i);
        }
        return res;
    }
}
