package lintcode;

/**
 * Created by Anthony on 2014/6/24.
 */
public class CompareStrings {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        if(A == null){
            return B==null;
        }
        if(B == null){
            return true;
        }
        int chars[] = new int[26];
        for(char c : A.toCharArray()){
            chars[c-'A']++;
        }
        for(char c : B.toCharArray()){
            chars[c-'A']--;
            if(chars[c-'A'] < 0)
                return false;
        }
        return true;
    }
}
