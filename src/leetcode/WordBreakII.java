package leetcode;

import java.util.*;

/**
 * Created by Anthony on 2014/6/10.
 */
public class WordBreakII {
    //先正着做各种可能情况，然后倒着拼起来
    public List<String> wordBreak(String s, Set<String> dict) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0)
            return new ArrayList<String>();

        HashMap<Integer, HashSet<String>> cache = new HashMap<Integer, HashSet<String>>();
        for(String d : dict){
            int len = d.length();
            if(cache.containsKey(len)){
                cache.get(len).add(d);
            }
            else{
                HashSet<String> hs = new HashSet<String>();
                hs.add(d);
                cache.put(len, hs);
            }
        }

        ArrayList<ArrayList<String>> cache2 = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < s.length(); i++){
            ArrayList<String> temp = new ArrayList<String>();
            for(Integer len : cache.keySet()) {
                if (i+len > s.length())
                    continue;
                String s2 = s.substring(i, i+len);
                if(cache.get(len).contains(s2))
                    temp.add(s2);
            }
            cache2.add(temp);
        }

        ArrayList<String> results[] = new ArrayList[s.length()];
        for(int i = s.length()-1; i >= 0; i--){
            results[i] = new ArrayList<String>();
            for(String s2 : cache2.get(i)){
                if(s2.length()+i == s.length())
                    results[i].add(s2);
                else if(s2.length()+i < s.length()){
                    for(String s3 : results[s2.length()+i]){
                        results[i].add(s2+" "+s3);
                    }
                }
            }
        }

        return results[0];
    }

    private List<String> dfs(String s, HashMap<Integer, HashSet<String>> cache) {
        ArrayList<String> result = new ArrayList<String>();
        if(s.length() > 0){
            for(Integer len : cache.keySet()){
                if(len > s.length())
                    continue;
                else if(len == s.length()){
                    if(cache.get(len).contains(s))
                        result.add(s);
                }
                else {
                    String s2 = s.substring(0, len);
                    if (cache.get(len).contains(s2)) {
                        List<String> result2 = dfs(s.substring(len), cache);
                        for(String _r2 : result2){
                            result.add(s2 + " " + _r2);
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<String> wordBreak_tle(String s, Set<String> dict) {
        if(dict == null || dict.size() == 0 || s == null || s.length() == 0)
            return new ArrayList<String>();

        HashMap<Integer, HashSet<String>> cache = new HashMap<Integer, HashSet<String>>();
        for(String d : dict){
            int len = d.length();
            if(cache.containsKey(len)){
                cache.get(len).add(d);
            }
            else{
                HashSet<String> hs = new HashSet<String>();
                hs.add(d);
                cache.put(len, hs);
            }
        }

        return dfs(s, cache);
    }

    public static void main(String args[]){
        HashSet<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> r = new WordBreakII().wordBreak("catsanddog", dict);
    }
}
