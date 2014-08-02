package hihocoder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by anthony on 8/2/14.
 */
public class Week4 {
    static class TRIEGraphNode {
        public static final int CHILDREN_COUNT = 26;
        private Character currentChar = null;
        private TRIEGraphNode parent = null, jump_back_node = null;
        private boolean mark = false;
        private TRIEGraphNode children[] = new TRIEGraphNode[CHILDREN_COUNT];
        /*protected String DebugString = "";
        public String toString(){
            return DebugString;
        }*/
        public TRIEGraphNode(Character c, TRIEGraphNode p) {
           // if(c != null) DebugString = p.DebugString + c;
            currentChar = c;
            parent = p;
        }

        public void add(char[] str, int ptr) {
            if (str.length == ptr) {
                mark = true;
                return;
            }
            int idx = str[ptr] - 'a';
            if(idx < 0 || idx >= CHILDREN_COUNT){
                return;
            }
            if (children[idx] == null)
                children[idx] = new TRIEGraphNode(str[ptr], this);
            children[idx].add(str, ptr+1);
        }

        public static boolean find(TRIEGraphNode node, String str){
            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(node.mark)
                    return true;
                int idx = c-'a';
                if(idx < 0 || idx >= CHILDREN_COUNT){
                    break;
                }
                if(node.children[idx] == null)
                    return false;
                node = node.children[idx];
            }
            return node.mark;
        }

        //http://hihocoder.com/contest/hiho4/problem/1
        public static void build(TRIEGraphNode root){
            Queue<TRIEGraphNode> queue = new LinkedList<TRIEGraphNode>();
            root.jump_back_node = root;
            for(int i = 0; i < CHILDREN_COUNT; i++){
                if(root.children[i] != null){
                    root.children[i].jump_back_node = root;
                    queue.add(root.children[i]);
                }
                else{
                    root.children[i] = root;
                }
            }

            while(!queue.isEmpty()){
                TRIEGraphNode node = queue.poll();
                if(node.jump_back_node == null) {
                    //skip root & level 2 nodes
                    node.jump_back_node = node.parent.jump_back_node.children[node.currentChar - 'a'];
                }
                if(node.jump_back_node.mark){
                    node.mark = true;
                }
                if(node.mark){
                    //will teriminal here, no need to go deep
                    continue;
                }
                for(int i = 0; i < CHILDREN_COUNT; i++){
                    if(node.children[i] != null){
                        queue.add(node.children[i]);
                    }
                    else{
                        node.children[i] = node.jump_back_node.children[i];
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        in.nextLine();
        TRIEGraphNode tree = new TRIEGraphNode(null, null);
        for(int t = 0; t < T; t++){
            String line = in.nextLine();
            tree.add(line.toCharArray(), 0);
        }
        TRIEGraphNode.build(tree);

        String line = in.nextLine();
        System.out.println(TRIEGraphNode.find(tree, line)?"YES":"NO");
        in.close();
    }
}
