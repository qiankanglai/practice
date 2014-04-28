package google.campustest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anthony on 4/5/14.
 */
public class BadHorse {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(""));
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

            ArrayList<String> names = new ArrayList<String>(input.keySet());
            //HOLY SHIT: I should check new colored nodes first!!! using a sorted arraylist
            while(names.size() > 0){
                String name0 = names.remove(0);
                Boolean v0 = map.get(name0);
                if(v0 == null){
                    map.put(name0, true);
                    v0 = true;
                }
                Boolean _v1 = (v0==true)?false:true;

                ArrayList<String> name1s = input.get(name0);
                for(String name1 : name1s){
                    Boolean v1 = map.get(name1);
                    if(v1 == null){
                        map.put(name1, _v1);
                        names.remove(name1);
                        names.add(0, name1);
                    }
                    else if(v1 != _v1){
                        flag = false;
                        break;
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
