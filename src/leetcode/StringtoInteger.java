package leetcode;

/**
 * Created by Anthony on 2014/5/25.
 */
public class StringtoInteger {
    public int atoi(String str) {
        str = str.trim();
        if(str.length() == 0)
            return 0;
        boolean negative = false;
        if(str.charAt(0) == '+')
            str = str.substring(1);
        else if(str.charAt(0) == '-'){
            negative = true;
            str = str.substring(1);
        }

        long result = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9')
                return (int) (negative?-result:result);
            result = result * 10 + (str.charAt(i)-'0');
            if(!negative && result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(negative && -result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) (negative?-result:result);
    }

    public static void main(String args[]){
        System.out.println(new StringtoInteger().atoi("-2147483649"));
    }
}
