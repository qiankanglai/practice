package google.campustest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anthony on 4/5/14.
 */
public class CaptainHammer {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("captainhammer.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            temp = reader.readLine();
            String[] t = temp.split(" ");
            int V = Integer.parseInt(t[0]), D = Integer.parseInt(t[1]);
            double x = 9.8*D/V/V;
            if(x > 1)
                x = 1;
            double theta = Math.asin(x)/Math.PI*180;
            theta /= 2;

            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(theta);
        }

        reader.close();
    }
}
