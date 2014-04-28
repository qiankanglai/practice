package google.round1a;

import java.io.*;
import java.util.Random;

/**
 * Created by anthony on 4/26/14.
 */
public class ProperShuffle {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1a/C-small-attempt0.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output3.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        Random rand = new Random();
        for(int _t = 0; _t < T; _t++){
            System.out.print(_t);

            temp = reader.readLine();
            int N = Integer.parseInt(temp);
            temp = reader.readLine();
            String []temp2 = temp.split(" ");
            int []array = new int[N];
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(temp2[i]);
            }

            boolean flag = true;
            int count = 0, c2 = 0;
            int c3 = 0;
            for(int i = 0; i < N; i++){
                //int index = rand.nextInt(i);
                for(int index = 0; index < i; index++){
                    if(array[i] > array[index])
                        count++;
                        c2++;
                }
                if(array[i] == i)
                    c3++;
            }
            System.out.print(':');
            float rate = (float)count / c2;
            System.out.println(c3);
            flag = c3 == 1;

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            if(flag)
                writer.write("GOOD");
            else
                writer.write("BAD");
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
