package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anthony on 6/8/14.
 */
public class RestoreIPAddresses {
    public boolean check(String s){
        if(s==null)
            return false;
        if(s.length() == 1)
            return true;
        else if(s.length() == 2)
            return (s.charAt(0) != '0');
        else if(s.length() == 3){
            char[] c = s.toCharArray();
            if(c[0] < '1' || c[0] > '2')
                return false;
            else if(c[0] == '1')
                return true;
            else{
                if(c[1] < '5')
                    return true;
                else if(c[1] == '5')
                    return c[2] < '6';
                else
                    return false;
            }
        }
        return false;
    }

    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s == null || s.length() < 4)
            return res;
        for(int i1 = 1; i1 <= 3; i1++){
            String s1 = s.substring(0, i1);
            if(!check(s1))
                continue;
            for(int i2 = 1; i2 <= 3; i2++){
                if(i1+i2+2 > s.length())
                    continue;
                String s2 = s.substring(i1, i1+i2);
                if(!check(s2))
                    continue;
                for(int i3 = 1; i3 <= 3; i3++){
                    if(i1+i2+i3+1 > s.length())
                        continue;
                    if(i1+i2+i3+3 < s.length())
                        continue;
                    String s3 = s.substring(i1+i2, i1+i2+i3);
                    String s4 = s.substring(i1+i2+i3);
                    if(check(s3) && check(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String args[]){
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("000256"));
    }
}
