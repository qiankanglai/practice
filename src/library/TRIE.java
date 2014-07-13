package library;

import java.util.HashMap;

/**
 * Created by Anthony on 2014/6/20.
 */
public class TRIE {
    private Character currentChar = null;
    private String currentString = "";
    private int count = 0;
    private HashMap<Character, TRIE> children = new HashMap<Character, TRIE>();

    public TRIE(Character c, String s){
        currentChar = c;
        currentString = s + c;
        count = 0;
    }
    public void add(String str){
        count++;
        if(str.length() == 0)
            return;
        char c = str.charAt(0);
        String s2 = str.substring(1);
        if(!children.containsKey(c))
            children.put(c, new TRIE(c, currentString));
        children.get(c).add(s2);
    }
    public int find(String str){
        if(str.length() == 0)
            return count;
        char c = str.charAt(0);
        if(!children.containsKey(c))
            return 0;
        String s2 = str.substring(1);
        return children.get(c).find(s2);
    }

    public static void main(String args[]){
        TRIE root = new TRIE(null, "");
        root.add("abc");
        root.add("abd");
        System.out.println(root.find("abce"));
    }
}