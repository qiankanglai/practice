package leetcode;

import java.util.*;

/**
 * Created by Anthony on 2014/5/28.
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for(String str:L){
            if(count.containsKey(str))
                count.put(str, count.get(str)+1);
            else
                count.put(str, 1);
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int s = S.length(), l = L[0].length();
        for(int ptr = 0; ptr+l*L.length<=s; ptr++){
            String s2 = S.substring(ptr, ptr + l);
            if(!count.containsKey(s2))
                continue;

            HashMap<String, Integer> count2 = new HashMap<String, Integer>();
            count2.put(s2, 1);
            boolean flag = true;
            for(int i = 1; i < L.length; i++){
                s2 = S.substring(ptr+i*l, ptr+i*l+l);
                if(!count.containsKey(s2)) {
                    flag = false;
                    break;
                }
                int c = 0;
                if(count2.containsKey(s2))
                    c = count2.get(s2);
                c++;
                if(c > count.get(s2)){
                    flag = false;
                    break;
                }
                count2.put(s2, c);
            }
            if(flag){
                result.add(ptr);
            }
        }

        return result;
    }

    public List<Integer> findSubstring_tle(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int s = S.length(), l = L[0].length();
        boolean visited[] = new boolean[L.length];
        for(int ptr = 0; ptr+l <= s; ptr++) {
            int count = 0, ptr2 = ptr;
            Arrays.fill(visited, false);
            while (ptr2 + l <= s) {
                String s2 = S.substring(ptr2, ptr2 + l);
                boolean found = false;
                for (int i = 0; i < L.length; i++)
                    if (!visited[i] && L[i].equals(s2)) {
                        visited[i] = true;
                        found = true;
                        break;
                    }
                if(found) {
                    ptr2 += l;
                    count++;
                }
                else
                    break;
            }
            if(count == L.length)
                result.add(ptr);
        }

        return result;
    }

    public static void main(String args[]){
        new SubstringwithConcatenationofAllWords().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"});
        new SubstringwithConcatenationofAllWords().findSubstring("a", new String[]{"a","a"});
    }
}
