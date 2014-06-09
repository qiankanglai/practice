package leetcode;

/**
 * Created by Anthony on 2014/6/9.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;
        if(s.length() == 0) return true;

        int cache[] = new int[s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a' && c <= 'z'){
                cache[count] = c-'a';
                count++;
            }
            else if(c >= 'A' && c <= 'Z'){
                cache[count] = c-'A';
                count++;
            }
            else if(c >= '0' && c <= '9'){
                cache[count] = c-'0'+30;
                count++;
            }
        }
        if(count == 0)
            return true;
        for(int i = 0; i*2 < count; i++){
            if(cache[i] != cache[count-1-i])
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        //System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        //System.out.println(new ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new ValidPalindrome().isPalindrome("race a car"));
    }
}
