package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Anthony on 14-4-29.
 */
public class ValidNumber {
    public static boolean isNumber0(String s) {
        if(s.length() == 0) return false;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i)<'0' || s.charAt(i)>'9')
                return false;
        return true;
    }
    public static boolean isNumber1(String s) {
        int index = s.indexOf('.');
        if(index >= 0){
            String s1 = s.substring(0, index);
            String s2 = s.substring(index+1);
            if(s1.length()+s2.length()==0)
                return false;
            if(s1.length()==0)
                s1 = "0";
            if(s2.length()==0)
                s2 = "0";
            return isNumber0(s1)&&isNumber0(s2);
        }
        else
            return isNumber0(s);
    }
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if(s.length() == 0) return false;
        int index = s.indexOf('e');
        if(index >= 0){
            String s1 = s.substring(0, index);
            String s2 = s.substring(index+1);
            if(s2.length()>1&&(s2.charAt(0)=='-'||s2.charAt(0)=='+'))
                s2 = s2.substring(1);
            return isNumber1(s1)&&isNumber0(s2);
        }
        else
            return isNumber1(s);
    }

    public static void main(String[] args){
        System.out.println(isNumber("0"));
        System.out.println(isNumber(" 0.1 "));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("-"));
    }
}
