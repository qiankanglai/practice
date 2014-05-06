package leetcode;

/**
 * Created by Anthony on 2014/5/6.
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num >= 1000){
            int k = num / 1000;
            for(int i = 0; i < k; i++)
                sb.append("M");
            num = num % 1000;
        }
        if(num >= 100){
            int k = num / 100;
            if(k==9)
                sb.append("CM");
            else if(k >= 5){
                sb.append("D");
                for(int i = 0; i < k % 5; i++)
                    sb.append("C");
            }
            else if(k == 4){
                sb.append("CD");
            }
            else{
                for(int i = 0; i < k % 5; i++)
                    sb.append("C");
            }
            num = num % 100;
        }
        if(num >= 10){
            int k = num / 10;
            if(k==9)
                sb.append("XC");
            else if(k >= 5){
                sb.append("L");
                for(int i = 0; i < k % 5; i++)
                    sb.append("X");
            }
            else if(k == 4){
                sb.append("XL");
            }
            else{
                for(int i = 0; i < k % 5; i++)
                    sb.append("X");
            }
            num = num % 10;
        }
        {
            int k = num;
            if(k==9)
                sb.append("IX");
            else if(k >= 5){
                sb.append("V");
                for(int i = 0; i < k % 5; i++)
                    sb.append("I");
            }
            else if(k == 4){
                sb.append("IV");
            }
            else{
                for(int i = 0; i < k % 5; i++)
                    sb.append("I");
            }

        }

        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(new IntegertoRoman().intToRoman(99));
    }
}
