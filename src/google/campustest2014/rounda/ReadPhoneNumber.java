package google.campustest2014.rounda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by anthony on 8/20/14.
 */
public class ReadPhoneNumber {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader
                ("src/google/campustest2014/rounda/A-large-practice.in"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            temp = reader.readLine();
            String temp2[] = temp.split(" ");
            StringBuilder sb = new StringBuilder();
            String temp3[] = temp2[1].split("-");
            int offset = 0;
            for(String s : temp3){
                int t = Integer.parseInt(s);
                String current = temp2[0].substring(offset, offset+t);
                offset += t;
                convert(current, sb);
                //System.out.println(current);
            }
            System.out.print("Case #");
            System.out.print(_t+1);
            System.out.print(": ");
            System.out.println(sb.toString().substring(1));
        }
        reader.close();
    }

    private static String number2string(int c){
        switch (c){
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "";
    }

    private static String number2string2(int c){
        switch (c){
            case 2:
                return "double";
            case 3:
                return "triple";
            case 4:
                return "quadruple";
            case 5:
                return "quintuple";
            case 6:
                return "sextuple";
            case 7:
                return "septuple";
            case 8:
                return "octuple";
            case 9:
                return "nonuple";
            case 10:
                return "decuple";
        }
        return "";
    }

    private static String convert(String current, StringBuilder sb) {
        char c[] = current.toCharArray();
        for(int i = 0; i < c.length; i++){
            int k = 1;
            while(i + k < c.length && c[i] == c[i+k]){
                k++;
            }
            k--;
            if(k > 0 && k < 10){
                sb.append(' ');
                sb.append(number2string2(k + 1));
                i += k;
            }
            else if(k >= 10){
                while(k > 0) {
                    sb.append(' ');
                    sb.append(number2string(c[i] - '0'));
                    i++;
                    k--;
                }
            }
            sb.append(' ');
            sb.append(number2string(c[i]-'0'));
        }
        return null;
    }
}
