package microsoft.AutumnCampus.ClockAngles;

import java.io.*;

/**
 * Created by anthony on 7/5/14.
 */
public class ClockAngles {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/microsoft/AutumnCampus/ClockAngles/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/ClockAngles/ClockAngles.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        writer.write(String.valueOf(T));
        writer.newLine();
        for (int _t = 0; _t < T; _t++) {
            temp = reader.readLine();
            String []temp2 = temp.split(":");
            int h = Integer.parseInt(temp2[0]);
            int m = Integer.parseInt(temp2[1]);
            int s = Integer.parseInt(temp2[2]);

            // Degree for three handlers
            double t1 = (h % 12 + (m + s/60.0) / 60.0)*(360.0/12.0);
            double t2 = (m + s/60.0) * (360.0/60.0);
            double t3 = (s) * 360.0 / 60.0;

            // Round to 2 decimal places
            writer.write(formatter(t2, t1));
            writer.write(", ");
            writer.write(formatter(t3, t1));
            writer.write(", ");
            writer.write(formatter(t3, t2));
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    private static String formatter(double v1, double v2) {
        double v = (v1 >= v2)?(v1-v2):(v2 - v1);
        if(v > 180){
            v = 360-v;
        }
        //Formatter...I forgot the API :(
        long r = Math.round(v * 100);
        String s1 = String.valueOf(r/100)+'.';
        String s2 = String.valueOf(r%100);
        if(s2.length() == 1){
            s2 = "0"+s2;
        }
        return s1+s2;
    }
}
