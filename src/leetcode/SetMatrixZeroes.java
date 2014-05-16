package leetcode;

/**
 * Created by Anthony on 2014/5/16.
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int firstNonzeroRow = -1;
        for(int i = 0; i < m; i++) {
            boolean hasZero = false;
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0) {
                    hasZero = true;
                    break;
                }
            }
            if(!hasZero){
                firstNonzeroRow = i;
                break;
            }
        }
        //Find a row without zeros!
        if(firstNonzeroRow < 0){
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        else{
            for(int i = 0; i < m; i++) {
                if(i == firstNonzeroRow) continue;

                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == 0)
                        matrix[firstNonzeroRow][j] = 0;
                }
            }
            for(int i = 0; i < m; i++) {
                if(i == firstNonzeroRow) continue;
                boolean hasZero = false;
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        hasZero = true;
                    } else if (matrix[firstNonzeroRow][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
                if (hasZero) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
