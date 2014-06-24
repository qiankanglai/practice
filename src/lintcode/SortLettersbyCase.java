package lintcode;

/**
 * Created by Anthony on 2014/6/24.
 */
public class SortLettersbyCase {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0)
            return;
        int ptr = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'a'){
                char c = chars[i];
                chars[i] = chars[ptr];
                chars[ptr] = c;
                ptr++;
            }
        }
    }

    public static void main(String args[]){
        char[] ch = "abAcD".toCharArray();
        new SortLettersbyCase().sortLetters(ch);
        System.out.println(ch);
    }
}
