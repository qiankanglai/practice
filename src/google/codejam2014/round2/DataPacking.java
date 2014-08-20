package google.codejam2014.round2;

import java.io.*;
import java.util.Arrays;

/**
 * Created by anthony on 5/31/14.
 */
public class DataPacking {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round2/A-large.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/round2/A-large.out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);

            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int N = Integer.parseInt(temp2[0]);
            int X = Integer.parseInt(temp2[1]);

            temp = reader.readLine();
            temp2 = temp.split(" ");
            int[] files = new int[N];
            for(int i = 0; i < N; i++)
                files[i] = Integer.parseInt(temp2[i]);

            Arrays.sort(files);
            boolean[] used = new boolean[N];
            Arrays.fill(used, false);
            int disks = 0;
            for(int i = 0; i < N; i++){
                if(used[i])
                    continue;
                used[i] = true;
                disks++;
                int available = X-files[i];
                if(i < N-1 && files[i+1]>available)
                    continue;
                int last_idx = -1;
                for(int j = i+1; j<N; j++) {
                    if (files[j] > available)
                        break;
                    else if(!used[j]){
                        last_idx = j;
                    }
                }
                if(last_idx > 0){
                    used[last_idx] = true;
                }
            }


            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write("" + disks);
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
