package google.round1c;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Anthony on 2014/5/11.
 */
public class ReorderingTrainCars {
    static boolean[] visited;
    static int count, N;
    static String[] temp2;

    static int[] characters = new int[26];
    public static void dfs(int current_train, int level){
        String ct = temp2[current_train];
        int i;
        for(i = 0; i < ct.length(); i++){
            char c = ct.charAt(i);
            characters[c-'a']++;
            if(characters[c-'a'] > 1) {
                if (i > 0 && ct.charAt(i - 1) != c)
                    break;
            }
        }
        if(i < ct.length()){
            //rollback
            while(i >= 0){
                characters[ct.charAt(i)-'a']--;
                i--;
            }
            return;
        }
        if(level == visited.length-1){
            count ++;
        }
        for(int p = 0; p < N; p++){
            if(!visited[p]) {
                char c = temp2[p].charAt(0);
                if(characters[c-'a'] == 0 || ct.charAt(ct.length()-1) == c) {
                    visited[p] = true;
                    dfs(p, level + 1);
                    visited[p] = false;
                }
            }
        }

        for(i = 0; i < ct.length(); i++) {
            char c = ct.charAt(i);
            characters[c - 'a']--;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1c/B-large.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("B-small.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);
            temp = reader.readLine();
            N = Integer.parseInt(temp);
            temp = reader.readLine();
            temp2 = temp.split(" ");
            Arrays.sort(temp2);
            for(int i = 0; i < N; i++){
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<temp2[i].length(); k++) {
                    if (sb.length() > 0 && temp2[i].charAt(k) == sb.charAt(sb.length() - 1))
                        continue;
                    sb.append(temp2[i].charAt(k));
                }
                temp2[i] = sb.toString();
            }
            visited = new boolean[N];

            count = 0;
            for(int i=0; i<N; i++){
                Arrays.fill(visited, false);
                Arrays.fill(characters, 0);
                visited[i]=true;
                dfs(i,0);
                visited[i]=false;
            }

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write(""+count);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
