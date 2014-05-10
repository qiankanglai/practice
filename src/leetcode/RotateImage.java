package leetcode;

/**
 * Created by anthony on 5/10/14.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n/2; i++) {
            for (int j = i; j < n - i-1; j++) {
                int a = matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i] = a;
            }
        }
    }

    public static void main(String args[]){
        int[][] matrix = new int[][]{new int[]{1,2}, new int[]{3,4}};
        new RotateImage().rotate(matrix);
    }
}
