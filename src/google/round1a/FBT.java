import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

//FBT by wudi

public class FBT {
    static int N;
    static int[] from;
    static int[] to;
    static int[][] child;
    static void fill(int index, int parent) {
        int count = 0;
        for (int i = 0; i < from.length; ++i) {
            if (from[i] == index && to[i] != parent) {
                ++count;
            } else if (to[i] == index && from[i] != parent) {
                ++count;
            }
        }
        child[index] = new int[count];
        for (int i = 0; i < from.length; ++i) {
            if (from[i] == index && to[i] != parent) {
                child[index][--count] = to[i];
                fill(to[i], index);
            } else if (to[i] == index && from[i] != parent) {
                child[index][--count] = from[i];
                fill(from[i], index);
            }
        }
    }
    static int search(int node) {
        int res = 1;
        if (child[node].length == 1) {
            return res;
        } {
            int[] arr = new int[child[node].length];
            for (int i = 0; i < child[node].length; ++i) {
                arr[i] = search(child[node][i]);
            }
            Arrays.sort(arr);
            for (int i = arr.length - 1; i >= 0 && i >= arr.length - 2; --i) {
                res += arr[i];
            }
        }
        return res;
    }
    
    static int solve(int root) {
        fill(root, -1);
        int sum = search(root);
        return N - sum;
    }
    
    public static void main(String[] args) throws Exception {
        FastScanner scan = new FastScanner(System.in);
        int taskCount = scan.nextInt();
        for (int taskIndex = 1; taskIndex <= taskCount; ++taskIndex) {
            N = scan.nextInt();
            from = new int[N - 1];
            to = new int[N - 1];
            for (int i = 0; i < from.length; ++i) {
                from[i] = scan.nextInt() - 1;
                to[i] = scan.nextInt() - 1;
            }
            child = new int[N][];
            int res = N;
            for (int i = 0; i < N; ++i) {
                res = Math.min(res, solve(i));
            }
            System.out.println(String.format("Case #%d: %d", taskIndex, res));
        }
    }
}

class FastScanner {
    BufferedReader in;
    StringTokenizer tok;
    
    public FastScanner(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
        tok = new StringTokenizer("");
    }
    
    private String tryReadNextLine() {
        try {
            return in.readLine();
        } catch (Exception e) {
            throw new InputMismatchException();
        }
    }
    
    public String nextToken() {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(next());
        }
        return tok.nextToken();
    }
    
    public String next() {
        String newLine = tryReadNextLine();
        if (newLine == null)
            throw new InputMismatchException();
        return newLine;
    }
    
    public int nextInt() {
        return Integer.parseInt(nextToken());
    }
    
    public double nextDouble() {
        return Double.parseDouble(nextToken());
    }
    
    public long nextLong() {
        return Long.parseLong(nextToken());
    }
    
}