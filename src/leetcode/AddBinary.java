package leetcode;

/**
 * Created by anthony on 6/8/14.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0)
            return b;
        if(b == null || b.length() == 0)
            return a;
        char[] _a = a.toCharArray();
        char[] _b = b.toCharArray();

        int count = Math.max(_a.length, _b.length)+1;
        char[] result = new char[count];

        int a_i = _a.length-1, b_i = _b.length-1;
        int advance = 0;
        for(int i = 0; i < count; i++){
            int a_c = 0, b_c = 0;
            if(a_i >= 0){
                a_c = (_a[a_i] == '1')?1:0;
                a_i--;
            }
            if(b_i >= 0){
                b_c = (_b[b_i] == '1')?1:0;
                b_i--;
            }
            int r = a_c+b_c+advance;
            advance = r/2;
            r = r%2;
            result[i] = (r==1)?'1':'0';
        }
        StringBuilder sb = new StringBuilder();
        while(count > 1 && result[count-1] == '0')
            count--;
        while(count>0) {
            sb.append(result[count-1]);
            count--;
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.println(new AddBinary().addBinary("101", "1"));
    }
}
