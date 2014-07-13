package hihocoder;

import java.util.Scanner;

/**
 * Created by anthony on 7/13/14.
 */
public class Week2 {
    //只要考虑小写
    static class TRIE2 {
        private Character currentChar = null;
        private int count = 0;
        private TRIE2 children[] = new TRIE2[26];

        public TRIE2(Character c) {
            currentChar = c;
            count = 0;
        }

        public void add(String str) {
            count++;
            if (str.length() == 0)
                return;
            char c = str.charAt(0);
            String s2 = str.substring(1);
            if (children[c-'a'] == null)
                children[c-'a'] = new TRIE2(c);
            children[c-'a'].add(s2);
        }

        public int find(String str) {
            if (str.length() == 0)
                return count;
            char c = str.charAt(0);
            if (children[c-'a'] == null)
                return 0;
            String s2 = str.substring(1);
            return children[c-'a'].find(s2);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        TRIE2 tree = new TRIE2(null);
        for(int t = 0; t < T; t++){
            String line = in.nextLine();
            tree.add(line);
        }
        T = in.nextInt();
        in.nextLine();
        for(int t = 0; t < T; t++){
            String line = in.nextLine();
            System.out.println(tree.find(line));
        }
    }
}
