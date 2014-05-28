package leetcode;

/**
 * Created by Anthony on 2014/5/28.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)
            return 1;
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }
        if(divisor == Integer.MAX_VALUE){
            if(dividend == Integer.MIN_VALUE || dividend == Integer.MIN_VALUE+1)
                return -1;
            return 0;
        }
        if(divisor == 0)
            return 0;   //WTF
        if(divisor == 1)
            return dividend;
        if(dividend == -1)
            return -dividend;
        int r = 0;
        if(dividend == Integer.MIN_VALUE){
            if(divisor > 0){
                r++;
                dividend += divisor;
            }
            else{
                r++;
                dividend -= divisor;
            }
        }
        boolean negative = false;
        if(divisor < 0){
            negative = !negative;
            divisor = -divisor;
        }
        if(dividend < 0){
            negative = !negative;
            dividend = -dividend;
        }
        int temp1[] = new int[33];
        int temp2[] = new int[33];
        temp1[0] = divisor;
        temp2[0] = 1;
        int count = 0;
        while(temp1[count] < dividend){
            temp1[count+1] = temp1[count]+temp1[count];
            temp2[count+1] = temp2[count]+temp2[count];
            count++;
            if(temp1[count] < 0){   //overflow
                count--;
                break;
            }
        }

        while(count >= 0){
            if(dividend >= temp1[count]){
                dividend -= temp1[count];
                r += temp2[count];
            }
            else
                count--;
        }
        return negative?-r:r;
    }

    public static void main(String args[]){
        System.out.println(new DivideTwoIntegers().divide(-2147483648, 3));
    }
}
