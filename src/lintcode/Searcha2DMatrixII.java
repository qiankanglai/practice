package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/24.
 */
public class Searcha2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if(matrix == null)
            return 0;
        int rows = matrix.size();
        if(rows == 0)
            return 0;
        int cols = matrix.get(0).size();
        if(cols == 0)
            return 0;
        int y = 0, x = cols - 1;
        int count = 0;
        while(y < rows && x >= 0){
            int p = matrix.get(y).get(x);
            if(p == target) {
                count ++;
                y++;
                x--;
            }
            else if(p < target)
                y++;
            else
                x--;
        }
        return count;
    }
}
