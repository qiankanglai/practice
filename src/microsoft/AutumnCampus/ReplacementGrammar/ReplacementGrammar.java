package microsoft.AutumnCampus.ReplacementGrammar;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by anthony on 7/5/14.
 */
public class ReplacementGrammar {
    static class StringPair{
        String origin, result;
        public StringPair(String o, String r){
            origin = o;
            result = r;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/microsoft/AutumnCampus/ReplacementGrammar/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/ReplacementGrammar/ReplacementGrammar.txt"));

        ArrayList<StringPair> pairs = new ArrayList<StringPair>();
        String temp = reader.readLine();
        while (temp != null || temp.length() > 0) {
            int idx = temp.indexOf("|");
            if(idx < 0)
                break;
            pairs.add(new StringPair(temp.substring(0, idx), temp.substring(idx+1)));

            temp = reader.readLine();
        }
        while(temp.length() == 0 && temp != null){
            temp = reader.readLine();
        }

        for(StringPair pair : pairs){
            int idx = temp.indexOf(pair.origin);
            while(idx >= 0){
                String s0 = temp.substring(0, idx);
                String s2 = temp.substring(idx+pair.origin.length());
                temp = s0 + pair.result + s2;
                idx = idx + pair.result.length();
                idx = temp.indexOf(pair.origin, idx);
            }
        }
        writer.write(temp);
        writer.newLine();

        reader.close();
        writer.close();
    }
}
