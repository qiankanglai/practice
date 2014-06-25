package library;

/**
 * Created by anthony on 6/25/14.
 */
public class KMP {
    //http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
    public int indexOf(char[] S, char[] W){
        if(S == null || W == null)
            return -1;

        if(W.length > S.length)
            return -1;
        if(W.length == 0){
            return 0;
        }
        else if(W.length == 1){
            for(int i = 0; i < S.length; i++){
                if(S[i] == W[0])
                    return i;
            }
            return -1;
        }

        //kmp_table
        int[] T = new int[W.length];
        int pos = 2, cnd = 0;
        T[0] = -1;
        T[1] = 0;
        while(pos < W.length){
            if(W[pos-1] == W[cnd]){
                cnd++;
                T[pos] = cnd;
                pos++;
            }
            else if(cnd > 0){
                cnd = T[cnd];
            }
            else{
                T[pos] = 0;
                pos++;
            }
        }

        //kmp_search
        int m = 0, i = 0;
        while(m + i < S.length){
            if(W[i] == S[m+i]){
                if(i == W.length-1)
                    return m;
                else
                    i++;
            }
            else{
                if(T[i] > -1){
                    //jump to next available
                    i = T[i];
                    m = m+i-T[i];
                }
                else{
                    i = 0;
                    m++;
                }
            }
        }

        return -1;
    }

    public static void main(String args[]){
        System.out.println(new KMP().indexOf(
                "ABCABCDABABCDABCDABDE".toCharArray(),
                "ABCDABD".toCharArray()));
    }
}
