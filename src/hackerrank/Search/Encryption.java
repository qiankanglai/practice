package hackerrank.Search;

import java.util.Scanner;

/**
 * Created by anthony on 7/13/14.
 */
public class Encryption {
    public static void main( String args[] ) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int len = input.length();
        int rows = (int) Math.ceil(Math.sqrt(len));
        int cols = rows;
        if(cols*(rows-1) >= len){
            rows--;
        }
        for(int x = 0; x < cols; x++){
            for(int y = 0; y < rows; y++){
                int id = y*cols+x;
                if(id < len){
                    System.out.print(input.charAt(id));
                }
            }
            System.out.print(' ');
        }
        //System.out.println();
    }
}
