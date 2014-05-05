package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anthony on 2014/5/5.
 */
public class WordBreak {
    Integer lengths[] = null;
    Set<String> dicts = null, fails = null;
    boolean dfs(String s){
        if(s.length()==0)
            return true;
        if(fails.contains(s))
            return false;
        for(int i = lengths.length-1; i >= 0; i--){
            if(s.length() >= lengths[i])
            {
                String s2 = s.substring(0, lengths[i]);
                if(dicts.contains(s2) && dfs(s.substring(lengths[i])))
                    return true;
            }
        }
        fails.add(s);
        return false;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        Set<Integer> _l = new HashSet<Integer>();
        for(String d : dict){
            _l.add(d.length());
        }
        lengths = _l.toArray(new Integer[0]);
        Arrays.sort(lengths);
        dicts = dict;
        fails = new HashSet<String>();
        return dfs(s);
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        WordBreak w = new WordBreak();
        //save failures to speed up!
        System.out.println(w.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
    }
}
