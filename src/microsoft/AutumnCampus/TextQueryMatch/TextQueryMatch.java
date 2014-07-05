package microsoft.AutumnCampus.TextQueryMatch;

import java.io.*;

/**
 * Created by anthony on 7/5/14.
 */
public class TextQueryMatch {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader
                ("src/microsoft/AutumnCampus/TextQueryMatch/SampleInput.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/microsoft/AutumnCampus/TextQueryMatch/TextQueryMatch.txt"));

        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        writer.write(String.valueOf(T));
        writer.newLine();
        for (int _t = 0; _t < T; _t++) {
            String query = reader.readLine().toLowerCase();
            String match = reader.readLine().toLowerCase();
            writer.write(check(query, match)?"true":"false");
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    private static boolean check(String query, String match) {
        int queryLength = query.length();
        int matchLength = match.length();
        for(int i = 0; i +queryLength <= matchLength; i++){
            if(i > 0 && match.charAt(i-1) != ' ') {
                //should be the start word
                continue;
            }
            int qi = 0, mi = i;
            while(qi < queryLength && mi < matchLength){
                if(query.charAt(qi) == match.charAt(mi)){
                    qi++;
                    mi++;
                }
                else{
                    if(match.charAt(mi) == ' '){
                        mi++;
                    }
                    else{
                        break;
                    }
                }
            }
            if(qi >= queryLength){
                return true;
            }
        }
        return false;
    }
}
