package careercup;

import java.util.Random;

/**
 * Created by Anthony on 2014/6/10.
 */
public class Facebook1 {
    //http://www.careercup.com/question?id=5762415492857856
    public static int count(String s){
        char s_trimed[] = new char[s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            s_trimed[count] = s.charAt(i);
            count++;
            while(count >= 3 && s_trimed[count-1] == '*' && s_trimed[count-2]=='x' && s_trimed[count-3] == 'x'){
                count-=2;
            }
        }
        if(count == 0)
            return 0;

        int dp[][] = new int[count][count];
        for(int i = 0; i < count; i++)
            dp[i][0] = (s_trimed[i] == 'x')?0:1;

        for(int step = 2; step <= count; step++){
            for(int start = 0; start+step <= count; start++){
                int t1 = dp[start][(step-1)-1]+1;   //remove current one
                for(int step1 = 1; step1 < step-1; step1++){
                    int t2 = dp[start][step1-1]+dp[start+step1][(step-1-step1)-1]+(s_trimed[start+step-1]=='*'?0:1);
                    if(t1 > t2)
                        t1 = t2;
                }
                for(int step1 = 1; step1 < step; step1++){
                    int t2 = dp[start][step1-1]+dp[start+step1][(step-step1)-1]+1;
                    if(t1 > t2)
                        t1 = t2;
                }
                dp[start][step-1] = t1;
            }
        }

        return dp[0][count-1];
    }

    public static void main(String args[]){
        if(true){
            StringBuilder sb = new StringBuilder();
            Random rand = new Random();
            for(int i = 0; i < 200; i++){
                if(rand.nextInt(10) < 5)
                    sb.append('x');
                else
                    sb.append('*');
            }
            String s = sb.toString();
            System.out.println(s);
            System.out.println(count(s));
        }
        //System.out.println(count("x*xxxxxxxx*xx*x*x******x**xxx*"));
        //System.out.println(count("*xx***xxx*x**x"));
        System.out.println(count("xxxxxxxxxx"));
    }
}
