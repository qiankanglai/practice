package google.codejam2015.round1a;

import java.io.*;

/**
 * Created by anthony on 4/11/15.
 */
public class OminousOmino {
    //TODO:unfinished
    public static void main(String args[]) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("src/google/codejam2015/round1a/D-small-attempt1" +
                ".in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/codejam2015/round1a/D-small-attempt1" +
                ".out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);
            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int X = Integer.parseInt(temp2[0]);
            int R = Integer.parseInt(temp2[1]);
            int C = Integer.parseInt(temp2[2]);

            boolean found = check(X, R, C);

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write(found?"GABRIEL":"RICHARD");
            writer.newLine();
        }
        reader.close();
        writer.close();
        long t2 = System.currentTimeMillis();
        System.out.println("Time(s):"+(t2-t1)/1000);
    }

    // wrong answer
    private static boolean check(int x, int r, int c) {
        if(r*c % x != 0)
            return false;    //cannot find
        else{
            if(x > Math.max(r, c))
                return false;
            else
                return true;
        }
    }
}
