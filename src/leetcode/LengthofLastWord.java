package leetcode;

/**
 * Created by anthony on 5/16/14.
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) return 0;
        int l1=s.length()-1;
        while(l1>=0 && s.charAt(l1) == ' ')
            l1--;
        if(l1 < 0)
            return 0;
        else if(l1 == 0)
            return 1;

        int l2 = l1-1;
        while(l2>=0 && s.charAt(l2) != ' ')
            l2--;

        return l1-l2;
    }
}
