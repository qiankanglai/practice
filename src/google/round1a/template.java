package google.round1a;

import java.io.*;

/**
 * Created by anthony on 4/26/14.
 */
public class template {

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("badhorse.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            temp = reader.readLine();

            writer.write("Case #");
            writer.write(""+(_t + 1));
            writer.write(": ");
            writer.newLine();
        }

        reader.close();
        writer.close();
    }
}
