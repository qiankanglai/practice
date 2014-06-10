package leetcode;

/**
 * Created by Anthony on 2014/6/10.
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, columns = matrix[0].length;

        int row_ones[][] = new int[rows][columns];  //row_ones[i][j]表示从(i,j)开始横着连续多少个1
        for(int y = 0; y < rows; y++){
            int count = 0;
            for(int x = columns-1; x>=0; x--){
                if(matrix[y][x] == '1'){
                    count++;
                }
                else
                    count = 0;
                row_ones[y][x] = count;
            }
        }
        /*int column_ones[][] = new int[rows][columns];  //row_ones[i][j]表示从(i,j)开始竖着连续多少个1
        for(int x = 0; x < columns; x++){
            int count = 0;
            for(int y = rows-1; y >= 0; y--){
                if(matrix[y][x] == '1'){
                    count++;
                }
                else
                    count = 0;
                column_ones[y][x] = count;
            }
        }*/

        //有更好的算法！https://oj.leetcode.com/discuss/5198/a-o-n-2-solution-based-on-largest-rectangle-in-histogram
        //用一个栈维护一发就好
        int max = 0;
        for(int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if(row_ones[y][x] > 0){
                    for(int x_length = 1; x_length <= row_ones[y][x]; x_length++){
                        int y_length = 1;
                        while(y + y_length < rows && row_ones[y+y_length][x] >= x_length)
                            y_length++;
                        int m2 = y_length*x_length;
                        if(m2 > max)
                            max = m2;
                    }
                }
            }
        }

        return max;
    }
}
