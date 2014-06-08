package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by anthony on 6/8/14.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        if(strs == null || strs.length == 0)
            return res;
        HashMap<String, ArrayList<String>> cache = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);

            String key = new String(c);
            if(cache.containsKey(key))
                cache.get(key).add(strs[i]);
            else
            {
                ArrayList<String> r = new ArrayList<String>();
                r.add(strs[i]);
                cache.put(key, r);
            }
        }
        for(String key:cache.keySet()){
            ArrayList<String> _strs = cache.get(key);
            if( _strs.size() <= 1)
                continue;
            else
                res.addAll(_strs);
        }
        return res;
    }

}
