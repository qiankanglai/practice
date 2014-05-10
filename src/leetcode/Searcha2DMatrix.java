package leetcode;

/**
 * Created by anthony on 5/10/14.
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1, mid=-1;
        while(start <= end){
            mid = (start+end)/2;
            if(matrix[mid][0] ==target) return true;
            if(matrix[mid][0] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        int row = (matrix[mid][0] > target)?(mid-1):mid;
        if(row < 0) return false;
        start = 0;
        end = matrix[row].length-1;
        while(start <= end){
            mid = (start+end)/2;
            if(matrix[row][mid] ==target) return true;
            if(matrix[row][mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return false;
    }
}
