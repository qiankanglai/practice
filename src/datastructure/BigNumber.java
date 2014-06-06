package datastructure;

import java.util.Arrays;

/**
 * Created by anthony on 6/6/14.
 */
public class BigNumber {
    protected int []digital = null;

    public BigNumber(String n){
        digital = new int[n.length()];
        for(int i = 0; i < n.length(); i++)
            digital[i] = n.charAt(n.length()-1-i)-'0';
    }
    public BigNumber(int[] digital){
        this.digital = Arrays.copyOf(digital, digital.length);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = digital.length-1; i>=0; i--)
            sb.append(""+digital[i]);
        return sb.toString();
    }

    public static BigNumber multiply(BigNumber number1, BigNumber number2){
        int count = number1.digital.length * number2.digital.length+1;
        int []result = new int[count];
        Arrays.fill(result, 0);
        for(int i1 = 0; i1 < number1.digital.length; i1++)
            for(int i2 = 0; i2 < number2.digital.length; i2++)
                result[i1+i2] += number1.digital[i1]*number2.digital[i2];

        int advance = 0;
        for(int i = 0; i < count; i++){
            result[i] += advance;
            advance = result[i]/10;
            result[i] = result[i] % 10;
        }

        while(count > 0 && result[count-1]==0)
            count--;
        if(count == 0)
            count++;
        return new BigNumber(Arrays.copyOf(result, count));
    }
}
