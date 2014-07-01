package lintcode;

/**
 * Created by anthony on 6/29/14.
 */
public class ReverseWordsinaString {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        if(s == null)
            return null;
        String s2[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = s2.length-1; i>= 0; i--){
            String _s = s2[i];
            if(_s.length() > 0){
                if(sb.length() > 0)
                    sb.append(' ');
                sb.append(_s);
            }
        }
        return sb.toString();
    }
}
