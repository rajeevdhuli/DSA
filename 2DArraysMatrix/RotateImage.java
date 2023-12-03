class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rotate = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                rotate[j][m-i-1] = matrix[i][j];
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n; j++){
                matrix[i][j] = rotate[i][j];
            }
        }
    }
}
