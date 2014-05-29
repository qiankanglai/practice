package google.round1a;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anthony on 4/26/14.
 */
/*
    ChargingChaos_old: old code, small AC & large incorrect
    https://code.google.com/codejam/contest/dashboard?c=2984486
 */
public class ChargingChaos {
    static boolean []parse(String s){
        boolean result[] = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++)
            result[i] = (s.charAt(i)=='1');
        return result;
    }
    static int convert(boolean []b, int length){
        int r = 0;
        if(length < 0)
            length = b.length;
        for(int i = 0; i < length; i++){
            r = r*2 +(b[i]?1:0);
        }
        return r;
    }
    static int convert2(boolean []b, boolean []d, int length){
        int r = 0;
        if(length < 0)
            length = b.length;
        for(int i = 0; i < length; i++){
            r = r*2 +((b[i]^d[i])?1:0);
        }
        return r;
    }

    static ArrayList<boolean[]> devices = new ArrayList<boolean[]>(), switches = new ArrayList<boolean[]>();
    static int[] devices_int, switches_int, devices_int_half, switches_int_half;
    static boolean[] dfs_switch;
    static int []devices_nonzero, switches_nonzero;
    static int N, L, minSteps, currentSteps;

    static void dfs(int level){
        if(level == L / 2){
            for(int i = 0; i < N; i++){
                devices_int_half[i] = convert2(devices.get(i), dfs_switch, L/2);
            }

            Arrays.sort(devices_int_half);
            int i = 0;
            for(; i<N; i++)
                if(devices_int_half[i] != switches_int_half[i])
                    break;
            if(i < N){
                return;
            }
        }
        if(level >= L){
            //check
            for(int i = 0; i < N; i++){
                devices_int[i] = convert2(devices.get(i), dfs_switch, -1);
            }
            Arrays.sort(devices_int);
            int i = 0;
            for(; i<N; i++)
                if(devices_int[i] != switches_int[i])
                    break;
            if(i >= N && currentSteps<minSteps){
                minSteps = currentSteps;
            }

            return;
        }

        if(devices_nonzero[level] == switches_nonzero[level]){
            dfs_switch[level] = false;
            dfs(level+1);
        }
        if(devices_nonzero[level] + switches_nonzero[level] == N){
            dfs_switch[level] = true;
            currentSteps++;
            dfs(level+1);
            currentSteps--;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1a/A-large-practice.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round1a/A-large-practice.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            System.out.println(_t);
            temp = reader.readLine();
            String []temp2 = temp.split(" ");
            N = Integer.parseInt(temp2[0]);
            L = Integer.parseInt(temp2[1]);
            devices.clear();
            devices_int = new int[N];
            devices_int_half = new int[N];
            switches.clear();
            switches_int = new int[N];
            switches_int_half = new int[N];
            dfs_switch = new boolean[L];
            temp = reader.readLine();
            temp2 = temp.split(" ");
            for(int i = 0; i < N; i++){
                devices.add(parse(temp2[i]));
            }
            temp = reader.readLine();
            temp2 = temp.split(" ");
            for(int i = 0; i < N; i++){
                switches.add(parse(temp2[i]));
                switches_int[i] = convert(switches.get(i), -1);
                switches_int_half[i] = convert(switches.get(i), L/2);
            }
            Arrays.sort(switches_int);
            Arrays.sort(switches_int_half);

            devices_nonzero = new int[L];
            switches_nonzero = new int[L];
            for(int i = 0; i < L; i++){
                devices_nonzero[i] = 0;
                for(int j = 0; j < N; j++)
                    if(devices.get(j)[i])
                        devices_nonzero[i]++;
                switches_nonzero[i] = 0;
                for(int j = 0; j < N; j++)
                    if(switches.get(j)[i])
                        switches_nonzero[i]++;
            }
            minSteps = L + 1;
            currentSteps = 0;
            dfs(0);

            writer.write("Case #");
            writer.write(""+(_t + 1));
            writer.write(": ");
            if(minSteps <= L)
                writer.write(""+minSteps);
            else
                writer.write("NOT POSSIBLE");
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}

class ChargingChaos_Old {
    static boolean []parse(String s){
        boolean result[] = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++)
            result[i] = (s.charAt(i)=='1');
        return result;
    }
    static int convert(boolean []b){
        int r = 0;
        for(int i = 0; i < b.length; i++){
            r = r*2 +(b[i]?1:0);
        }
        return r;
    }
    static int convert_10(boolean []b){
        int r = 0;
        for(int i = 0; i < 10; i++){
            r = r*2 +(b[i]?1:0);
        }
        return r;
    }
    static int convert2(boolean []b, boolean []d){
        int r = 0;
        for(int i = 0; i < b.length; i++){
            r = r*2 +((b[i]^d[i])?1:0);
        }
        return r;
    }
    static int convert2_10(boolean []b, boolean []d){
        int r = 0;
        for(int i = 0; i < 10; i++){
            r = r*2 +((b[i]^d[i])?1:0);
        }
        return r;
    }

    static ArrayList<boolean[]> devices = new ArrayList<boolean[]>(), switches = new ArrayList<boolean[]>();
    static int[] devices_int, switches_int, devices_int_10, switches_int_10;
    static boolean[] dfs_switch;
    static int []devices_nonzero, switches_nonzero;
    static int N, L, minSteps, currentSteps;

    static void dfs(int level){
        if(level == 10 && L > 20){
            for(int i = 0; i < N; i++){
                devices_int_10[i] = convert2_10(devices.get(i), dfs_switch);
            }

            Arrays.sort(devices_int_10);
            int i = 0;
            for(; i<N; i++)
                if(devices_int_10[i] != switches_int_10[i])
                    break;
            if(i < N){
                return;
            }
        }
        if(level >= L){
            //check
            for(int i = 0; i < N; i++){
                devices_int[i] = convert2(devices.get(i), dfs_switch);
            }
            Arrays.sort(devices_int);
            int i = 0;
            for(; i<N; i++)
                if(devices_int[i] != switches_int[i])
                    break;
            if(i >= N && currentSteps<minSteps){
                minSteps = currentSteps;
            }

            return;
        }

        if(devices_nonzero[level] == switches_nonzero[level]){
            dfs_switch[level] = false;
            dfs(level+1);
        }
        if(devices_nonzero[level] + switches_nonzero[level] == N){
            dfs_switch[level] = true;
            currentSteps++;
            dfs(level+1);
            currentSteps--;
        }
    }

    public static void main(String args[]) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1a/A-small-practice.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round1a/A-small-practice.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            System.out.println(_t);
            temp = reader.readLine();
            String []temp2 = temp.split(" ");
            N = Integer.parseInt(temp2[0]);
            L = Integer.parseInt(temp2[1]);
            devices.clear();
            devices_int = new int[N];
            devices_int_10 = new int[N];
            switches.clear();
            switches_int = new int[N];
            switches_int_10 = new int[N];
            dfs_switch = new boolean[L];
            temp = reader.readLine();
            temp2 = temp.split(" ");
            for(int i = 0; i < N; i++){
                devices.add(parse(temp2[i]));
            }
            temp = reader.readLine();
            temp2 = temp.split(" ");
            for(int i = 0; i < N; i++){
                switches.add(parse(temp2[i]));
                switches_int[i] = convert(switches.get(i));
                if(L > 20)
                    switches_int_10[i] = convert_10(switches.get(i));
            }
            Arrays.sort(switches_int);

            devices_nonzero = new int[L];
            switches_nonzero = new int[L];
            for(int i = 0; i < L; i++){
                devices_nonzero[i] = 0;
                for(int j = 0; j < N; j++)
                    if(devices.get(j)[i])
                        devices_nonzero[i]++;
                switches_nonzero[i] = 0;
                for(int j = 0; j < N; j++)
                    if(switches.get(j)[i])
                        switches_nonzero[i]++;
            }
            minSteps = L + 1;
            currentSteps = 0;
            dfs(0);

            writer.write("Case #");
            writer.write(""+(_t + 1));
            writer.write(": ");
            if(minSteps <= L)
                writer.write(""+minSteps);
            else
                writer.write("NOT POSSIBLE");
            writer.newLine();
        }

        reader.close();
        writer.close();
        long t2 = System.currentTimeMillis();
        System.out.println("Time(s):"+(t2-t1)/1000);
    }
}
