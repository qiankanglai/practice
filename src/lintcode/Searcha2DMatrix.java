package lintcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/24.
 */
public class Searcha2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if(matrix == null)
            return false;
        int rows = matrix.size();
        if(rows == 0)
            return false;
        int cols = matrix.get(0).size();
        if(cols == 0)
            return false;
        int y = 0, x = cols - 1;
        while(y < rows && x >= 0){
            int p = matrix.get(y).get(x);
            if(p == target)
                return true;
            else if(p < target)
                y++;
            else
                x--;
        }
        return false;
    }
}
