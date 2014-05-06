package leetcode;

/**
 * Created by anthony on 5/6/14.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        s=s.trim();
        String []words = s.split(" ");
        if(words.length==0) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(words[words.length-1]);
        for(int i = words.length-2; i>=0; i--){
            if(words[i].length() == 0) continue;
            sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new ReverseWordsinaString().reverseWords("   a   b "));
    }
}
