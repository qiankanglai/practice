package google.codejam2014.round1c;

import java.io.*;

/**
 * Created by Anthony on 2014/5/11.
 */
public class PartElf {
    public static long  gcd(long  a, long  b) {// 循环实现
        long  k = 0;
        do {
            k = a % b;// 得到余数
            a = b;// 根据辗转相除法,把被除数赋给除数
            b = k;// 余数赋给被除数
        } while (k != 0);
        return a;// 返回被除数
    }

    public static int check(long  P, long  Q){
        int t = -1;
        long  g = gcd(P, Q);
        if(g>1){
            P /= g;
            Q /= g;
        }
        for(int i = 0; i < 40; i++){
            P *= 2;
            if(P >= Q){
                P = P % Q;
                if(t == -1)
                    t = i+1;
                if(P == 0)
                    return t;

                g=gcd(P, Q);
                if(g>1){
                    P /= g;
                    Q /= g;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/google/round1c/A-small-attempt0.in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("A-small.txt"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for(int _t = 0; _t < T; _t++){
            temp = reader.readLine();
            String[] temp2 = temp.split("/");
            long P = Long.parseLong(temp2[0]), Q = Long.parseLong(temp2[1]);
            System.out.println(_t);
            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            int t = check(P, Q);
            if(t < 0)
                writer.write("impossible");
            else
                writer.write(""+t);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
