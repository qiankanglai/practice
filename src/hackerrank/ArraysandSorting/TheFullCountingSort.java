package hackerrank.ArraysandSorting;

import java.util.Scanner;

/**
 * Created by anthony on 7/4/14.
 */
public class TheFullCountingSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder[] str = new StringBuilder[100];

        for (int i = 0; i < n; i++) {
            int t = in.nextInt();
            String s = in.nextLine();
            if(str[t] == null)
                str[t] = new StringBuilder();
            if(i*2 < n){
                str[t].append("- ");
            }
            else{
                str[t].append(s.substring(1));
                str[t].append(' ');
            }
        }

        for(int i = 0; i < 100; i++){
            if(str[i] != null){
                System.out.print(str[i].toString());
            }
        }
    }
}
