package codewars;

/**
 * Created by qiank on 1/27/2016.
 */
public class SpinWords {
    public String spinWords(String sentence) {
        String []s = sentence.split(" ");
        for(int i = 0; i < s.length; i++)
        {
            if(s[i].length() >= 5)
            {
                String t="";
                for(int j=s[i].length()-1;j>=0;j--)
                {
                    t+=s[i].charAt(j);
                }
                s[i]=t;
            }
        }
        String t=s[0];
        for(int i=1;i<s.length;i++)
        {
            t+=' '+s[i];
        }
        return t;
    }
}
