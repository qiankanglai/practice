package leetcode;

/**
 * Created by anthony on 4/22/14.
 */
public class RomantoInteger {
    public int convert(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }

    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            boolean positive = true;
            char c1 = s.charAt(i);
            if(i < s.length()-1){
                char c2 = s.charAt(i+1);
                if(c1=='I'&&(c2=='V'||c2=='X'))
                    positive = false;
                if(c1=='X'&&(c2=='L'||c2=='C'))
                    positive = false;
                if(c1=='C'&&(c2=='D'||c2=='M'))
                    positive = false;
            }
            if(positive)
                result += convert(c1);
            else
                result -= convert(c1);
        }
        return result;
    }

    public static void main(String[] args){
        RomantoInteger w = new RomantoInteger();
        System.out.println(w.romanToInt("IV"));
    }
}
