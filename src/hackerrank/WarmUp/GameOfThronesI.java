package hackerrank.WarmUp;

import java.util.*;

public class GameOfThronesI {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();

        int counts[] = new int[26];
        Arrays.fill(counts, 0);
        for(char c : inputString.toCharArray()){
            int t = c - 'a';
            if(t >= 0 && t < 26)
                counts[t]++;
        }
        int odds = 0;
        for(int i = 0; i < 26; i++){
            if(counts[i] % 2 == 1)
                odds++;
        }
        // Assign ans a value of s or no, depending on whether or not inputString satisfies the required condition
        System.out.println(odds<=1?"YES":"NO");
        myScan.close();
    }
}
