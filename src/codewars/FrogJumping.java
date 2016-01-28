package codewars;

/**
 * Created by Anthony on 1/27/2016.
 */
public class FrogJumping {
    public static int solution(int[] a) {
        boolean []visited = new boolean[a.length];
        int count = 0, start = 0;
        if(a.length == 0) return -1;
        while(true)
        {
            if(start < 0 || start >= a.length) return count;
            if(visited[start]) return -1;
            visited[start] = true;
            start += a[start];
            count++;
        }
    }
}
