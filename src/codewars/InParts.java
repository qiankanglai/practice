package codewars;

/**
 * Created by qiank on 1/27/2016.
 */
public class InParts {
    public static String splitInParts(String s, int partLength) {
        String s2 = "";
        int k = partLength;
        for(int i = 0; i < s.length(); i++){
            if(k==0)
            {
                s2 += ' ';
                k=partLength;
            }
            s2 += s.charAt(i);
            k--;
        }
        return s2;
    }

    public static void main(String args[]){
        System.out.println(splitInParts("HelloKata", 1));
    }
}
