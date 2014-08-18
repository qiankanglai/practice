package google.campustest.practice2014;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Created by anthony on 4/5/14.
 */
public class BadHorse {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader
                ("src/google/campustest/practice2014/A-small-practice-2.in"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            temp = reader.readLine();
            int M = Integer.parseInt(temp);

            HashMap<String, ArrayList<String>> input = new HashMap<String, ArrayList<String>>();
            for(int i = 0; i < M; i++){
                temp = reader.readLine();
                String[] names = temp.split(" ");
                if(input.get(names[0]) == null){
                    input.put(names[0], new ArrayList<String>());
                }
                input.get(names[0]).add(names[1]);
                if(input.get(names[1]) == null){
                    input.put(names[1], new ArrayList<String>());
                }
                input.get(names[1]).add(names[0]);
            }

            boolean flag = true;
            HashMap<String, Boolean> map = new HashMap<String, Boolean>();
            for(String s : input.keySet()){
                if(map.containsKey(s))
                    continue;

                Stack<String> names = new Stack<String>();
                names.add(s);
                map.put(s, true);

                while(!names.isEmpty()){
                    String name = names.pop();
                    boolean b = map.get(name);
                    for(String s2 : input.get(name)){
                        if(map.containsKey(s2)){
                            if(map.get(s2) == b){
                                flag = false;
                                break;
                            }
                        }
                        else{
                            map.put(s2, !b);
                            names.add(s2);
                        }
                    }
                }
                if(!flag)
                    break;
            }
            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(flag?"Yes":"No");
        }

        reader.close();
    }
}
