package google.codejam2015.round1a;

import java.io.*;
import java.util.Arrays;

/**
 * Created by anthony on 4/11/15.
 */
public class InfiniteHouseofPancakes {
    public static void main(String args[]) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("src/google/codejam2015/round1a/B-large" +
                ".in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/codejam2015/round1a/B-large" +
                ".out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);
            temp = reader.readLine();
            int D = Integer.parseInt(temp);
            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int P[] = new int[D];
            for(int i = 0; i < D; i++) {
                P[i] = Integer.parseInt(temp2[i]);
            }
            Arrays.sort(P);
            int current_best = P[D-1];
            for(int threshold = 1; threshold <= P[D-1]; threshold++){
                int sum = threshold;
                for(int i = 0; i < D; i++){
                    int c = P[i] / threshold;
                    if(c * threshold == P[i])
                        c--;
                    sum += c;
                }
                if(sum < current_best)
                    current_best = sum;
            }

            // old wrong method
            /*int sum_move = 0;
            while(true) {
                if(P[D-1] == 1 || sum_move > current_best) break;
                int threshold = P[D-1]/2;
                if(P[D-1] > threshold*2)
                    threshold++;
                int idx = D-1;
                while(idx >= 0 && P[idx] > threshold)
                    idx--;
                idx++;
                sum_move += (D-idx);
                int new_best = threshold + sum_move;
                if(new_best <= current_best) {
                    current_best = new_best;
                }

                int[] P2 = new int[D+(D-idx)];
                for(int i = 0; i < idx; i++)
                    P2[i] = P[i];
                int ptr = idx;
                int ptr2 = 0;
                for(int i = idx; i < D; i++)
                {
                    if(P[i]%2==1 && P2[ptr2] == 1) {
                        P2[ptr2] = P[i]/2 + 1;
                        ptr2++;
                        P2[ptr] = P[i]/2 + 1;
                        ptr++;
                    }
                    else {
                        P2[ptr] = P[i]/2;
                        ptr++;
                        P2[ptr] = P[i] - P[i] / 2;
                        ptr++;
                    }
                }
                D = ptr;
                P = Arrays.copyOf(P2, ptr);
                Arrays.sort(P);
            }*/
            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write("" + current_best);
            writer.newLine();
        }
        reader.close();
        writer.close();
        long t2 = System.currentTimeMillis();
        System.out.println("Time(s):"+(t2-t1)/1000);
    }
}
