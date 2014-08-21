package google.campustest2014.rounda;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anthony on 8/20/14.
 */
public class SpaceshipDefence {
    //一开始建模出问题了~直接把颜色相同的弄一起就行
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2014/rounda/E-large-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = in.nextInt();
            in.nextLine();
            HashMap<String, Integer> colors = new HashMap<String, Integer>();
            int colored_id[] = new int[n];
            int colored_ids = 0;
            for(int i = 0; i < n; i++){
                String color = in.nextLine().trim();
                if(colors.containsKey(color)){
                    colored_id[i] = colors.get(color);
                }
                else{
                    colors.put(color, colored_ids);
                    colored_id[i] = colored_ids;
                    colored_ids++;
                }
            }

            HashMap<Integer, Integer> map[] = new HashMap[colored_ids];
            for(int i = 0; i < colored_ids; i++){
                map[i] = new HashMap<Integer, Integer>();
                map[i].put(i, 0);
            }

            int m = in.nextInt();
            for(int i = 0; i < m; i++){
                int a = colored_id[in.nextInt()-1];
                int b = colored_id[in.nextInt()-1];
                int t = in.nextInt();
                map[a].put(b, Math.min(t, map[a].containsKey(b)?map[a].get(b):Integer.MAX_VALUE));
            }
            boolean []calculated = new boolean[colored_ids];
            Arrays.fill(calculated, false);

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.println(": ");

            int s = in.nextInt();
            boolean visited[] = new boolean[n];
            for(int _s = 0; _s < s; _s++){
                int from = colored_id[in.nextInt()-1], to = colored_id[in.nextInt()-1];
                if(!calculated[from]){
                    calculated[from] = true;

                    Arrays.fill(visited, false);
                    visited[from] = true;
                    for(int iter = 0; iter < colored_ids; iter++){
                        int id = -1, min_dist = Integer.MAX_VALUE;
                        for(Integer i : map[from].keySet()){
                            if(!visited[i] && map[from].get(i) < min_dist){
                                id = i;
                                min_dist = map[from].get(i);
                            }
                        }
                        if(id < 0)
                            break;
                        visited[id] = true;
                        for(Integer i : map[id].keySet()){
                            if(!visited[i]){
                                int d = min_dist + map[id].get(i);
                                int d2 = map[from].containsKey(i)?map[from].get(i):Integer
                                        .MAX_VALUE;
                                map[from].put(i, Math.min(d, d2));
                            }
                        }
                    }


                }
                if(map[from].containsKey(to))
                    System.out.println(map[from].get(to));
                else
                    System.out.println(-1);
            }
        }
        in.close();
    }

    public static void main_old(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2014/rounda/E-small-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            int n = in.nextInt();
            in.nextLine();
            String colors[] = new String[n];
            for(int i = 0; i < n; i++){
                colors[i] = in.nextLine().trim();
            }
            HashMap<Integer, Integer> map[] = new HashMap[n];
            for(int i = 0; i < n; i++){
                map[i] = new HashMap<Integer, Integer>();
                map[i].put(i, 0);
            }
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    if(colors[i].equals(colors[j])){
                        map[i].put(j, 0);
                        map[j].put(i, 0);
                    }
                }
            }

            int m = in.nextInt();
            for(int i = 0; i < m; i++){
                int a = in.nextInt()-1;
                int b = in.nextInt()-1;
                int t = in.nextInt();
                map[a].put(b, Math.min(t, map[a].containsKey(b)?map[a].get(b):Integer.MAX_VALUE));
            }
            boolean []calculated = new boolean[n];
            Arrays.fill(calculated, false);

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.println(": ");

            int s = in.nextInt();
            boolean visited[] = new boolean[n];
            for(int _s = 0; _s < s; _s++){
                int from = in.nextInt()-1, to = in.nextInt()-1;
                if(!calculated[from]){
                    calculated[from] = true;

                    Arrays.fill(visited, false);
                    visited[from] = true;
                    for(int iter = 0; iter < n; iter++){
                        int id = -1, min_dist = Integer.MAX_VALUE;
                        for(Integer i : map[from].keySet()){
                            if(!visited[i] && map[from].get(i) < min_dist){
                                id = i;
                                min_dist = map[from].get(i);
                            }
                        }
                        if(id < 0)
                            break;
                        visited[id] = true;
                        for(Integer i : map[id].keySet()){
                            if(!visited[i]){
                                int d = min_dist + map[id].get(i);
                                int d2 = map[from].containsKey(i)?map[from].get(i):Integer
                                        .MAX_VALUE;
                                map[from].put(i, Math.min(d, d2));
                            }
                        }
                    }


                }
                if(map[from].containsKey(to))
                    System.out.println(map[from].get(to));
                else
                    System.out.println(-1);
            }
        }
        in.close();
    }
}
