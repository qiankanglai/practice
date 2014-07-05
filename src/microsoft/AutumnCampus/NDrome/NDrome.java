package microsoft.AutumnCampus.NDrome;

import java.io.*;

/**
 * Created by anthony on 7/5/14.
 */
public class NDrome {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/microsoft/AutumnCampus/NDrome/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/NDrome/NDrome.txt"));

        while (true) {
            String temp = reader.readLine();
            if (temp == null || temp.length() == 0)
                break;

            int idx = temp.indexOf("|");
            //System.out.println(temp.substring(0, idx));
            //System.out.println(temp.substring(idx+1));
            char c[] = temp.substring(0, idx).toCharArray();
            int n = Integer.parseInt(temp.substring(idx+1));

            writer.write(temp);
            writer.write("|");
            writer.write(check(c, n)?"1":"0");
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    private static boolean check(char[] c, int n) {
        if(c == null || c.length == 0 || n <= 0 || c.length % n != 0)
            return false;
        int i = 0, j = c.length - n;
        while(i < j){
            for(int k = 0; k < n; k++){
                if(c[i+k] != c[j+k])
                    return false;
            }
            i += n;
            j -= n;
        }
        return true;
    }
}
