package google.codejam2015.round1a;

import java.io.*;

/**
 * Created by anthony on 4/11/15.
 */
public class Dijkstra {
    public static final int minus_ONE = 0;
    public static final int minus_I = 1;
    public static final int minus_J = 2;
    public static final int minus_K = 3;
    public static final int ONE = 4;
    public static final int I = 5;
    public static final int J = 6;
    public static final int K = 7;

    public static int multiply(int a, int b) {
        boolean negative = false;
        if(a < ONE) {
            negative = !negative;
            a += 4;
        }
        if(b < ONE) {
            negative = !negative;
            b += 4;
        }
        int result = -1;
        if(a == ONE) {
            if(b == ONE) {
                result = ONE;
            }
            else if(b == I) {
                result = I;
            }
            else if(b == J) {
                result = J;
            }
            else if(b == K) {
                result = K;
            }
        }
        else if(a == I) {
            if(b == ONE) {
                result = I;
            }
            else if(b == I) {
                negative = !negative;
                result = ONE;
            }
            else if(b == J) {
                result = K;
            }
            else if(b == K) {
                negative = !negative;
                result = J;
            }
        }
        else if(a == J) {
            if(b == ONE) {
                result = J;
            }
            else if(b == I) {
                negative = !negative;
                result = K;
            }
            else if(b == J) {
                negative = !negative;
                result = ONE;
            }
            else if(b == K) {
                result = I;
            }
        }
        else if(a == K) {
            if(b == ONE) {
                result = K;
            }
            else if(b == I) {
                result = J;
            }
            else if(b == J) {
                negative = !negative;
                result = I;
            }
            else if(b == K) {
                negative = !negative;
                result = ONE;
            }
        }

        assert(result >= 0);
        if(negative) {
            result -= 4;
        }
        return result;
    }

    public static int GetComplexNum(long count, int L, String input) {
        count = count % L;
        char c = input.charAt((int)count);
        if(c == 'i')
            return I;
        else if(c == 'j')
            return J;
        else if(c == 'k')
            return K;

        assert(false);
        return -1;
    }

    public static int pow2(int x, long p) {
        if(p == 0)
            return ONE;
        else if(p == 1)
            return x;
        else {
            int t = pow2(x, p/2);
            t = multiply(t, t);
            if(p % 2 == 1)
                t = multiply(t, x);
            return t;
        }
    }

    public static void main(String args[]) throws IOException {
        long t1 = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("src/google/codejam2015/round1a/C-large" +
                ".in"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/google/codejam2015/round1a/C-large" +
                ".out"));
        String temp = reader.readLine();
        int T = Integer.parseInt(temp);
        for (int _t = 0; _t < T; _t++) {
            System.out.println(_t);
            temp = reader.readLine();
            String[] temp2 = temp.split(" ");
            int L = Integer.parseInt(temp2[0]);
            long X = Long.parseLong(temp2[1]);
            String input = reader.readLine();
            boolean found = false;
            // quick check
            int result1 = multiply(I, J);
            result1 = multiply(result1, K);
            int result_single = ONE;
            for(int i = 0; i < L; i++) {
                result_single = multiply(result_single, GetComplexNum(i, L, input));
            }
            int result2 = pow2(result_single, X);
            if(result2 == result1) {
                int result_t1 = ONE, result_t2 = ONE;
                // check in detail
                long i = 0;
                // Attention: at mose check 5 L length is enough
                // since 2 L becomes -1 (assuming L becomes +/- i/j/k/1, anyway)
                for(; i < Math.min(X*L-2, L*5); i++) {
                    result_t1 = multiply(result_t1, GetComplexNum(i, L, input));
                    if(result_t1 == I)
                        break;
                }
                long j = X*L-1;
                for(; j >Math.max(i, X*L-L*5); j--) {
                    result_t2 = multiply(GetComplexNum(j, L, input), result_t2);
                    if(result_t2 == K)
                        break;
                }
                if(i < j && result_t1 == I && result_t2 == K)
                    found = true;
            }

            writer.write("Case #");
            writer.write("" + (_t + 1));
            writer.write(": ");
            writer.write(found?"YES":"NO");
            writer.newLine();
        }
        reader.close();
        writer.close();
        long t2 = System.currentTimeMillis();
        System.out.println("Time(s):"+(t2-t1)/1000);
    }
}
