package google.campustest2015.rounda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Anthony on 9/17/2014.
 */
public class SevenSegmentDisplay {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(new File
                ("src/google/campustest2015/rounda/A-small-practice.in"));
        String temp = in.nextLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            temp = in.nextLine();
            String[] t2 = temp.split(" ");
            int N = Integer.parseInt(t2[0]);
            ArrayList<boolean[]> states = new ArrayList<boolean[]>();
            for(int i = 0; i < N; i++){
                String t3 = t2[i+1];
                boolean state[] = new boolean[7];
                for(int j = 0; j < 7; j++){
                    state[j] = t3.charAt(j) == '1';
                }
                states.add(state);
            }

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(solve(states));
        }
        in.close();
    }

    enum segment_state {unknown, good, bad};
    private final static boolean segment_map[][] = {
            // A       B       C       D      E       F       G
            {true , true , true , true , true , true , false},
            {false, true , true , false, false, false, false},
            {true , true , false, true , true , false, true },
            {true , true , true , true , false, false, true },
            {false, true , true , false, false, true , true },
            {true , false, true , true , false, true , true },
            {true , false, true , true , true , true , true },
            {true , true , true , false, false, false, false},
            {true , true , true , true , true , true , true },
            {true , true , true , true , false, true , true }
    };

    private static String solve(ArrayList<boolean[]> states) {
        segment_state[] segments = new segment_state[7];
        for(int i = 0; i < 7; i++){
            segments[i] = segment_state.unknown;
        }
        for(boolean[] state : states){
            for(int i = 0; i < 7; i++){
                if(state[i]) {
                    segments[i] = segment_state.good;
                }
            }
        }
        ArrayList<segment_state[]> candidates = new ArrayList<segment_state[]>();
        ArrayList<Integer> candidate_current = new ArrayList<Integer>();
        for(int start = 0; start <= 9; start++){
            segment_state[] segments2 = new segment_state[7];
            for(int i = 0; i < 7; i++){
                segments2[i] = segments[i];
            }
            int idx = 0;
            int current = start;
            for(boolean[] state : states){
                if(check(segments2, state, segment_map[current])){
                    idx++;
                    current = (current + 9) % 10;
                }
                else{
                    break;
                }
            }
            if(idx >= states.size()){
                boolean flag = true;
                if(flag){
                    candidates.add(segments2);
                    candidate_current.add(current);
                }
            }
        }
        if(candidates.size() == 0) {
            return "ERROR!";
        }
        String res = null;
        for(int l = 0; l < candidates.size(); l++) {
            StringBuilder sb = new StringBuilder();
            segment_state state[] = candidates.get(l);
            int current = candidate_current.get(l);
            // 就算有的位不能确定，只要不亮也无所谓的
            for (int i = 0; i < 7; i++) {
                if(segment_map[current][i]) {
                    if (state[i] == segment_state.good)
                        sb.append('1');
                    else if(state[i] == segment_state.unknown)  //出现无法确定情况1：某些应该亮的地方不知道灯泡好不好
                        return "ERROR!";
                    else
                        sb.append('0');
                }
                else
                    sb.append('0');
            }
            String res2 = sb.toString();
            if(res == null){
                res = res2;
            }
            else {
                //出现无法确定情况1：有多个解
                if (!res.equals(res2)) {
                    return "ERROR!";
                }
            }
        }
        return res;
    }

    private static boolean check(segment_state[] segments, boolean[] state, boolean[] map) {
        for(int i = 0; i < 7; i++){
            if(state[i]){
                if(map[i]){
                    if(segments[i] == segment_state.unknown){
                        segments[i] = segment_state.good;
                    }
                    else if(segments[i] == segment_state.bad){
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else{
                if(map[i]){
                    if(segments[i] == segment_state.unknown){
                        segments[i] = segment_state.bad;
                    }
                    else if(segments[i] == segment_state.good){
                        return false;
                    }
                }
                else{
                    continue;
                }
            }
        }
        return true;
    }
}
