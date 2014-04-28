package leetcode;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: anthony
 * Date: 11/2/13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<Integer> starts = new ArrayList<Integer>(), ends = new ArrayList<Integer>();
        int start = 0, length = words[0].length();
        for(int i = 1; i < words.length; i++){
            if(length + words[i].length() + 1 <= L){
                length += words[i].length() + 1;
            }
            else{
                starts.add(start);
                ends.add(i-1);
                start = i;
                length = words[i].length();
            }
        }
        starts.add(start);
        ends.add(words.length-1);
        for(int i = 0; i < starts.size(); i++){
            int s = starts.get(i), e = ends.get(i);
            if(s == e || i == starts.size()-1){
                StringBuffer str = new StringBuffer();
                str.append(words[s]);
                s++;
                while(s <= e){
                    str.append(' ');
                    str.append(words[s]);
                    s++;
                }
                while(str.length() < L)
                    str.append(' ');
                result.add(str.toString());
            }
            else{
                int l = L;
                for(int p = s; p <= e; p++)
                    l -= words[p].length();
                int s2 = l / (e-s), s1 = l - s2 * (e-s);
                StringBuffer str = new StringBuffer();
                str.append(words[s]);
                s++;
                while(s <= e){
                    if(s1 > 0){
                        s1--;
                        str.append(' ');
                    }
                    for(int p=0;p<s2;p++) str.append(' ');
                    str.append(words[s]);
                    s++;
                }
                result.add(str.toString());
            }
        }

        return result;
    }


    public static void main(String[] args){
        String[] str = {"Don't","go","around","saying","the","world","owes","you","a","living;","the","world","owes","you","nothing;","it","was","here","first."};
        TextJustification w = new TextJustification();
        long t1 = System.currentTimeMillis();
        System.out.println(w.fullJustify(str, 30));
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }
}
